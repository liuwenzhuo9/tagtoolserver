package com.example.tagtool.tagController;

import com.example.tagtool.tagEntity.*;
import com.example.tagtool.tagService.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class LabelResultController {
    @Resource
    private LabelResultService labelResultService;
    @Resource
    private TaskContentService taskContentService;
    @Resource
    private TasksInfoService tasksInfoService;
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private TimeService timeService;
    @Resource
    private InferResultServie inferResultServie;

    //插入用户的标注结果
    @RequestMapping("/insertLabelResult")
    @ResponseBody
    public ResponseBean insertLabelResult(LabelResult labelResult){
        int data = labelResultService.insertLabelResult(labelResult);
        if(data == 1){
            return new ResponseBean("插入成功",data);
        }else{
            return new ResponseBean("插入失败",data);
        }
    }
//根据标注的信息id更新标注信息
    @RequestMapping("/updateLabelById")
    @ResponseBody
    public ResponseBean updateLabelById(Integer id,String label_result){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("更新成功");
        responseBean.setData(labelResultService.updateLabelById(id,label_result));
        return responseBean;
    }
//根据标注者账号删除标注信息
    @RequestMapping("/deleteLabelByAccount")
    @ResponseBody
    public ResponseBean deleteLabelByAccount(String user_account){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(labelResultService.deleteLabelByAccount(user_account));
        responseBean.setMessage("删除成功");
        return responseBean;
    }
//根据任务id删除标注信息
    @RequestMapping("/deleteLabelByTaskId")
    @ResponseBody
    public ResponseBean deleteLabelByTaskId(Integer task_id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(labelResultService.deleteLabelByTaskId(task_id));
        responseBean.setMessage("删除成功");
        return responseBean;
    }
//根据任务id和用户account删除标注信息
    @RequestMapping("/deleteLabelByTaskIdAndAccount")
    @ResponseBody
    public ResponseBean deleteLabelByTaskIdAndAccount(String account,Integer task_id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(labelResultService.deleteLabelByTaskIdAndAccount(account, task_id));
        responseBean.setMessage("删除成功");
        return responseBean;
    }
//根据任务id和段落id查询标注结果
    @RequestMapping("/findLabelByTaskAndParagraph")
    @ResponseBody
    public ResponseBean findLabelByTaskAndParagraph(Integer task_id,Integer paragraph_id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("查询成功");
        responseBean.setData(labelResultService.findLabelByTaskAndParagraph(task_id, paragraph_id));
        return responseBean;
    }
//根据任务id和用户account查询已标注的段落数
    @RequestMapping("/findFinishParagraphNumByTaskId")
    @ResponseBody
    public ResponseBean findFinishParagraphNumByTaskId(Integer task_id,String user_account){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("查询成功");
        responseBean.setData(labelResultService.findFinishParagraphNumByTaskId(task_id, user_account));
        return responseBean;
    }
//根据任务id和用户account查询第一条未被标记的段落id
    @RequestMapping("/findFirstUnfinishedParagraph")
    @ResponseBody
    public ResponseBean findFirstUnfinishedParagraph(Integer task_id,String user_account){
        List<LabelResult> data = labelResultService.findFirstUnfinishedParagraph(task_id, user_account);
        ResponseBean responseBean = new ResponseBean();
        if(data.size() == 0){
            responseBean.setMessage("查找失败");
            responseBean.setData(0);
        }else{
            LabelResult dataLabel = data.get(0);
            responseBean.setMessage(taskContentService.findContentByParagraphId(dataLabel.getParagraph_id()));
            responseBean.setData(dataLabel);
        }
        return responseBean;
    }
//根据任务id、用户账号、当前段落位置找到下一条未被标记的段落
    @RequestMapping("/findNextUnfinishedParagraph")
    @ResponseBody
    public ResponseBean findNextUnfinishedParagraph(Integer task_id,String user_account,Integer paragraph_position){
        List<LabelResult> dataN = labelResultService.findNextUnfinishedParagraph(task_id, user_account,paragraph_position);
        ResponseBean responseBean = new ResponseBean();
        if(dataN.size() == 0){
            responseBean.setMessage("查找失败");
            responseBean.setData(0);
        }else{
            LabelResult dataNext = dataN.get(0);
            responseBean.setMessage(taskContentService.findContentByParagraphId(dataNext.getParagraph_id()));
            responseBean.setData(dataNext);
        }
        return responseBean;
    }
//根据任务id、用户账号、当前段落位置找到上一条未被标记的段落
    @RequestMapping("/findLastUnfinishedParagraph")
    @ResponseBody
    public ResponseBean findLastUnfinishedParagraph(Integer task_id,String user_account,Integer paragraph_position){
        List<LabelResult> dataL = labelResultService.findLastUnfinishedParagraph(task_id, user_account,paragraph_position);
        ResponseBean responseBean = new ResponseBean();
        if(dataL.size() == 0){
            responseBean.setMessage("查找失败");
            responseBean.setData(0);
        }else{
            LabelResult dataLast = dataL.get(0);
            responseBean.setMessage(taskContentService.findContentByParagraphId(dataLast.getParagraph_id()));
            responseBean.setData(dataLast);
        }
        return responseBean;
    }
//    根据任务id和用户account查询第一条段落
    @RequestMapping("/findFirstParagraph")
    @ResponseBody
    public ResponseBean findFirstParagraph(Integer task_id,String user_account){
        List<LabelResult> data = labelResultService.findFirstParagraph(task_id, user_account);
        ResponseBean responseBean = new ResponseBean();
        if(data.size() == 0){
            responseBean.setMessage("查找失败");
            responseBean.setData(0);
        }else{
            LabelResult dataLabel = data.get(0);
            responseBean.setMessage(taskContentService.findContentByParagraphId(dataLabel.getParagraph_id()));
            responseBean.setData(dataLabel);
        }
        return responseBean;
    }
//根据任务id、用户账号、当前段落位置找到下一条段落
    @RequestMapping("/findNextParagraph")
    @ResponseBody
    public ResponseBean findNextParagraph(Integer task_id,String user_account,Integer paragraph_position){
        List<LabelResult> dataN = labelResultService.findNextParagraph(task_id, user_account,paragraph_position);
        ResponseBean responseBean = new ResponseBean();
        if(dataN.size() == 0){
            responseBean.setMessage("查找失败");
            responseBean.setData(0);
        }else{
            LabelResult dataNext = dataN.get(0);
            responseBean.setMessage(taskContentService.findContentByParagraphId(dataNext.getParagraph_id()));
            responseBean.setData(dataNext);
        }
        return responseBean;
    }
//根据任务id、用户账号、当前段落位置找到上一条段落
    @RequestMapping("/findLastParagraph")
    @ResponseBody
    public ResponseBean findLastParagraph(Integer task_id,String user_account,Integer paragraph_position){
        List<LabelResult> dataL = labelResultService.findLastParagraph(task_id, user_account,paragraph_position);
        ResponseBean responseBean = new ResponseBean();
        if(dataL.size() == 0){
            responseBean.setMessage("查找失败");
            responseBean.setData(0);
        }else{
            LabelResult dataLast = dataL.get(0);
            responseBean.setMessage(taskContentService.findContentByParagraphId(dataLast.getParagraph_id()));
            responseBean.setData(dataLast);
        }
        return responseBean;
    }
//根据任务id和用户账号查询标注结果
    @RequestMapping("/findLabelResultByTaskIdAndAccount")
    @ResponseBody
    public ResponseBean findLabelResultByTaskIdAndAccount(Integer task_id,String user_account){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(labelResultService.findLabelResultByTaskIdAndAccount(task_id, user_account));
        responseBean.setMessage("查找成功");
        return responseBean;
    }
//根据任务id和用户账号查询段落长度
    @RequestMapping("/findParaLenByTaskIdAndAccount")
    @ResponseBody
    public List<Integer> findParaLenByTaskIdAndAccount(Integer task_id,String user_account){
        List<Integer> idInfo = labelResultService.findParaIdByTaskIdAndAccount(task_id, user_account);
        int idLen = idInfo.size();
        List<Integer> paraLen = new ArrayList<>();
        for(int i = 0; i<idLen; i++) {
            String content = taskContentService.findContentByParagraphId(idInfo.get(i));
            paraLen.add(content.length());
        }
        return paraLen;
    }
//    根据任务id、用户账号以及句子类型查询标注结果
    @RequestMapping("/findLabelResultByIsTest")
    @ResponseBody
    public ResponseBean findLabelResultByIsTest(Integer task_id,String user_account, Integer is_test){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(labelResultService.findLabelResultByIsTest(task_id, user_account, is_test));
        responseBean.setMessage("查找成功");
        return responseBean;
    }

//根据任务id预测标注结果
    @RequestMapping("/inferLabelResult")
    @ResponseBody
    public List<String> inferLabelResult(Integer task_id, Integer type){
        List<TasksInfo> info = tasksInfoService.findTaskById(task_id);
        TasksInfo taskInfo = info.get(0);
        //        peopleSum记录用户账号信息
        String[] peopleSum = taskInfo.getMember_account().split(",");
        //        power_l1/power_l2/power_l3/power_s分别记录用户标注能力（用于不含黄金数据的标注任务）
        Double[] power_l1 = new Double[peopleSum.length];
        Double[] power_l2 = new Double[peopleSum.length];
        Double[] power_l3 = new Double[peopleSum.length];
        Double[] power_s = new Double[peopleSum.length];
        List<String> people_account = new ArrayList<>();
        for(int i=0;i<peopleSum.length;i++)
        {
            List<UserInfo> userInfo = userInfoService.findInfoByUserAccount(peopleSum[i]);
            double p_l1 = userInfo.get(0).getPower_l1();
            double p_l2 = userInfo.get(0).getPower_l2();
            double p_l3 = userInfo.get(0).getPower_l3();
            double p_sequence = userInfo.get(0).getPower_s();
            if(p_l1 == 0){
                power_l1[i] = 0.5;
            }else{
                power_l1[i] = p_l1;
            }
            if(p_l2 == 0){
                power_l2[i] = 0.5;
            }else{
                power_l2[i] = p_l2;
            }
            if(p_l1 == 0){
                power_l3[i] = 0.5;
            }else{
                power_l3[i] = p_l3;
            }
            if(p_sequence == 0){
                power_s[i] = 0.5;
            }else{
                power_s[i] = p_sequence;
            }
            people_account.add(peopleSum[i]);
        }
        int peoLen = people_account.size();
        //        获取任务可选标签
        String[] tag = taskInfo.getTask_label().split(",");
        //       每个人用户在该任务的标注结果
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < peoLen; i++) {
            List<String> k = labelResultService.findLabelResultByTaskIdAndAccount(task_id, peopleSum[i]);
            res.add(k);
        }
//                记录每个段落的index长度
//        List<Integer> paragraph_len = findParaLenByTaskIdAndAccount(task_id, people_account.get(0));
        //        记录预测结果
        List<String> infer_res = new ArrayList<>();

        //        判断是否为带黄金数据的单标签标注任务
        if(taskInfo.getSds_name() != null && taskInfo.getSds_name() != "" && taskInfo.getTask_type()==1){
            //      黄金数据在任务中的位置
            String[] pos = taskInfo.getSds_pos().split(",");

            //      黄金数据的正确结果
            List<String> godKey = taskContentService.getTestLabelByTaskId(task_id);
            String[] god_key = godKey.toArray(new String[]{});

            //      推测真值
            List<String> a = label_result_1(people_account, pos, tag, res, god_key, task_id);
            infer_res = a;

        }

        //        判断是否为带黄金数据的序列标注任务
        if(taskInfo.getSds_name() != null && taskInfo.getSds_name() != "" && taskInfo.getTask_type()==0){
            //      黄金数据在任务中的位置
            String[] pos = taskInfo.getSds_pos().split(",");
            //      黄金数据的正确结果
            List<String> godKey = taskContentService.getTestLabelByTaskId(task_id);
            String[] god_key = godKey.toArray(new String[]{});
            List<String> a = label_result_2(people_account, tag,  res, pos,  god_key, task_id);
            infer_res = a;
        }

        //          判断是否为带黄金数据的量级标签标注任务
        if(taskInfo.getSds_name() != null && taskInfo.getSds_name() != "" && taskInfo.getTask_type()==2){
            //      黄金数据在任务中的位置
            String[] pos = taskInfo.getSds_pos().split(",");
            //      黄金数据的正确结果
            List<String> godKey = taskContentService.getTestLabelByTaskId(task_id);
            String[] god_key = godKey.toArray(new String[]{});
            List<String> a = label_result_3(people_account, pos,  tag, res,  god_key, type);
            infer_res = a;
        }

        //        判断是否为带黄金数据的多层次标签标注任务
        if(taskInfo.getSds_name() != null && taskInfo.getSds_name() != "" && taskInfo.getTask_type()==3){
            //      黄金数据在任务中的位置
            String[] pos = taskInfo.getSds_pos().split(",");
            //      黄金数据的正确结果
            List<String> godKey = taskContentService.getTestLabelByTaskId(task_id);
            String[] god_key = godKey.toArray(new String[]{});
            List<String> a = label_result_4(people_account, pos, taskInfo.getTask_label(), res,  god_key);
            infer_res = a;
        }

        //        判断是否为*不带*黄金数据的单标签标注任务
        if((taskInfo.getSds_name() == null || taskInfo.getSds_name() == "") && taskInfo.getTask_type()==1){
            //            根据原始的power和多数投票法预测的标注结果
            String[] key_1 = infer_label(people_account, tag, res, power_l1);
            //            根据时间和准确率更新用户加权，重新预测
            List<String> key_2 = update_infer_label(people_account,  task_id,  res,  key_1,  power_l1, tag);
            infer_res = key_2;
        }

        //        判断是否为*不带*黄金数据的序列标注任务
        if((taskInfo.getSds_name() == null || taskInfo.getSds_name() == "") && taskInfo.getTask_type()==0){
            //            根据原始的power和多数投票法预测的序列标注结果
            String[] key_1 = infer_sequence(people_account, tag,  res, power_s);
            //            根据时间和准确率更新用户加权，重新预测
            List<String> key_2 = update_infer_Sequence(people_account, task_id,  res,  key_1,  power_s, tag);
            infer_res = key_2;
        }

        //        判断是否为*不带*黄金数据的量级标签标注任务
        if((taskInfo.getSds_name() == null || taskInfo.getSds_name() == "") && taskInfo.getTask_type()==2){
            //            根据原始的power和多数投票法预测的量级标签标注任务结果
            List<String> key_1 = order_label_result(people_account, tag,  res, power_l2, type);
            infer_res = key_1;
        }

        //        判断是否为*不带*黄金数据的多层次标签标注任务
        if((taskInfo.getSds_name() == null || taskInfo.getSds_name() == "") && taskInfo.getTask_type()==3){
            //            根据原始的power和多数投票法预测的量级标签标注任务结果
            List<String> key_1 = multi_label_result(people_account, taskInfo.getTask_label(),  res, power_l3);
            infer_res = key_1;
        }

        //        获取每个任务正式任务的paragraph id和 content
        List<TaskContent> taskContent = taskContentService.findContentByTaskIdAndIsTest(task_id, 0);

        double[] ci = new double[res.size()];
        //            计算用户单标签标注的一致性ci
        if(taskInfo.getTask_type()==1){
            ci = labelCI(res, infer_res);
        }
        //        计算用户序列标注的一致性ci
        if(taskInfo.getTask_type()==0){
            ci = sequenceCI(infer_res, people_account);
        }
        //        计算用户量级标签标注的一致性ci
        if(taskInfo.getTask_type()==2){
            ci = orderCI(infer_res, res);
        }
        //        计算用户多层次标签标注的一致性ci
        if(taskInfo.getTask_type()==3){
            ci = multiCI(infer_res, res);
        }
//        将一致性检测的数值插入tb_infer_result中
        for(int i = 0; i<ci.length; i++){
//            System.out.println(ci[i]);
            inferResultServie.updateCIByPosition(task_id, i, ci[i]+"");
        }

        return infer_res;

    }

//    带黄金数据的标签标注结果合并方法
    public List<String> label_result_1(List<String> people_account, String[] pos, String[] tag, List<List<String>> res, String[] god_key, int task_id) {
        int peoLen = people_account.size();
        int gdLen = god_key.length;
         //        计算所有人的黄金数据准确率
        List<List<String>> god_res = new ArrayList<>();//记录所有人的黄金数据结果
        List<Double> p_score = new ArrayList<>();//记录所有人的黄金数据准确率
        int cnt = 0;
        for(int p = 0; p<peoLen; p++) {
            List<String> p_res = new ArrayList<>();//记录每个人的黄金数据结果
            int score = 0;
            for(int i = 0; i<gdLen; i++) {
                if(res.get(p - cnt).get(Integer.parseInt(pos[i]) - i).equals(god_key[i])){
                    score++;
                }
                p_res.add(res.get(p - cnt).get(Integer.parseInt(pos[i]) - i));//此时res中存放的是剔除了黄金数据后的正式标注结果
                res.get(p - cnt).remove(Integer.parseInt(pos[i]) - i);
            }
        //剔除准确率低于0.6的用户及其结果
            if((double)score / gdLen < 0.6) {
                res.remove(p - cnt);
                people_account.remove(p - cnt);
                cnt = cnt + 1;
            }else{
                p_score.add((double)score / gdLen);
                god_res.add(p_res);
            }
        }
        peoLen = people_account.size();
        //        计算每个黄金用例的难度，越小表示难度越大
        List<Double> diff = new ArrayList<>();
        for(int i = 0; i<gdLen; i++) {
            int score = 0;
            for(int j = 0; j<peoLen; j++) {
                if(god_res.get(j).get(i).equals(god_key[i])) {
                    score++;
                }
            }
            diff.add((double)score / peoLen);
        }
        //        根据黄金用例难度计算标注者能力
        List<Double> power = new ArrayList<>();
        Double total_power = 0.0;
        for(int i = 0; i<peoLen; i++) {
            Double score = 0.0;
            double e = 0.00001;
            for(int j = 0; j<gdLen; j++) {
                if(god_res.get(i).get(j).equals(god_key[j])) {
                    score = score + (double)1/(diff.get(j) + e);
                }else{
                    score = score - 1;
                }
            }
            total_power = total_power + score;
            power.add(score);
        }
        Double[] power_l = power.toArray(new Double[]{});
        //        第一次推测真值(不考虑用时和正确率)
        String[] key_1 = infer_label(people_account, tag, res, power_l);
        //        根据时间和正确率更新真值
        List<String> key_2 = update_infer_label(people_account,  task_id,  res,  key_1,  power_l, tag);
        return key_2;
    }

//    带黄金数据的序列标注结果合并方法
    public List<String> label_result_2(List<String> people_account, String[] tag, List<List<String>> res, String[] pos, String[] god_key, int task_id) {
        // 计算用户在黄金任务中的标注表现
        int peoLen = people_account.size();
        int gdLen = god_key.length;
        List<Double> p_score = new ArrayList<>();
        int cnt = 0;
        for(int p = 0 ;p<peoLen; p++) {
            double score = 0.0;
            for(int i = 0; i<gdLen; i++) {
                String[] resP = res.get(p - cnt).get(Integer.parseInt(pos[i]) - i).split(",");
                String[] godKeyP = god_key[i].split(",");
                double f = sequence_acc(resP, godKeyP);
                score += f;
                res.get(p - cnt).remove(Integer.parseInt(pos[i]) - i);
            }
            //        剔除正确率低于0.5的用户结果
            if(score / gdLen < 0.5) {
                res.remove(p - cnt);
                people_account.remove(p - cnt);
                cnt = cnt + 1;
            }else{
                p_score.add(score / gdLen);
            }
        }
        Double[] power = p_score.toArray(new Double[]{});
        //      预测标注结果(不考虑时间和正确率)
        String[] key_1 = infer_sequence(people_account, tag, res, power);
        //      根据时间和正确率更新权值，再次计算标注结果
        List<String> key_2 = update_infer_Sequence(people_account, task_id,  res,  key_1,  power, tag);
        return key_2;
    }

//    带黄金数据的量级标签结果合并方法
    public List<String> label_result_3(List<String> people_account, String[] pos, String[] tag, List<List<String>> res, String[] god_key, int type){
        int peoLen = people_account.size();
        int gdLen = god_key.length;
        List<List<String>> god_res = new ArrayList<>();
        List<Double> p_score = new ArrayList<>();
        int cnt = 0;
        for(int i = 0; i<peoLen; i++) {
            List<String> p_res = new ArrayList<>();
            double score = 0.0;
            for(int g = 0; g<gdLen; g++) {
                score += order_label_acc(god_key[g], res.get(i-cnt).get(Integer.parseInt(pos[g])-g));
                p_res.add(res.get(i - cnt).get(Integer.parseInt(pos[g]) - g));
                res.get(i - cnt).remove(Integer.parseInt(pos[g]) - g);
            }
            if((double)score / gdLen < 0.6) {
                res.remove(i - cnt);
                people_account.remove(i - cnt);
                cnt++;
            }else{
                p_score.add((double)score / gdLen);
                god_res.add(p_res);
            }
        }
        peoLen = people_account.size();
        List<Double> diff = new ArrayList<>();
        for(int i = 0; i<gdLen; i++) {
            double score = 0;
            for(int j = 0; j<peoLen; j++) {
                score += order_label_acc(god_key[i], god_res.get(j).get(i));
            }
            diff.add(score / gdLen);
        }
        Double[] power = new Double[peoLen];
        Double total_power = 0.0;
        for(int i = 0; i<peoLen; i++){
            double score = 0.0;
            double e = 0.00001;
            for(int j = 0; j<gdLen; j++){
                double s = order_label_acc(god_key[j], god_res.get(i).get(j));
                if(s == 0){
                    score -= 1;
                }else{
                    score += s * (double)1/(diff.get(j) + e);
                }
            }
            total_power = total_power + score;
            power[i] = score;
        }
        return order_label_result(people_account, tag, res, power, type);
    }

//    带黄金数据的多层次标签标注结果合并方法
    public List<String> label_result_4(List<String> people_account, String[] pos, String tag, List<List<String>> res, String[] god_key) {
        int peoLen = people_account.size();
        int gdLen = god_key.length;
        List<List<String>> god_res = new ArrayList<>();
        List<Double> p_score = new ArrayList<>();
        int cnt = 0;
        for(int i = 0; i<peoLen; i++) {
            List<String> p_res = new ArrayList<>();
            double score = 0.0;
            for(int g = 0; g<gdLen; g++) {
                score += multi_label_acc(god_key[g], res.get(i-cnt).get(Integer.parseInt(pos[g]) - g));
                p_res.add(res.get(i-cnt).get(Integer.parseInt(pos[g]) - g));
                res.get(i-cnt).remove(Integer.parseInt(pos[g]) - g);

            }
            if(score / gdLen < 0.6) {
                res.remove(i-cnt);
                people_account.remove(i-cnt);
                cnt++;
            }else{
                p_score.add(score / gdLen);
                god_res.add(p_res);
            }
        }
        peoLen = people_account.size();
//        diff根据用户的标注表现记录黄金用例的难度
        List<Double> diff = new ArrayList<>();
        for(int i = 0; i<gdLen; i++) {
            double score = 0;
            for(int j = 0; j<peoLen; j++) {
                score += multi_label_acc(god_key[i], god_res.get(j).get(i));
            }
            diff.add(score / gdLen);
        }
        Double[] power = new Double[peoLen];
        for(int i = 0; i<peoLen; i++){
            double score = 0.0;
            double e = 0.00001;
            for(int j = 0; j<gdLen; j++){
                double temp = multi_label_acc(god_key[i], god_res.get(i).get(j));
                if(score != 0){
                    score += temp * (double)1/(diff.get(j) + e);
                }else{
                    score -= 1;
                }
            }
            power[i] = score;
        }
        return multi_label_result(people_account, tag, res, power);
    }

//    把用户标注的结果转换成数组存储
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
    public double sequence_acc(String[] res, String[] key) {
        int resLen = res.length;
        int keyLen = key.length;
        int right = 0;
        List<String> keyList = List.of(key);
        for(int i = 0; i<resLen; i++) {
            if(keyList.indexOf(res[i]) != -1) {
                right++;
            }
        }
        if(right == 0){
            return 0;
        }
        Double acc = (double)right/keyLen;
        Double recall = (double)right/resLen;
        Double f = (double)2*acc*recall/(acc+recall);
        return f;
    }

//    计算用户单标签标注的准确率
    public double label_acc(String[] key, String[] res) {
        int score = 0;
        int len = key.length;
        for(int i = 0; i<len; i++){
            if(key[i].equals(res[i])){
                score++;
            }
        }
        return (double)score/len;
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

//    根据power合并单标签标注结果
    public String[] infer_label(List<String> people_account, String[] tag, List<List<String>> res,Double[] power){
        String[] answer = new String[res.get(0).size()];
        int peoLen = people_account.size();
        for(int i = 0; i<res.get(0).size(); i++) {
            Map<String,Double> arg =new HashMap<String,Double>();
            double max = 0.0;
            String maxStr = "";
            for(int j=0; j<tag.length; j++) {
                arg.put(tag[j], max);
            }
            for(int k = 0; k<peoLen; k++) {
                double a = arg.get(res.get(k).get(i));
                a = a + power[k];
                max = Math.max(max, a);
                if(max == a) {
                    maxStr = res.get(k).get(i);
                }
                arg.put(res.get(k).get(i), a);
            }
            answer[i] = maxStr;
        }
        return answer;
}

//    根据power合并序列标注结果
    public String[] infer_sequence(List<String> people_account, String[] tag, List<List<String>> res, Double[] power) {
        int peoLen = people_account.size();
        int sentenceLen = res.get(0).size();
        String[] answer = new String[sentenceLen];
        for(int i = 0; i<sentenceLen; i++){
            List<String> senAns = new ArrayList<>();
            List<Double> senAnsNum = new ArrayList<>();
            for(int p = 0; p<peoLen; p++){
                String[] temp = res.get(p).get(i).split(",");
                for(int j = 0; j<temp.length; j++){
                    if(senAns.indexOf(temp[j]) == -1){
                        senAns.add(temp[j]);
                        senAnsNum.add(power[p]);
                    }else{
                        int index = senAns.indexOf(temp[j]);
                        double num = senAnsNum.get(index);
                        num += power[p];
                        senAnsNum.set(index, num);
                    }
                }
            }
            int tagNum = senAns.size();
            for(int j = 0; j<tagNum; j++) {
                String temp = senAns.get(j) + '-' + senAnsNum.get(j);
                senAns.set(j, temp);
            }
            answer[i] = senAns.toString();
        }
        return answer;
    }

//    根据power合并量级标签标注结果
    public List<String> order_label_result(List<String> people_account, String[] tag, List<List<String>> res, Double[] power, Integer type){
        int peoLen = people_account.size();
        int sentenceLen = res.get(0).size();
        int tagNum = tag.length;
        List<String> answer = new ArrayList<>();
        String[][][] resRecord = new String[sentenceLen][tagNum][2];
        for(int i = 0; i<sentenceLen; i++){
            double[] times = new double[tagNum];
            double[] scores = new double[tagNum];
            for(int j = 0; j<peoLen; j++){
                String temp = res.get(j).get(i);
                String[] tempArr = temp.split(":");
                int index = getIndex(tag,tempArr[0]);
                times[index] += power[j] * 2;
                scores[index] += Double.parseDouble(tempArr[1]) * power[j] * 2;
            }
            String[][] senTemp = new String[tagNum][2];
            for(int k = 0; k<tagNum; k++){
                senTemp[k][0] = "" + times[k];
                senTemp[k][1] = "" + scores[k];
            }
            resRecord[i] = senTemp;
        }
        // explain
        // String[][][] resRecord = {{ {tag1's times, tag1's scores}, {tag1's times, tag1's scores},           }, //first sentence's label result
        // 						  	{},
        // 						  	{},
        // 						  	{}}
//        type == 0 表示标签出现的次数多少决定最终标签
        if(type == 0){
            String temp = "";
            for(int i = 0; i<sentenceLen; i++){
                double max = 0;
                double maxScore = 0.0;
                int maxIndex = 0;
                for(int j = 0; j<tagNum; j++){
                    max = Math.max(max, Double.parseDouble(resRecord[i][j][0]));
                    if(max == Double.parseDouble(resRecord[i][j][0])){
                        maxIndex = j;
                        maxScore = Double.parseDouble(resRecord[i][j][1]);
                    }
                }
                double resScore = maxScore / max;
                temp = tag[maxIndex] + ':' + resScore;
                answer.add(temp);
            }
        }
        //        type == 1 表示标签量级分数多少决定最终标签
        if(type == 1){
            String temp = "";
            for(int i = 0; i<sentenceLen; i++){
                double max = 0.0;
                double maxTimes = 0.0;
                int maxIndex = 0;
                for(int j = 0; j<tagNum; j++){
                    max = Math.max(max, Double.parseDouble(resRecord[i][j][1]));
                    if(max == Double.parseDouble(resRecord[i][j][1])){
                        maxIndex = j;
                        maxTimes = Double.parseDouble(resRecord[i][j][0]);
                    }
                }
                double resScore = max / maxTimes;
                temp = tag[maxIndex] + ':' + resScore;
                answer.add(temp);
            }
        }
        return answer;
    }

//    根据power合并多层次标签标注结果
    public List<String> multi_label_result(List<String> people_account, String tag, List<List<String>> res, Double[] power){
        int peoLen = people_account.size();
        int senLen = res.get(0).size();
        String regex = "\\{([^}])*\\}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(tag);
        List<String> firstTag = new ArrayList<>();
        List<List<String>> secondTag = new ArrayList<>();
        double total = 0.0;
        for(int i = 0; i<peoLen; i++){
            total += power[i];
        }
        while (matcher.find()) {
            String[] tagArr = matcher.group().substring(1,matcher.group().length()-1).split(":");
            firstTag.add(tagArr[0]);
            String[] secondTagArr = tagArr[1].split(",");
            List<String> temp = new ArrayList<>();
            for(int i = 0; i<secondTagArr.length; i++){
                temp.add(secondTagArr[i]);
            }
            secondTag.add(temp);
        }
        // initialize tagNum
        double[][][] tagNum = new double[senLen][][];
        for(int j = 0; j<senLen; j++){
            double[][] secondTagNum = new double[firstTag.size()][];
            for(int i = 0; i<firstTag.size(); i++){
                double[] thirdTagNum = new double[secondTag.get(i).size()];
                secondTagNum[i] = thirdTagNum;
            }
            tagNum[j] = secondTagNum;
        }

        for(int i = 0; i<senLen; i++){
            for(int j = 0; j<peoLen; j++){
                String tempRes = res.get(j).get(i);
                Matcher matcherPer = pattern.matcher(tempRes);
                while(matcherPer.find()) {
                    String[] tagResPer = matcherPer.group().substring(1, matcherPer.group().length()-1).split(",");
                    int firstIndex = firstTag.indexOf(tagResPer[0]);
                    int secondIndex = secondTag.get(firstIndex).indexOf(tagResPer[1]);
                    tagNum[i][firstIndex][secondIndex] += power[j];
                }
            }
        }


        // {1,1-3},{2,2-2},{3,3-4}
        // explain
        // tagNum = {{first sentence { first level}, {second level }, {third level }, ...     },{second sentence { first level}, {second level }, {third level }, ...       },{third sentence        }};
        // find right label by tagNum
        List<String> ans = new ArrayList<>();
        // List<List<String>> ans = new ArrayList<>();
        for(int k=0; k<senLen; k++){
            String tempAns = "";
            // List<String> tempAns = new ArrayList<>();
            for(int m =0; m<firstTag.size(); m++){
                double max = 0.0;
                String maxTag = "";
                for(int n = 0; n<secondTag.get(m).size(); n++){
                    // System.out.println(tagNum[k][m][n]);
                    max = Math.max(tagNum[k][m][n], max);
                    maxTag = max == tagNum[k][m][n] ? secondTag.get(m).get(n) : maxTag;
                }
                tempAns += "{" + firstTag.get(m) + "," + maxTag + "},";
            }
            ans.add(tempAns.substring(0, tempAns.length()-1));
        }
        return ans;

    }

//    计算用户用时和平均用时的关系
    public Double[] time_count(List<String> people_account, Integer task_id){
        int peoLen = people_account.size();
        int[] time_single = new int[peoLen];
        Double[] time_ratio = new Double[peoLen];
        int total_time = 0;
        for(int i = 0; i<peoLen; i++){
            int t = timeService.getLabelTimeByAccount(people_account.get(i), task_id).get(0).getUse_time();
            time_single[i] = t;
            total_time += t;
        }
        double average_time = (double)total_time/peoLen;
        for(int j = 0; j<peoLen; j++){
            time_ratio[j] = (double)time_single[j]/average_time;
        }
        return time_ratio;
    }

//    根据时间和正确率更新*标签标注*的power权值，并更新预测结果
    public List<String> update_infer_label(List<String> people_account, Integer task_id, List<List<String>> res, String[] key_1, Double[] power_l,String[] tag){
        int peoLen = people_account.size();
        Double[] time_rate = time_count(people_account, task_id);
        Double[] acc_rate = new Double[peoLen];
        for(int i = 0; i<peoLen; i++){
            String[] user_res = res.get(i).toArray(new String[]{});
            Double rate = label_acc(key_1, user_res);
            acc_rate[i] = rate;
            if(time_rate[i] <= 0.7 && acc_rate[i] >= 0.9){
                power_l[i] = power_l[i] * (time_rate[i] + acc_rate[i]);
            }
            if(time_rate[i] <= 0.7 && acc_rate[i] <= 0.6){
                power_l[i] = (acc_rate[i] - time_rate[i]) > 0 ? (power_l[i] * (acc_rate[i] - time_rate[i])) : 0;
            }
            if(time_rate[i] >= 1.3 && acc_rate[i] >= 0.9){
                power_l[i] = (acc_rate[i] - (time_rate[i]-1)/3) > 0 ? (power_l[i] * (acc_rate[i] - (time_rate[i]-1)/3)) : 0;
            }
            if(time_rate[i] >= 1.3 && acc_rate[i] <= 0.6){
                power_l[i] = (acc_rate[i] - (time_rate[i]-1)) > 0 ? (power_l[i] * (acc_rate[i] - (time_rate[i]-1))) : 0;
            }
        }
       //        第二次推测真值（考虑时间和正确率）
        String[] key_2 = infer_label(people_account, tag, res, power_l);
        List<String> answer = new ArrayList<>();
        for(int i = 0; i<key_2.length; i++){
            answer.add(key_2[i]);
        }
        return answer;
    }

//    根据时间和正确率更新*序列标注*的power权值，并更新预测结果
    public List<String> update_infer_Sequence(List<String> people_account, Integer task_id, List<List<String>> res, String[] key_1, Double[] power_s,String[] tag){
        int peoLen = people_account.size();
        int paraNum = res.get(0).size();
        Double[] time_rate = time_count(people_account, task_id);
        Double[] acc_rate = new Double[peoLen];
        for(int i = 0; i<peoLen; i++){
            double score = 0.0;
            for(int j = 0; j<paraNum; j++){
                String[] peoRes = res.get(i).get(j).split(",");
                String[] peoKey = key_1[j].split(",");
                double f = sequence_acc(peoRes, peoKey);
                score += f;
            }
            acc_rate[i] = score/paraNum;

            if(time_rate[i] <= 0.7 && acc_rate[i] >= 0.9){
                power_s[i] = power_s[i] * (time_rate[i] + acc_rate[i]);
            }
            if(time_rate[i] <= 0.7 && acc_rate[i] <= 0.6){
                power_s[i] = (acc_rate[i] - time_rate[i]) > 0 ? (power_s[i] * (acc_rate[i] - time_rate[i])) : 0;
            }
            if(time_rate[i] >= 1.3 && acc_rate[i] >= 0.9){
                power_s[i] = (acc_rate[i] - (time_rate[i]-1)/3) > 0 ? (power_s[i] * (acc_rate[i] - (time_rate[i]-1)/3)) : 0;
            }
            if(time_rate[i] >= 1.3 && acc_rate[i] <= 0.6){
                power_s[i] = (acc_rate[i] - (time_rate[i]-1)) > 0 ? (power_s[i] * (acc_rate[i] - (time_rate[i]-1))): 0;
            }
        }
        //        第二次预测（考虑时间和正确率）
        String[] key_2 = infer_sequence(people_account, tag, res, power_s);
        List<String> answer = new ArrayList<>();
        for(int i = 0; i<key_2.length; i++){
            answer.add(key_2[i]);
        }
        return answer;
    }

//    计算序列标注的用户结果一致性
    public double[] sequenceCI(List<String> key, List<String> people_account)  {
        int sentenceLen = key.size();
        int peoLen = people_account.size();
        double[] ans = new double[sentenceLen];
        for(int i = 0; i<sentenceLen; i++){
            String[] senTagArr = key.get(i).split(",");
            int tagNum = senTagArr.length;
            double score = 0;
            for(int j = 0; j<tagNum; j++){
                String[] temp = senTagArr[j].split("-");
                score += Double.parseDouble(temp[4]);
            }
            score /= peoLen*tagNum;
            ans[i] = score;
        }
        return ans;
    }

//    计算标签标注的用户结果一致性
    public double[] labelCI(List<List<String>> res, List<String> key){
        int peopleLen = res.size();
        int sentenceLen = key.size();
        double[] sentenceCI = new double[sentenceLen];
        for(int i = 0; i<sentenceLen; i++){
            int ci = 0;
            for(int j = 0; j<peopleLen; j++){
                if(res.get(j).get(i).equals(key.get(i))){
                    ci++;
                }
            }
            double singleCI = (double)ci/peopleLen;
            if(singleCI < 0.3){
                singleCI = (double)singleCI*singleCI;
            }
            sentenceCI[i] = singleCI;
        }
        return sentenceCI;
    }

//    计算量级标签标注的用户结果一致性
    public double[] orderCI(List<String> key, List<List<String>> res) {
        int sentenceLen = key.size();
        int peoLen = res.size();
        double[] ci = new double[sentenceLen];
        for(int i = 0; i<sentenceLen; i++){
            double ciScore = 0.0;
            for(int j = 0; j<peoLen; j++) {
                ciScore += order_label_acc(key.get(i), res.get(j).get(i));
            }
            ci[i] = ciScore / peoLen;
        }
        return ci;
    }

//    计算多层次标签标注用户结果一致性
    public double[] multiCI(List<String> key, List<List<String>> res) {
        int peoLen = res.size();
        int sentenceLen = key.size();
        double[] ci = new double[sentenceLen];
        for(int i = 0; i<sentenceLen; i++) {
            double score = 0.0;
            for(int j =0; j<peoLen; j++) {
                score += multi_label_acc(key.get(i), res.get(j).get(i));
            }
            ci[i] = score/ peoLen;
        }
        return ci;
    }

//    获取元素在数组中的索引值
    public static int getIndex(String[] arr, String value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }
}