package com.example.tagtool.tagDao;

import com.example.tagtool.tagEntity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
//    插入人员信息
    int insertUserInfo(User user);
//    根据用户账号查询用户信息
    List<User> findInfoByUserAccount(String account);
//    根据用户账号更新任务情况
    int updateTasksByUserAccount(String account,String involved_tasks,String finished_tasks,String progress_tasks,String issue_tasks);
    int updateJoinTasksByUserAccount(String account,String involved_tasks,String progress_tasks);
    int updateFinishTasksByUserAccount(String account,String progress_tasks,String finished_tasks);
//    根据用户账号更新标签标注成绩
    int updateLabelPowerByUserAccount(String account,String power_l);
//    根据用户账号更新序列标注成绩
    int updateSequencePowerByUserAccount(String account,String power_s);
    int updateLabelScoresByUserAccount(String account,String label_scores);
    int updateSequenceScoresByUserAccount(String account,String sequence_scores);
    int deleteUser(String account);
//    根据用户账号查询成绩
//    List<User> findPowerByUserAccount(String account);
}
