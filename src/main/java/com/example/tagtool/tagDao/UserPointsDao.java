package com.example.tagtool.tagDao;

import com.example.tagtool.tagEntity.UserPoints;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPointsDao {
    //    插入人员积分变动信息
    int insertUserPoints(UserPoints userPoints);
    //    根据任务id删除积分信息
    int deleteUserPointsByTaskId(Integer task_id);
    //    根据任务id和用户account删除积分信息
    int deleteUserPointsByAccount(Integer task_id,String account);
//    根据任务id和积分操作类型获取积分信息
    List<UserPoints> findPointsByTaskId(Integer task_id);
//    根据用户account和任务类型以及积分操作类型获取积分信息
    List<UserPoints> findPointsByAccount(String account,Integer operation_type);
//    根据任务id和用户account更新积分和能力变动信息
    int updatePointsByTaskIdAndAccount(UserPoints userPoints);
//    根据任务id和用户account获取积分能力信息
    List<UserPoints> findPowerByAccountAndTaskId(String account, Integer task_id);
}
