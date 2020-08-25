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
//    根据用户账号更新成绩
    int updateScoreByUserAccount(String account,String sds_score,String overall_score);
    int deleteUser(String account);
//    根据用户账号查询成绩
//    String findScoreByUserAccount(String account);
}
