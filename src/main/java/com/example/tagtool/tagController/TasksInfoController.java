package com.example.tagtool.tagController;

import com.example.tagtool.tagEntity.TasksInfo;
import com.example.tagtool.tagService.TasksInfoService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class TasksInfoController {
    @Resource
    private TasksInfoService tasksInfoService;

//定时判断任务是否截止
    @Scheduled(cron = "0 0 0 * * *")//每天零点判断任务是否结束
    public void isTimeOut(){
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        List<TasksInfo> info = tasksInfoService.findUnfinishedTasks();
        for(int i = 0; i<info.size(); i++){
            if(df.format(new Date()).equals(info.get(i).getDeadline())){
                tasksInfoService.updateFinishStateByTaskId(info.get(i).getId(),1);
            }
        }
    }
    //插入任务信息
    @RequestMapping("/insertTaskInfo")
    @ResponseBody
    public ResponseBean insertTaskInfo(TasksInfo tasksInfo){
        int data = tasksInfoService.insertTaskInfo(tasksInfo);
        int dataId = tasksInfoService.findTaskIdByTaskName(tasksInfo.getTask_name());
        if(data == 1){
            return new ResponseBean("插入成功",dataId);
        }else{
            return new ResponseBean("插入失败",data);
        }
    }

    //    查找所有未完成任务展示信息
    @RequestMapping("/findUnfinishedTasks")
    @ResponseBody
    public ResponseBean findUnfinishedTasks(){
        ResponseBean response = new ResponseBean();
        response.setMessage("查询成功");
        response.setData(tasksInfoService.findUnfinishedTasks());
        return response;
    }
//    根据任务类型获取未完成任务
    @RequestMapping("/findTasksByTasksType")
    @ResponseBody
    public ResponseBean findTasksByTasksType(String task_type){
        ResponseBean response = new ResponseBean();
        response.setMessage("查询成功");
        response.setData(tasksInfoService.findTasksByTasksType(task_type));
        return response;
    }
    //    根据id查询任务所有详细信息
    @RequestMapping("/findTaskById")
    @ResponseBody
    public ResponseBean findTaskById(Integer id){
        ResponseBean response = new ResponseBean();
        response.setMessage("查询成功");
        response.setData(tasksInfoService.findTaskById(id));
        return response;
    }
//    根据任务id查询参与用户账号
    @RequestMapping("/findMemberAccountByTaskId")
    @ResponseBody
    public ResponseBean findMemberAccountByTaskId(Integer id){
        ResponseBean response = new ResponseBean();
        response.setMessage("查询成功");
        response.setData(tasksInfoService.findMemberAccountByTaskId(id));
        return response;
    }

//    根据任务id删除任务信息
    @RequestMapping("/deleteTaskInfoByTaskId")
    @ResponseBody
    public ResponseBean deleteTaskInfoByTaskId(Integer id){
        ResponseBean response = new ResponseBean();
        response.setMessage("删除成功");
        response.setData(tasksInfoService.deleteTaskInfoByTaskId(id));
        return response;
    }
//根据任务id更新完成任务的人数和任务状态
    @RequestMapping("/updateFinishMemberByTaskId")
    @ResponseBody
    public ResponseBean updateFinishMemberByTaskId(Integer id , Integer member_finish){
        int data = tasksInfoService.updateFinishMemberByTaskId(id,member_finish);
        List<TasksInfo> tasksInfoData = tasksInfoService.findTaskById(id);
        TasksInfo tasksInfo = tasksInfoData.get(0);
        int totalNum = tasksInfo.getMember_num();
        int finishNum = tasksInfo.getMember_finish();
        ResponseBean response = new ResponseBean();
        response.setMessage("更新成功");
        if (totalNum > finishNum) {
            response.setData(tasksInfoService.updateFinishStateByTaskId(id, 0));
        } else {
            response.setData(tasksInfoService.updateFinishStateByTaskId(id, 1));
        }
        return response;
    }

//    根据任务id更新任务的完成状态
    @RequestMapping("/updateFinishStateByTaskId")
    @ResponseBody
    public ResponseBean updateFinishStateByTaskId(Integer id){
            ResponseBean response = new ResponseBean();
            response.setMessage("更新成功");
            response.setData(tasksInfoService.updateFinishStateByTaskId(id,1));
            return response;
    }

//    根据任务id更新参与人员的账号
    @RequestMapping("/updateMemberAccountByTaskId")
    @ResponseBody
    public ResponseBean updateMemberAccountByTaskId(Integer id,String member_account){
        ResponseBean response = new ResponseBean();
        response.setMessage("更新成功");
        response.setData(tasksInfoService.updateMemberAccountByTaskId(id,member_account));
        return response;
    }
//    根据任务名称获取任务id
    @RequestMapping("/findTaskIdByTaskName")
    @ResponseBody
    public ResponseBean findTaskIdByTaskName(String task_name){
        ResponseBean response = new ResponseBean();
        response.setMessage("查询成功");
        response.setData(tasksInfoService.findTaskIdByTaskName(task_name));
        return response;
    }
}
