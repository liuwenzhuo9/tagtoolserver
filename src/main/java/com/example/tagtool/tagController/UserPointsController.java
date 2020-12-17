package com.example.tagtool.tagController;

import com.example.tagtool.tagEntity.InferResult;
import com.example.tagtool.tagEntity.TasksInfo;
import com.example.tagtool.tagEntity.UserInfo;
import com.example.tagtool.tagEntity.UserPoints;
import com.example.tagtool.tagService.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RestController
public class UserPointsController {
    @Resource
    private UserPointsService userPointsService;
    @Resource
    private LabelResultService labelResultService;
    @Resource
    private InferResultServie inferResultServie;
    @Resource
    private TasksInfoService tasksInfoService;
    @Resource
    private UserInfoService userInfoService;

    //    插入人员积分变动信息
    @RequestMapping("/insertUserPoints")
    @ResponseBody
    public ResponseBean insertUserPoints(UserPoints userPoints){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(userPointsService.insertUserPoints(userPoints));
        responseBean.setMessage("插入成功");
        return responseBean;
    }

    //根据任务id删除积分信息
    @RequestMapping("/deleteUserPointsByTaskId")
    @ResponseBody
    public ResponseBean deleteUserPointsByTaskId(Integer task_id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("删除成功");
        responseBean.setData(userPointsService.deleteUserPointsByTaskId(task_id));
        return responseBean;
    }

    //    根据任务id和用户account删除积分信息
    @RequestMapping("/deleteUserPointsByAccount")
    @ResponseBody
    public ResponseBean deleteUserPointsByAccount(Integer task_id,String account){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("删除成功");
        responseBean.setData(userPointsService.deleteUserPointsByAccount(task_id, account));
        return responseBean;
    }
    //根据任务id和积分操作类型获取积分信息
    @RequestMapping("/findPointsByTaskId")
    @ResponseBody
    public ResponseBean findPointsByTaskId(Integer task_id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("查询成功");
        responseBean.setData(userPointsService.findPointsByTaskId(task_id));
        return responseBean;
    }
    //    根据用户account和任务类型以及积分操作类型获取积分信息
    @RequestMapping("/findPointsByAccount")
    @ResponseBody
    public ResponseBean findPointsByAccount(String account,Integer operation_type){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("查询成功");
        responseBean.setData(userPointsService.findPointsByAccount(account,operation_type));
        return responseBean;
    }

    //根据任务id和用户account更新积分和能力变动信息
    @RequestMapping("/updatePointsByTaskIdAndAccount")
    @ResponseBody
    public ResponseBean updatePointsByTaskIdAndAccount(UserPoints userPoints){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("更新成功");
        responseBean.setData(userPointsService.updatePointsByTaskIdAndAccount(userPoints));
        return responseBean;
    }

//    根据任务id更新参与用户的标注能力
    @RequestMapping("/updatePointsByTaskId")
    @ResponseBody
    public ResponseBean updatePointsByTaskId(Integer task_id){
//        1.从tb_label_result中获取每个用户正式任务的标注结果；2.从tb_infer_result中获取发布者确认的标注结果；3.计算每个用户的完成率和正确率；
//        4.计算用户获得的积分，在tb_user_points中根据用户account和任务id更新用户积分、完成率和power
//        5.更新tb_user_info中更新用户完成的任务、积分、power、完成率
        List<TasksInfo> info = tasksInfoService.findTaskById(task_id);
        TasksInfo taskInfo = info.get(0);
        //        taskType记录任务种类
        int taskType = taskInfo.getTask_type();
        //       total_reward记录任务报酬
        double total_reward = taskInfo.getTask_reward();
        //        peopleSum记录用户账号信息
        String[] peopleSum = taskInfo.getMember_account().split(",");
        //        peoLen任务的参与人数
        int peoLen = peopleSum.length;
        //       res每个人用户在该任务的标注结果
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < peoLen; i++) {
            List<String> k = labelResultService.findLabelResultByIsTest(task_id, peopleSum[i], 0);
            res.add(k);
        }
        List<InferResult> data = inferResultServie.findInferInfoByTaskId(task_id);
        //        finalResult存放发布者确认的标注结果
        List<String> finalResult = new ArrayList<>();
        //        content_len记录每个正式句子的长度，用于判断序列标注的正确率
        List<Integer> content_len = new ArrayList<>();
        for(int i = 0; i<data.size(); i++){
            finalResult.add(data.get(i).getFinal_result());
            if(taskType == 0){
                content_len.add(data.get(i).getContent().length());
            }
        }
        //        sentence_num正式任务句子个数
        int sentence_num = finalResult.size();
        //        peo_power记录参与者的正确率
        Double[] peo_power = new Double[peoLen];
        //        peo_complete_rate记录参与者的完成率
        Double[] peo_complete_rate = new Double[peoLen];
        for(int i = 0; i<peoLen; i++){
            double power = 0;
            int complete_num = 0;
            for(int j = 0; j<sentence_num; j++){
                String resStr = res.get(i).get(j);
                String keyStr = finalResult.get(j);
                if(resStr == null || resStr.equals("")){
                    continue;
                }
//                计算序列标注类型的正确率
                if(taskType == 0){
                    String[] resArr = getIndexTag(resStr, content_len.get(j));
                    String[] keyArr = getIndexTag(keyStr, content_len.get(j));
                    double f = sequence_acc(resArr, keyArr);
                    power += f;
                }
//                计算单标签标注类型的正确率
                if(taskType == 1){
                    if(resStr.equals(keyStr)){
                        power ++;
                    }
                }
//                计算量级标签标注的正确率
                if(taskType == 2){
                    power += order_label_acc(keyStr, resStr);
                }
//                计算多层次标签标注的正确率
                if(taskType == 3){
                    power += multi_label_acc(keyStr, resStr);
                }
                complete_num ++;
            }
            peo_power[i] = power / complete_num;
            peo_complete_rate[i] = (double)complete_num / sentence_num;
        }
        //        根据用户的正确率和完成率更新综合能力，作为积分分配的依据
        Double[] multi_power = new Double[peoLen];
        //       total_power 记录multi_power的总和
        double total_power = 0;
        for(int i = 0; i<peoLen; i++){
            if(peo_power[i] > 0.5 && peo_complete_rate[i] > 0.8){
                multi_power[i] = peo_power[i] * peo_complete_rate[i] * 1.5;
            }else if(peo_power[i] > 0.5 && peo_complete_rate[i] < 0.8 && peo_complete_rate[i] > 0.5){
                multi_power[i] = peo_power[i] * peo_complete_rate[i];
            }else{
                multi_power[i] = peo_power[i] * peo_complete_rate[i] * 2 / 3;
            }
            total_power += multi_power[i];
        }
        //       peo_reward 记录用户获得的积分奖励
        Double[] peo_reward = new Double[peoLen];
        for(int i = 0; i<peoLen; i++){
            double reward = total_reward * multi_power[i] / total_power;
            peo_reward[i] = reward;
            UserPoints userPoints = new UserPoints();
            userPoints.setAccount(peopleSum[i]);
            userPoints.setTask_id(task_id);
            userPoints.setOperation_type(1);
            userPoints.setPower(peo_power[i]);
            userPoints.setPoints(reward);
            userPoints.setComplete_rate(peo_complete_rate[i]);
        //           根据任务id和用户account更新积分和能力变动信息
            userPointsService.updatePointsByTaskIdAndAccount(userPoints);
            //        更新tb_user_info中更新用户完成的任务、积分、power、完成率
            UserInfo userInfo = userInfoService.findInfoByUserAccount(peopleSum[i]).get(0);
            double user_points = userInfo.getPoints() + reward;
            userInfoService.updatePointsByAccount(user_points, peopleSum[i]);
            if(taskType == 0){
                double powerS = userInfo.getPower_s();
                if(powerS == 0){
                    userInfo.setPower_s(peo_power[i]);
                }else{
                    userInfo.setPower_s((powerS + peo_power[i])/2);
                }
            }
            if(taskType == 1){
                double powerL1 = userInfo.getPower_l1();
                if(powerL1 == 0){
                    userInfo.setPower_l1(peo_power[i]);
                }else{
                    userInfo.setPower_l1((powerL1 + peo_power[i])/2);
                }
            }
            if(taskType == 2){
                double powerL2 = userInfo.getPower_l2();
                if(powerL2 == 0){
                    userInfo.setPower_l2(peo_power[i]);
                }else{
                    userInfo.setPower_l2((powerL2 + peo_power[i])/2);
                }
            }
            if(taskType == 3){
                double powerL3 = userInfo.getPower_l3();
                if(powerL3 == 0){
                    userInfo.setPower_l3(peo_power[i]);
                }else{
                    userInfo.setPower_l3((powerL3 + peo_power[i])/2);
                }
            }
            userInfo.setComplete_rate((userInfo.getComplete_rate() + peo_complete_rate[i])/2);
            userInfoService.updatePowerByAccount(userInfo);
        }
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("更新成功");
        return responseBean;
    }

    //    把用户序列标注的结果转换成数组存储
    public String[] getIndexTag(String str, Integer n) {
        String pattern = "\\{[^\\}]+\\}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        String[] res = new String[n];
        while (m.find()) {
            String shortM = m.group().substring(1,m.group().length()-1);
            String[] mArr = shortM.split(",");
            for(int i = Integer.parseInt(mArr[0]); i<Integer.parseInt(mArr[1]); i++){
                res[i] = mArr[3];
            }
        }
        return res;
    }

    //    计算用户序列标注的准确率和召回率
    public double sequence_acc(String[] str, String[] key) {
        int strNotNull = 0;
        int keyNotNull = 0;
        int right = 0;
        for(int i = 0; i<str.length; i++){
            if(str[i] != null ) {
                strNotNull++;
            }
            if(key[i] != null ) {
                keyNotNull++;
            }
            if(str[i] != null && key[i] != null && key[i].equals(str[i])){
                right++;
            }
        }
        Double acc = (double)right/keyNotNull;
        Double recall = (double)right/strNotNull;
        Double f = (double)2*acc*recall/(acc+recall);
        return f;
    }

    //    计算用户量级标签标注的准确率
    public double order_label_acc(String key, String res){
        String[] res_single = res.split(":");
        String[] key_single = key.split(":");
        if(res_single[0].equals(key_single[0])) {
            double dec = Math.abs(Double.parseDouble(res_single[1]) - Double.parseDouble(key_single[1]));
            return (1 - dec / Double.parseDouble(key_single[1]));
        }
        return 0.0;
    }

    //    计算用户多层次标签标注的准确率和召回率
    public double multi_label_acc(String key, String res) {
        String regex = "\\{([^}])*\\}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher1 = pattern.matcher(key);
        Matcher matcher2 = pattern.matcher(res);
        List<String> keyList = new ArrayList<>();
        List<String> resList = new ArrayList<>();
        while (matcher1.find()) {
            keyList.add(matcher1.group());
        }
        while (matcher2.find()) {
            resList.add(matcher2.group());
        }
        int keySize = keyList.size();
        int resSize = resList.size();
        int score = 0;
        for(int i = 0; i<resSize; i++){
            if(keyList.indexOf(resList.get(i)) != -1) {
                score++;
            }
        }
        if(score == 0){
            return 0;
        }
        double acc = (double)score/keySize;
        double recall = (double)score/resSize;
        double f = (double)2*acc*recall/(acc+recall);
        return f;
    }

}