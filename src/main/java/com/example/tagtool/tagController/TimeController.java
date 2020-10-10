package com.example.tagtool.tagController;

import com.example.tagtool.tagEntity.Time;
import com.example.tagtool.tagEntity.User;
import com.example.tagtool.tagService.TimeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TimeController {
    @Resource
    private TimeService timeService;

    //    插入用户在每个任务中的标注用时
    @RequestMapping("/insertLabelTime")
    @ResponseBody
    public ResponseBean insertLabelTime(Time time){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(timeService.insertLabelTime(time));
        responseBean.setMessage("插入成功");
        return responseBean;
    }
    //    根据用户账号和任务id获取标注用时
    @RequestMapping("/getLabelTimeByAccount")
    @ResponseBody
    public ResponseBean getLabelTimeByAccount(String account,int task_id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(timeService.getLabelTimeByAccount(account, task_id));
        responseBean.setMessage("查找成功");
        return responseBean;
    }
    //    根据用户账号和任务id更新标注用时
    @RequestMapping("/updateLabelTime")
    @ResponseBody
    public ResponseBean updateLabelTime(String account,int task_id, int use_time){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(timeService.updateLabelTime(account, task_id, use_time));
        responseBean.setMessage("更新成功");
        return responseBean;
    }
    //    根据用户账号和任务id删除标注用时
    @RequestMapping("/deleteLabelTime")
    @ResponseBody
    public ResponseBean deleteLabelTime(String account,int task_id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(timeService.deleteLabelTime(account, task_id));
        responseBean.setMessage("删除成功");
        return responseBean;
    }
    //    根据用户账号和任务id更新任务完成情况
    @RequestMapping("/updateIsFinishInTime")
    @ResponseBody
    public ResponseBean updateIsFinishInTime(String account,int task_id, int is_finish){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(timeService.updateIsFinishInTime(account, task_id, is_finish));
        responseBean.setMessage("更新成功");
        return responseBean;
    }
    //    根据任务id获取全部用户用时
    @RequestMapping("/getLabelTimeByTaskId")
    @ResponseBody
    public ResponseBean getLabelTimeByTaskId(int task_id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(timeService.getLabelTimeByTaskId(task_id));
        responseBean.setMessage("查找成功");
        return responseBean;
    }
}
