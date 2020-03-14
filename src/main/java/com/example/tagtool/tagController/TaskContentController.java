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
    public ResponseBean findContentByTaskId(Integer task_id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(taskContentService.findContentByTaskId(task_id));
        responseBean.setMessage("查询成功");
        return responseBean;
    }
}
