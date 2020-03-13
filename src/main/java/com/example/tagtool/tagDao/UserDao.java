package com.example.tagtool.tagDao;

import com.example.tagtool.tagEntity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
//    插入人员信息
    int insertUserInfo(User user);
//    根据用户账号查询任务情况
    String findTasksByUserAccount(String account);
//    根据用户账号更新任务情况
    int updateTasksByUserAccount(String account,String involved_tasks,String finished_tasks,String progress_tasks,String issue_tasks);
//    根据用户账号更新成绩
    int updateScoreByUserAccount(String account,String sds_score,String overall_score);
//    根据用户账号查询成绩
    String findScoreByUserAccount(String account);
}
