package com.example.tagtool.tagService;

import com.example.tagtool.tagDao.UserPointsDao;
import com.example.tagtool.tagEntity.UserPoints;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserPointsService {
    @Resource
    private UserPointsDao userPointsDao;
    //    插入人员积分变动信息
    public int insertUserPoints(UserPoints userPoints){return userPointsDao.insertUserPoints(userPoints);}
    //    根据任务id删除积分信息
    public int deleteUserPointsByTaskId(Integer task_id){return userPointsDao.deleteUserPointsByTaskId(task_id);}
    //    根据任务id和用户account删除积分信息
    public int deleteUserPointsByAccount(Integer task_id,String account){return userPointsDao.deleteUserPointsByAccount(task_id, account);}
//    根据任务id和积分操作类型获取积分信息
    public List<UserPoints> findPointsByTaskId(Integer task_id){return userPointsDao.findPointsByTaskId(task_id);}
//    根据用户account和任务类型以及积分操作类型获取积分信息
    public List<UserPoints> findPointsByAccount(String account,Integer operation_type){return userPointsDao.findPointsByAccount(account, operation_type);}
//    根据任务id和用户account更新积分和能力变动信息
    public int updatePointsByTaskIdAndAccount(UserPoints userPoints){return userPointsDao.updatePointsByTaskIdAndAccount(userPoints);}
}

