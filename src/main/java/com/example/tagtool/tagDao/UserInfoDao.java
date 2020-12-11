package com.example.tagtool.tagDao;

import com.example.tagtool.tagEntity.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoDao {
//    插入人员信息
    int insertUserInfo(UserInfo userInfo);
//    根据用户账号查询用户信息
    List<UserInfo> findInfoByUserAccount(String account);
//    根据用户账号更新任务情况
    int updateTasksByUserAccount(String account,String involved_tasks,String finished_tasks,String progress_tasks,String issue_tasks);
    int updateJoinTasksByUserAccount(String account,String involved_tasks,String progress_tasks);
    int updateFinishTasksByUserAccount(String account,String progress_tasks,String finished_tasks);
    int deleteUser(String account);
//    根据用户账号查询成绩
//    List<User> findPowerByUserAccount(String account);
}
