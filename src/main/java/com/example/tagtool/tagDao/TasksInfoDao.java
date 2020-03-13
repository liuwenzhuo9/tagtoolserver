package com.example.tagtool.tagDao;

import com.example.tagtool.tagEntity.TasksInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksInfoDao {
    //插入任务信息
    int insertTaskInfo(TasksInfo tasksInfo);
//    查找所有未完成任务展示信息
    List<TasksInfo> findUnfinishedTasks();
//    根据id查询任务所有详细信息
    List<TasksInfo> findTaskById(Integer id);
//    根据任务id查询参与用户账号
    String findMemberAccountByTaskId(Integer id);
//    根据任务id删除任务信息
    int deleteTaskInfoByTaskId(Integer id);
//    根据任务id更新完成任务的人数
    int updateFinishMemberByTaskId(Integer id,Integer member_finish);
//    根据任务id更新任务的完成状态
    int updateFinishStateByTaskId(Integer id,Integer is_finished);
//    根据任务id更新参与人员的账号
    int updateMemberAccountByTaskId(Integer id,String member_account);
}
