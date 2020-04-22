package com.example.tagtool.tagController;

import com.example.tagtool.tagEntity.LabelResult;
import com.example.tagtool.tagService.LabelResultService;
import com.example.tagtool.tagService.TaskContentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class LabelResultController {
    @Resource
    private LabelResultService labelResultService;
    @Resource
    private TaskContentService taskContentService;

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
        String[] arr =new String[2];
        arr[0] = Integer.toString(resultId);
        arr[1] = dataLabel.getParagraph_position();
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage(taskContentService.findContentByParagraphId(dataLabel.getParagraph_id()));
        responseBean.setData(arr);
        return responseBean;
    }
    @RequestMapping("/findNextUnfinishedParagraph")
    @ResponseBody
    public ResponseBean findNextUnfinishedParagraph(Integer task_id,String user_account,String paragraph_position){
        List<LabelResult> dataN = labelResultService.findNextUnfinishedParagraph(task_id, user_account,paragraph_position);
        LabelResult dataNext = dataN.get(0);
        int resultId = dataNext.getId();
        String[] arr =new String[2];
        arr[0] = Integer.toString(resultId);
        arr[1] = dataNext.getParagraph_position();
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage(taskContentService.findContentByParagraphId(dataNext.getParagraph_id()));
        responseBean.setData(arr);
        return responseBean;
    }

    @RequestMapping("/findLastUnfinishedParagraph")
    @ResponseBody
    public ResponseBean findLastUnfinishedParagraph(Integer task_id,String user_account,String paragraph_position){
        List<LabelResult> dataL = labelResultService.findLastUnfinishedParagraph(task_id, user_account,paragraph_position);
        LabelResult dataLast = dataL.get(0);
        int resultId = dataLast.getId();
        String[] arr =new String[2];
        arr[0] = Integer.toString(resultId);
        arr[1] = dataLast.getParagraph_position();
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage(taskContentService.findContentByParagraphId(dataLast.getParagraph_id()));
        responseBean.setData(arr);
        return responseBean;
    }

    @RequestMapping("/findLabelResultById")
    @ResponseBody
    public ResponseBean findLabelResultById(Integer id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(labelResultService.findLabelResultById(id));
        responseBean.setMessage("查找成功");
        return responseBean;
    }
}
