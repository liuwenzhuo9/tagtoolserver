package com.example.tagtool.tagController;

import com.example.tagtool.tagEntity.LabelResult;
import com.example.tagtool.tagService.LabelResultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LabelResultController {
    @Resource
    private LabelResultService labelResultService;

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
}
