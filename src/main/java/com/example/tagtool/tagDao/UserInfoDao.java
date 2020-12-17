package com.example.tagtool.tagDao;

import com.example.tagtool.tagEntity.UserInfo;
import org.apache.ibatis.annotations.Param;
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
//    根据用户账号更新用户积分情况
    int updatePointsByAccount(Double points, String account);
//    根据用户账号更新用户标注能力
    int updatePowerByAccount(UserInfo userInfo);
//    查询power_l1能力排序前20的用户信息
    List<UserInfo>  findTopUserOnLabelType(@Param("type")String type);
}
