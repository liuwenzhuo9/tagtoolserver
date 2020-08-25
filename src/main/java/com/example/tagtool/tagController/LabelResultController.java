package com.example.tagtool.tagController;

import com.example.tagtool.tagEntity.LabelResult;
import com.example.tagtool.tagEntity.TasksInfo;
import com.example.tagtool.tagService.LabelResultService;
import com.example.tagtool.tagService.TaskContentService;
import com.example.tagtool.tagService.TasksInfoService;
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
//        ResponseBean responseBean = new ResponseBean();
//        responseBean.setMessage("chenggong");
//        responseBean.setData(labelResultService.findFirstUnfinishedParagraph(task_id, user_account));
//        return responseBean;
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
//        用户账号信息
        String[] peopleSum = taskInfo.getMember_account().split(",");
        List<String> people_account = new ArrayList<>();
        for(int i=0;i<peopleSum.length;i++)
        {
            people_account.add(peopleSum[i]);
        }
        int peoLen = people_account.size();
//        获取任务可选标签
        String[] tag = taskInfo.getTask_label().split(",");
        //            每个人用户在该任务的标注结果
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
            List<String> a = label_result_1(people_account, pos, tag, res, god_key);

            infer_res = godKey;
        }

//        判断是否为带黄金数据的序列标注任务
        if(taskInfo.getSds_name() != null && taskInfo.getSds_name() != "" && taskInfo.getTask_type().equals("序列标注")){
//            黄金数据在任务中的位置
            String[] pos = taskInfo.getSds_pos().split(",");
//      黄金数据的正确结果
            List<String> godKey = taskContentService.getTestLabelByTaskId(task_id);
            String[] god_key = godKey.toArray(new String[]{});
            List<String> a = label_result_2(people_account, tag,  res, pos,  god_key, paragraph_len);
            infer_res = a;
        }


//        判断是否为*不带*黄金数据的标签标注任务
        if((taskInfo.getSds_name() == null || taskInfo.getSds_name() == "") && taskInfo.getTask_type().equals("标签标注")){

        }


//        判断是否为*不带*黄金数据的序列标注任务
        if((taskInfo.getSds_name() == null || taskInfo.getSds_name() == "") && taskInfo.getTask_type().equals("序列标注")){

        }
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(infer_res);
        responseBean.setMessage("推测成功");
        return responseBean;

    }

//    带黄金数据的标签标注结果预测方法；
    public List<String> label_result_1(List<String> people_account, String[] pos, String[] tag, List<List<String>> res, String[] god_key) {
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
                if(res.get(p - cnt).get(Integer.parseInt(pos[i]) - i) == god_key[i]){
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
                if(god_res.get(j).get(i) == god_key[i]) {
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
                if(god_res.get(i).get(j) == god_key[j]) {
                    score = score + (double)1/(diff.get(j) + e);
                }else{
                    score = score - 1;
                }
            }
            total_power = total_power + score;
            power.add(score);
        }
//        推测真值
        List<String> answer = new ArrayList<>();
        for(int i = 0; i<peoLen; i++) {
            if(power.get(i) >= (double)total_power/2){
                answer = res.get(i);
            }
        }
        if(answer.size() == 0) {
            for(int i = 0; i<res.get(0).size(); i++) {
                Map<String,Double> arg =new HashMap<String,Double>();
                double max = 0.0;
                String maxStr = "";
                for(int j=0; j<tag.length; j++) {
                    arg.put(tag[j], max);
                }
                for(int k = 0; k<peoLen; k++) {
                    double a = arg.get(res.get(k).get(i));
                    a = a + power.get(k);
                    max = Math.max(max, a);
                    if(max == a) {
                        maxStr = res.get(k).get(i);
                    }
                    arg.put(res.get(k).get(i), a);
                }
                answer.add(maxStr);
            }
        }
        return answer;
    }

//    带黄金数据的序列标注任务
    public List<String> label_result_2(List<String> people_account, String[] tag, List<List<String>> res, String[] pos, String[] god_key, List<Integer> paragraph_len) {
        // ji suan huang jin shu ju biao zhu biao xian F
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
                String[] resPArr = getIndexTag(resP, gdParaLen);
                String[] gokKeyPArr = getIndexTag(godKeyP, gdParaLen);
                double f = calcuAcc(resPArr, gokKeyPArr);
                score += f;
                res.get(p - cnt).remove(Integer.parseInt(pos[i]) - i);
            }
            if((double)score / gdLen < 0.5) {
                res.remove(p - cnt);
                people_account.remove(p - cnt);
                cnt = cnt + 1;
            }else{
                p_score.add((double)score / gdLen);
            }
        }

        for(int n = 0; n<gdLen; n++) {
            paragraph_len.remove(Integer.parseInt(pos[n]) - n);
        }
        peoLen = people_account.size();
        List<String> answer = new ArrayList<>();
        for(int i = 0; i<res.get(0).size(); i++){
            List<String> answerInSmplace = new ArrayList<>();
            int gdParaLen = paragraph_len.get(i);
            String[][] sumResInSmplace = new String[peoLen][gdParaLen];
            for(int k = 0; k<peoLen; k++){
                String[] resPArr = getIndexTag(res.get(k).get(i), gdParaLen);
                sumResInSmplace[k] = resPArr;
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
                    double a = arg.get(sumResInSmplace[k][j]);
                    a = a + p_score.get(k);
                    max = Math.max(max, a);
                    if(max == a) {
                        maxTag = sumResInSmplace[k][j];
                    }
                    arg.put(sumResInSmplace[k][j], a);
                }
                answerInSmplace.add(maxTag);
            }

            String[] ret = answerInSmplace.toArray(new String[]{});
            answer.add(Arrays.toString(ret));
        }
        return answer;
    }

    //  把用户标注的结果转换成数组存储
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

    //    计算用户的准确率和召回率
    public double calcuAcc(String[] str, String[] key) {
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
}

