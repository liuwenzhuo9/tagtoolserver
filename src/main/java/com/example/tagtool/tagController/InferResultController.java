package com.example.tagtool.tagController;

import com.example.tagtool.tagEntity.InferResult;
import com.example.tagtool.tagService.InferResultServie;
import com.example.tagtool.tagService.LabelResultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class InferResultController {
    @Resource
    private InferResultServie inferResultServie;
    @Resource
    private LabelResultController labelResultController;
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

    @RequestMapping("/deleteInferResultByTaskId")
    @ResponseBody
    public ResponseBean deleteInferResultByTaskId(Integer task_id){
        int data = inferResultServie.deleteInferResultByTaskId(task_id);
        return new ResponseBean("删除成功",data);
    }

    @RequestMapping("/updateInferResultBySentenceId")
    @ResponseBody
    public ResponseBean updateInferResultBySentenceId(Integer paragraph_id, String infer_result){
        int data = inferResultServie.updateInferResultBySentenceId(paragraph_id, infer_result);
        if(data == 1){
            return new ResponseBean("更新成功",data);
        }else{
            return new ResponseBean("更新失败",data);
        }
    }

    @RequestMapping("/updateCIBySentenceId")
    @ResponseBody
    public ResponseBean updateCIBySentenceId(Integer paragraph_id, String ci){
        int data = inferResultServie.updateCIBySentenceId(paragraph_id, ci);
        if(data == 1){
            return new ResponseBean("更新成功",data);
        }else{
            return new ResponseBean("更新失败",data);
        }
    }

    @RequestMapping("/updateFinalResultBySentenceId")
    @ResponseBody
    public ResponseBean updateFinalResultBySentenceId(Integer paragraph_id, String final_result){
        int data = inferResultServie.updateFinalResultBySentenceId(paragraph_id, final_result);
        if(data == 1){
            return new ResponseBean("更新成功",data);
        }else{
            return new ResponseBean("更新失败",data);
        }
    }

    @RequestMapping("/updateInferResultByPosition")
    @ResponseBody
    public ResponseBean updateInferResultByPosition(Integer task_id, Integer paragraph_position, String infer_result){
        int data = inferResultServie.updateInferResultByPosition(task_id, paragraph_position, infer_result);
        if(data == 1){
            return new ResponseBean("更新成功",data);
        }else{
            return new ResponseBean("更新失败",data);
        }
    }

    @RequestMapping("/updateCIByPosition")
    @ResponseBody
    public ResponseBean updateCIByPosition(Integer task_id, Integer paragraph_position, String ci){
        int data = inferResultServie.updateCIByPosition(task_id, paragraph_position, ci);
        if(data == 1){
            return new ResponseBean("更新成功",data);
        }else{
            return new ResponseBean("更新失败",data);
        }
    }

    @RequestMapping("/updateFinalResultByPosition")
    @ResponseBody
    public ResponseBean updateFinalResultByPosition(Integer task_id, Integer paragraph_position, String final_result){
        int data = inferResultServie.updateFinalResultByPosition(task_id, paragraph_position, final_result);
        if(data == 1){
            return new ResponseBean("更新成功",data);
        }else{
            return new ResponseBean("更新失败",data);
        }
    }

    @RequestMapping("/findInferInfoByTaskId")
    @ResponseBody
    public ResponseBean findInferInfoByTaskId(Integer task_id){
        List<InferResult> data = inferResultServie.findInferInfoByTaskId(task_id);
//        判断tb_infer_result是否存在infer_result 若不存在，则调用预测结果的接口；若存在直接返回获取的值
        if(data.get(0).getInfer_result() == null || data.get(0).getInfer_result().equals("")){
            List<String> info = labelResultController.inferLabelResult(task_id);
            for(int i = 0; i<info.size(); i++){
                inferResultServie.updateInferResultByPosition(task_id, i, info.get(i));
            }
        }
        return new ResponseBean("查询成功",inferResultServie.findInferInfoByTaskId(task_id));
    }

    @RequestMapping("/findInferInfoBySentenceId")
    @ResponseBody
    public ResponseBean findInferInfoBySentenceId(Integer paragraph_id){
        List<InferResult> data = inferResultServie.findInferInfoBySentenceId(paragraph_id);
        return new ResponseBean("查询成功",data);
    }

    @RequestMapping("/findInferInfoByPosition")
    @ResponseBody
    public ResponseBean findInferInfoByPosition(Integer task_id, Integer paragraph_position){
        List<InferResult> data = inferResultServie.findInferInfoByPosition(task_id, paragraph_position);
        return new ResponseBean("查询成功",data);
    }
}
