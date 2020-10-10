package com.example.tagtool.tagController;

import com.example.tagtool.tagEntity.InferResult;
import com.example.tagtool.tagService.InferResultServie;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

@RestController
public class InferResultController {
    @Resource
    private InferResultServie inferResultServie;

    @RequestMapping("/insertInferResult")
    @ResponseBody
    public ResponseBean insertInferResult(InferResult inferResult){
        int data = inferResultServie.insertInferResult(inferResult);
        if(data == 1){
            return new ResponseBean("插入成功",data);
        }else{
            return new ResponseBean("插入失败",data);
        }
    }

    @RequestMapping("/updateInferLabelById")
    @ResponseBody
    public ResponseBean updateInferLabelById(Integer id,String infer_result){
        int data = inferResultServie.updateInferLabelById(id, infer_result);
        if(data == 1){
            return new ResponseBean("更新成功",data);
        }else{
            return new ResponseBean("更新失败",data);
        }
    }

    @RequestMapping("/deleteInferLabelByTaskId")
    @ResponseBody
    public ResponseBean deleteInferLabelByTaskId(Integer task_id){
        int data = inferResultServie.deleteInferLabelByTaskId(task_id);
        return new ResponseBean("删除成功",data);
    }

    @RequestMapping("/findInferLabelByTaskAndParagraph")
    @ResponseBody
    public ResponseBean findInferLabelByTaskAndParagraph(Integer task_id,Integer paragraph_id){
        List<InferResult> data = inferResultServie.findInferLabelByTaskAndParagraph(task_id, paragraph_id);
        return new ResponseBean("查找成功",data);
    }

    @RequestMapping("/findInferLabelResultByTaskId")
    @ResponseBody
    public ResponseBean findInferLabelResultByTaskId(Integer task_id){
        List<String> data = inferResultServie.findInferLabelResultByTaskId(task_id);
        return new ResponseBean("查找成功",data);
    }
}
