package com.example.tagtool.tagController;

import com.example.tagtool.tagEntity.TaskContent;
import com.example.tagtool.tagService.TaskContentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TaskContentController {
    @Resource
    private TaskContentService taskContentService;

//    插入任务具体段落内容
    @RequestMapping("/insertTaskContent")
    @ResponseBody
    public ResponseBean insertTaskContent(TaskContent taskContent){
        int data = taskContentService.insertTaskContent(taskContent);
        if(data == 1){
            return new ResponseBean("插入成功",data);
        }else{
            return new ResponseBean("插入失败",data);
        }
    }
//    根据任务id删除段落内容
    @RequestMapping("/deleteContentByTaskId")
    @ResponseBody
    public ResponseBean deleteContentByTaskId(Integer task_id){
        int data = taskContentService.deleteContentByTaskId(task_id);
        return new ResponseBean("删除成功",data);
    }
//    根据任务id查找段落内容
    @RequestMapping("/findContentByTaskId")
    @ResponseBody
    public ResponseBean findContentByTaskIdAndIsTest(Integer task_id, Integer is_test){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(taskContentService.findContentByTaskIdAndIsTest(task_id, is_test));
        responseBean.setMessage("查询成功");
        return responseBean;
    }
    @RequestMapping("/findParagraphNumByTaskId")
    @ResponseBody
    public ResponseBean findParagraphNumByTaskIdAndIsTest(Integer task_id, Integer is_test){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(taskContentService.findParagraphNumByTaskIdAndIsTest(task_id, is_test));
        responseBean.setMessage("查询成功");
        return responseBean;
    }
    @RequestMapping("/findContentByParagraphId")
    @ResponseBody
    public ResponseBean findContentByParagraphId(Integer id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(taskContentService.findContentByParagraphId(id));
        responseBean.setMessage("查询成功");
        return responseBean;
    }

    @RequestMapping("/findLabeledTestNumByTaskId")
    @ResponseBody
    public ResponseBean findLabeledTestNumByTaskId(Integer task_id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(taskContentService.findLabeledTestNumByTaskId(task_id));
        responseBean.setMessage("查询成功");
        return responseBean;
    }

    @RequestMapping("/updateRightLabel")
    @ResponseBody
    public ResponseBean updateRightLabel(Integer task_id,String paragraph_position,String test_label){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(taskContentService.updateRightLabel(task_id, paragraph_position, test_label));
        responseBean.setMessage("更新成功");
        return responseBean;
    }
    @RequestMapping("/findFirstUnfinishedTestParagraph")
    @ResponseBody
    public ResponseBean findFirstUnfinishedTestParagraph(Integer task_id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(taskContentService.findFirstUnfinishedTestParagraph(task_id));
        responseBean.setMessage("查询成功");
        return responseBean;
    }
    @RequestMapping("/findNextUnfinishedTestParagraph")
    @ResponseBody
    public ResponseBean findNextUnfinishedTestParagraph(Integer task_id, String paragraph_position){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(taskContentService.findNextUnfinishedTestParagraph(task_id, paragraph_position));
        responseBean.setMessage("查询成功");
        return responseBean;
    }
    @RequestMapping("/findLastUnfinishedTestParagraph")
    @ResponseBody
    public ResponseBean findLastUnfinishedTestParagraph(Integer task_id, String paragraph_position){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(taskContentService.findLastUnfinishedTestParagraph(task_id, paragraph_position));
        responseBean.setMessage("查询成功");
        return responseBean;
    }

    @RequestMapping("/getTestLabelByTaskId")
    @ResponseBody
    public ResponseBean getTestLabelByTaskId(Integer task_id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(taskContentService.getTestLabelByTaskId(task_id));
        responseBean.setMessage("查询成功");
        return responseBean;
    }
}
