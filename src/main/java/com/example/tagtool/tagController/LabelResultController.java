package com.example.tagtool.tagController;

import com.example.tagtool.tagEntity.*;
import com.example.tagtool.tagService.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DecimalFormat;
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
    private UserService userService;
    @Resource
    private TimeService timeService;
    @Resource
    private InferResultServie inferResultServie;

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

    @RequestMapping("/updateLabelById")
    @ResponseBody
    public ResponseBean updateLabelById(Integer id,String label_result){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("更新成功");
        responseBean.setData(labelResultService.updateLabelById(id,label_result));
        return responseBean;
    }

    @RequestMapping("/deleteLabelByAccount")
    @ResponseBody
    public ResponseBean deleteLabelByAccount(String user_account){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(labelResultService.deleteLabelByAccount(user_account));
        responseBean.setMessage("删除成功");
        return responseBean;
    }

    @RequestMapping("/deleteLabelByTaskId")
    @ResponseBody
    public ResponseBean deleteLabelByTaskId(Integer task_id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(labelResultService.deleteLabelByTaskId(task_id));
        responseBean.setMessage("删除成功");
        return responseBean;
    }

    @RequestMapping("/deleteLabelByTaskIdAndAccount")
    @ResponseBody
    public ResponseBean deleteLabelByTaskIdAndAccount(String account,Integer task_id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(labelResultService.deleteLabelByTaskIdAndAccount(account, task_id));
        responseBean.setMessage("删除成功");
        return responseBean;
    }

    @RequestMapping("/findLabelByTaskAndParagraph")
    @ResponseBody
    public ResponseBean findLabelByTaskAndParagraph(Integer task_id,Integer paragraph_id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("查询成功");
        responseBean.setData(labelResultService.findLabelByTaskAndParagraph(task_id, paragraph_id));
        return responseBean;
    }

    @RequestMapping("/findFinishParagraphNumByTaskId")
    @ResponseBody
    public ResponseBean findFinishParagraphNumByTaskId(Integer task_id,String user_account){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("查询成功");
        responseBean.setData(labelResultService.findFinishParagraphNumByTaskId(task_id, user_account));
        return responseBean;
    }

    @RequestMapping("/findFirstUnfinishedParagraph")
    @ResponseBody
    public ResponseBean findFirstUnfinishedParagraph(Integer task_id,String user_account){
        List<LabelResult> data = labelResultService.findFirstUnfinishedParagraph(task_id, user_account);
        LabelResult dataLabel = data.get(0);
        int resultId = dataLabel.getId();
        int[] arr =new int[2];
        arr[0] = resultId;
        arr[1] = dataLabel.getParagraph_position();
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage(taskContentService.findContentByParagraphId(dataLabel.getParagraph_id()));
        responseBean.setData(arr);
        return responseBean;
    }

    @RequestMapping("/findNextUnfinishedParagraph")
    @ResponseBody
    public ResponseBean findNextUnfinishedParagraph(Integer task_id,String user_account,Integer paragraph_position){
        List<LabelResult> dataN = labelResultService.findNextUnfinishedParagraph(task_id, user_account,paragraph_position);
        LabelResult dataNext = dataN.get(0);
        int resultId = dataNext.getId();
        int[] arr =new int[2];
        arr[0] = resultId;
        arr[1] = dataNext.getParagraph_position();
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage(taskContentService.findContentByParagraphId(dataNext.getParagraph_id()));
        responseBean.setData(arr);
        return responseBean;
    }

    @RequestMapping("/findLastUnfinishedParagraph")
    @ResponseBody
    public ResponseBean findLastUnfinishedParagraph(Integer task_id,String user_account,Integer paragraph_position){
        List<LabelResult> dataL = labelResultService.findLastUnfinishedParagraph(task_id, user_account,paragraph_position);
        LabelResult dataLast = dataL.get(0);
        int resultId = dataLast.getId();
        int[] arr =new int[2];
        arr[0] = resultId;
        arr[1] = dataLast.getParagraph_position();
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage(taskContentService.findContentByParagraphId(dataLast.getParagraph_id()));
        responseBean.setData(arr);
        return responseBean;
    }

    @RequestMapping("/findFirstParagraph")
    @ResponseBody
    public ResponseBean findFirstParagraph(Integer task_id,String user_account){
        List<LabelResult> data = labelResultService.findFirstParagraph(task_id, user_account);
        LabelResult dataLabel = data.get(0);
        int resultId = dataLabel.getId();
        int[] arr =new int[2];
        arr[0] = resultId;
        arr[1] = dataLabel.getParagraph_position();
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage(taskContentService.findContentByParagraphId(dataLabel.getParagraph_id()));
        responseBean.setData(arr);
        return responseBean;
    }

    @RequestMapping("/findNextParagraph")
    @ResponseBody
    public ResponseBean findNextParagraph(Integer task_id,String user_account,Integer paragraph_position){
        List<LabelResult> dataN = labelResultService.findNextParagraph(task_id, user_account,paragraph_position);
        LabelResult dataNext = dataN.get(0);
        int resultId = dataNext.getId();
        int[] arr =new int[2];
        arr[0] = resultId;
        arr[1] = dataNext.getParagraph_position();
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage(taskContentService.findContentByParagraphId(dataNext.getParagraph_id()));
        responseBean.setData(arr);
        return responseBean;
    }

    @RequestMapping("/findLastParagraph")
    @ResponseBody
    public ResponseBean findLastParagraph(Integer task_id,String user_account,Integer paragraph_position){
        List<LabelResult> dataL = labelResultService.findLastParagraph(task_id, user_account,paragraph_position);
        LabelResult dataLast = dataL.get(0);
        int resultId = dataLast.getId();
        int[] arr =new int[2];
        arr[0] = resultId;
        arr[1] = dataLast.getParagraph_position();
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage(taskContentService.findContentByParagraphId(dataLast.getParagraph_id()));
        responseBean.setData(arr);
        return responseBean;
    }

    @RequestMapping("/findLabelResultByTaskIdAndAccount")
    @ResponseBody
    public ResponseBean findLabelResultByTaskIdAndAccount(Integer task_id,String user_account){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(labelResultService.findLabelResultByTaskIdAndAccount(task_id, user_account));
        responseBean.setMessage("查找成功");
        return responseBean;
    }

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

    @RequestMapping("/inferLabelResult")
    @ResponseBody
    public ResponseBean inferLabelResult(Integer task_id){
        List<TasksInfo> info = tasksInfoService.findTaskById(task_id);
        TasksInfo taskInfo = info.get(0);
        //        peopleSum记录用户账号信息
        String[] peopleSum = taskInfo.getMember_account().split(",");
        //        power_l/power_s记录用户标注能力（用于不含黄金数据的标注任务）
        Double[] power_l = new Double[peopleSum.length];
        Double[] power_s = new Double[peopleSum.length];
        List<String> people_account = new ArrayList<>();
        for(int i=0;i<peopleSum.length;i++)
        {
            List<User> userInfo = userService.findInfoByUserAccount(peopleSum[i]);
            String p_label = userInfo.get(0).getPower_l();
            String p_sequence = userInfo.get(0).getPower_s();
            if(p_label == null || p_label.equals("")){
                power_l[i] = 0.0;
            }else{
                power_l[i] = Double.parseDouble(p_label);
            }
            if(p_sequence == null || p_sequence.equals("")){
                power_s[i] = 0.0;
            }else{
                power_s[i] = Double.parseDouble(p_sequence);
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
        //        记录每个段落的index长度
        List<Integer> paragraph_len = findParaLenByTaskIdAndAccount(task_id, people_account.get(0));
        //        记录预测结果
        List<String> infer_res = new ArrayList<>();

        //        判断是否为带黄金数据的标签标注任务
        if(taskInfo.getSds_name() != null && taskInfo.getSds_name() != "" && taskInfo.getTask_type().equals("标签标注")){
            //      黄金数据在任务中的位置
            String[] pos = taskInfo.getSds_pos().split(",");

            //      黄金数据的正确结果
            List<String> godKey = taskContentService.getTestLabelByTaskId(task_id);
            String[] god_key = godKey.toArray(new String[]{});

            //      推测真值
            List<String> a = label_result_1(people_account, pos, tag, res, god_key, task_id);
            infer_res = a;

//            更新用户的power_l
//            for(int p = 0; p<peoLen; p++){
//                String[] infer_key_toArr = a.toArray(new String[]{});
//                String[] res_toArr = res.toArray(new String[]{});
//                double p_score = label_acc(infer_key_toArr, res_toArr);
//                User user = userService.findInfoByUserAccount(people_account.get(p)).get(0);
//                String new_label_scores = user.getLabel_scores() + "," + p_score;
//                String[] score_arr = new_label_scores.split(",");
//                double new_power_l = (Double.parseDouble(user.getPower_l()) + p_score)/score_arr.length;
//                userService.updateLabelPowerByUserAccount(people_account.get(p),String.valueOf(new_power_l));
//                userService.updateLabelScoresByUserAccount(people_account.get(p),new_label_scores);
//            }
        }

        //        判断是否为带黄金数据的序列标注任务
        if(taskInfo.getSds_name() != null && taskInfo.getSds_name() != "" && taskInfo.getTask_type().equals("序列标注")){
            //      黄金数据在任务中的位置
            String[] pos = taskInfo.getSds_pos().split(",");
            //      黄金数据的正确结果
            List<String> godKey = taskContentService.getTestLabelByTaskId(task_id);
            String[] god_key = godKey.toArray(new String[]{});
            List<String> a = label_result_2(people_account, tag,  res, pos,  god_key, paragraph_len, task_id);
            infer_res = a;
//            for(int p = 0; p<peoLen; p++){
//                double total_score = 0.0;
//                for(int j = 0; j<res.get(p).size(); j++){
//                    String[] res_index = getIndexTag(res.get(p).get(j), paragraph_len.get(j));
//                    total_score += sequence_acc(res_index, infer_res.get(j).split(","));
//                }
//                User user = userService.findInfoByUserAccount(people_account.get(p)).get(0);
//                String new_sequence_scores = user.getSequence_scores() + "," + total_score/res.get(p).size();
//                String[] score_arr = new_sequence_scores.split(",");
//                double new_power_s = (Double.parseDouble(user.getPower_l()) + total_score/res.get(p).size())/score_arr.length;
//                userService.updateLabelPowerByUserAccount(people_account.get(p),String.valueOf(new_power_s));
//                userService.updateLabelScoresByUserAccount(people_account.get(p),new_sequence_scores);
//            }
        }


        //        判断是否为*不带*黄金数据的标签标注任务
        if((taskInfo.getSds_name() == null || taskInfo.getSds_name() == "") && taskInfo.getTask_type().equals("标签标注")){
            //            根据原始的power和多数投票法预测的标注结果
            String[] key_1 = infer_label(people_account, tag, res, power_l);
            //            根据时间和准确率更新用户加权，重新预测
            List<String> key_2 = update_infer_label(people_account,  task_id,  res,  key_1,  power_l, tag);
            infer_res = key_2;

//            更新用户power_l
//            for(int p = 0; p<peoLen; p++){
//                String[] infer_key_toArr = key_2.toArray(new String[]{});
//                String[] res_toArr = res.toArray(new String[]{});
//                double p_score = label_acc(infer_key_toArr, res_toArr);
//                User user = userService.findInfoByUserAccount(people_account.get(p)).get(0);
//                String new_label_scores = user.getLabel_scores() + "," + p_score;
//                String[] score_arr = new_label_scores.split(",");
//                double new_power_l = (Double.parseDouble(user.getPower_l()) + p_score)/score_arr.length;
//                userService.updateLabelPowerByUserAccount(people_account.get(p),String.valueOf(new_power_l));
//                userService.updateLabelScoresByUserAccount(people_account.get(p),new_label_scores);
//            }
        }


        //        判断是否为*不带*黄金数据的序列标注任务
        if((taskInfo.getSds_name() == null || taskInfo.getSds_name() == "") && taskInfo.getTask_type().equals("序列标注")){
            //            根据原始的power和多数投票法预测的序列标注结果
            String[] key_1 = infer_sequence(people_account, tag,  res, paragraph_len, power_s);
            //            根据时间和准确率更新用户加权，重新预测
            List<String> key_2 = update_infer_Sequence(people_account, task_id,  res,  key_1,  power_s, tag,  paragraph_len);
            infer_res = key_2;
////            更新用户power_s
//            for(int p = 0; p<peoLen; p++){
//                double total_score = 0.0;
//                for(int j = 0; j<res.get(p).size(); j++){
//                    String[] res_index = getIndexTag(res.get(p).get(j), paragraph_len.get(j));
//                    total_score += sequence_acc(res_index, infer_res.get(j).split(","));
//                }
//                User user = userService.findInfoByUserAccount(people_account.get(p)).get(0);
//                String new_sequence_scores = user.getSequence_scores() + "," + total_score/res.get(p).size();
//                String[] score_arr = new_sequence_scores.split(",");
//                double new_power_s = (Double.parseDouble(user.getPower_l()) + total_score/res.get(p).size())/score_arr.length;
//                userService.updateLabelPowerByUserAccount(people_account.get(p),String.valueOf(new_power_s));
//                userService.updateLabelScoresByUserAccount(people_account.get(p),new_sequence_scores);
//            }
        }

//        //        获取每个任务正式任务的paragraph id和 content
//        List<TaskContent> taskContent = taskContentService.findContentByTaskIdAndIsTest(task_id, 0);
//        //        插入tb_infer_result中
//        for(int i = 0; i< taskContent.size(); i++){
//            InferResult infer = new InferResult();
//            infer.setTask_id(task_id);
//            infer.setParagraph_id(taskContent.get(i).getId());
//            infer.setParagraph_position(taskContent.get(i).getParagraph_position());
//            infer.setInfer_result(infer_res.get(i));
//            infer.setTask_type(taskContent.get(i).getTask_type());
//            infer.setContent(taskContent.get(i).getContent());
//            inferResultServie.insertInferResult(infer);
//        }

        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(infer_res);
        responseBean.setMessage("推测成功");
        return responseBean;

    }

//    带黄金数据的标签标注结果预测方法
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

//    带黄金数据的序列标注结果预测算法
    public List<String> label_result_2(List<String> people_account, String[] tag, List<List<String>> res, String[] pos, String[] god_key, List<Integer> paragraph_len, int task_id) {
        // 计算用户在黄金任务中的标注表现
        int peoLen = people_account.size();
        int gdLen = god_key.length;
        List<Double> p_score = new ArrayList<>();
        int cnt = 0;
        for(int p = 0 ;p<peoLen; p++) {
            double score = 0.0;
            for(int i = 0; i<gdLen; i++) {
                int gdParaLen = paragraph_len.get(Integer.parseInt(pos[i]));
                String resP = res.get(p - cnt).get(Integer.parseInt(pos[i]) - i);
                String godKeyP = god_key[i];
                if(resP != null) {
                    String[] resPArr = getIndexTag(resP, gdParaLen);
                    String[] gokKeyPArr = getIndexTag(godKeyP, gdParaLen);
                    double f = sequence_acc(resPArr, gokKeyPArr);
                    score += f;
                    res.get(p - cnt).remove(Integer.parseInt(pos[i]) - i);
                }
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
        //      删除黄金数据的段落长度
        for(int n = 0; n<gdLen; n++) {
            paragraph_len.remove(Integer.parseInt(pos[n]) - n);
        }
        Double[] power = p_score.toArray(new Double[]{});
        //      预测标注结果(不考虑时间和正确率)
        String[] key_1 = infer_sequence(people_account, tag, res, paragraph_len, power);
        //      根据时间和正确率更新权值，再次计算标注结果
        List<String> key_2 = update_infer_Sequence(people_account, task_id,  res,  key_1,  power, tag,  paragraph_len);
        return key_2;
    }

//    把用户标注的结果转换成数组存储
    public String[] getIndexTag(String str, int n) {
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

//    计算用户标签标注的准确率
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

//    推测标签标注结果
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

//    推测序列标注结果
    public String[] infer_sequence(List<String> people_account, String[] tag, List<List<String>> res, List<Integer> paragraph_len, Double[] power) {
        int peoLen = people_account.size();
        String[] answer = new String[res.get(0).size()];
        for(int i = 0; i<res.get(0).size(); i++){
            List<String> answerAtI = new ArrayList<>();
            int gdParaLen = paragraph_len.get(i);
            String[][] sumResAtI = new String[peoLen][gdParaLen];
            for(int k = 0; k<peoLen; k++){
                String[] resPArr = getIndexTag(res.get(k).get(i), gdParaLen);
                sumResAtI[k] = resPArr;
            }
            for(int j = 0; j<gdParaLen; j++){
                Map<String,Double> arg =new HashMap<String,Double>();
                double max = 0.0;
                String maxTag = "";
                for(int m=0; m<tag.length; m++) {
                    arg.put(tag[m], max);
                }
                arg.put(null,max);
                for(int k = 0; k<peoLen; k++) {
                    double a = arg.get(sumResAtI[k][j]);
                    a += power[k] <= 0.0 ? 0.5 : power[k];
                    max = Math.max(max, a);
                    if(max == a) {
                        maxTag = sumResAtI[k][j];
                    }
                    arg.put(sumResAtI[k][j], a);
                }
                answerAtI.add(maxTag);
            }
            String[] ret = answerAtI.toArray(new String[]{});
            answer[i] = Arrays.toString(ret);
        }
        return answer;
    }

//    计算用户用时和平均用时的关系
    public Double[] time_count(List<String> people_account, int task_id){
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
    public List<String> update_infer_label(List<String> people_account, int task_id, List<List<String>> res, String[] key_1, Double[] power_l,String[] tag){
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
    public List<String> update_infer_Sequence(List<String> people_account, int task_id, List<List<String>> res, String[] key_1, Double[] power_s,String[] tag, List<Integer> paragraph_len){
        int peoLen = people_account.size();
        int paraNum = paragraph_len.size();
        Double[] time_rate = time_count(people_account, task_id);
        Double[] acc_rate = new Double[peoLen];
        for(int i = 0; i<peoLen; i++){
            double score = 0.0;
            for(int j = 0; j<paraNum; j++){
                int paraLen = paragraph_len.get(j);
                String peoRes = res.get(i).get(j);
                String peoKey = key_1[j];
                String[] peoResArr = getIndexTag(peoRes, paraLen);
                String[] peoKeyArr = getIndexTag(peoKey, paraLen);
                double f = sequence_acc(peoResArr, peoKeyArr);
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
        String[] key_2 = infer_sequence(people_account, tag, res, paragraph_len, power_s);
        List<String> answer = new ArrayList<>();
        for(int i = 0; i<key_2.length; i++){
            answer.add(key_2[i]);
        }
        return answer;
    }
}