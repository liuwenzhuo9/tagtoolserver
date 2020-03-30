package com.example.tagtool.tagService;

import com.example.tagtool.tagDao.TasksInfoDao;
import com.example.tagtool.tagEntity.TasksInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TasksInfoService {
    @Resource
    private TasksInfoDao tasksInfoDao;
    //插入任务信息
    public int insertTaskInfo(TasksInfo tasksInfo){return tasksInfoDao.insertTaskInfo(tasksInfo);}
//    查找所有未完成任务展示信息
    public List<TasksInfo> findUnfinishedTasks(){return tasksInfoDao.findUnfinishedTasks();}
//    根据任务类型获取未完成任务
    public List<TasksInfo> findTasksByTasksType(String task_type){return tasksInfoDao.findTasksByTasksType(task_type);}
//    根据id查询任务所有详细信息
    public List<TasksInfo> findTaskById(Integer id){return tasksInfoDao.findTaskById(id);}
//    根据任务id查询参与用户账号
    public String findMemberAccountByTaskId(Integer id){return tasksInfoDao.findMemberAccountByTaskId(id);}
//    根据任务id删除任务信息
    public int deleteTaskInfoByTaskId(Integer id){return tasksInfoDao.deleteTaskInfoByTaskId(id);}
//    根据任务id更新完成任务的人数
    public int updateFinishMemberByTaskId(Integer id,Integer member_finish){return tasksInfoDao.updateFinishMemberByTaskId(id,member_finish);}
//    根据任务id更新任务的完成状态
    public int updateFinishStateByTaskId(Integer id,Integer is_finished){return tasksInfoDao.updateFinishStateByTaskId(id,is_finished);}
//    根据任务id更新参与人员的账号
    public int updateMemberAccountByTaskId(Integer id,String member_account){return tasksInfoDao.updateMemberAccountByTaskId(id,member_account);}
//    根据任务名称获取任务id
    public int findTaskIdByTaskName(String task_name){return tasksInfoDao.findTaskIdByTaskName(task_name);}
}
