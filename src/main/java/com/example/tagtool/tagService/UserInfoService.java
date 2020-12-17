package com.example.tagtool.tagService;

import com.example.tagtool.tagDao.UserInfoDao;
import com.example.tagtool.tagEntity.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;
//    插入人员信息
    public int insertUserInfo(UserInfo userInfo){return userInfoDao.insertUserInfo(userInfo);}
//    根据用户账号查询任务情况
    public List<UserInfo> findInfoByUserAccount(String account){return userInfoDao.findInfoByUserAccount(account);}
//    根据用户账号更新任务情况
    public int updateTasksByUserAccount(String account,String involved_tasks,String finished_tasks,String progress_tasks,String issue_tasks){
        return userInfoDao.updateTasksByUserAccount(account,involved_tasks,finished_tasks,progress_tasks,issue_tasks);
    }
    public int updateJoinTasksByUserAccount(String account,String involved_tasks,String progress_tasks){
        return userInfoDao.updateJoinTasksByUserAccount(account, involved_tasks, progress_tasks);
    }
    public int updateFinishTasksByUserAccount(String account,String progress_tasks,String finished_tasks){
        return userInfoDao.updateFinishTasksByUserAccount(account, progress_tasks, finished_tasks);
    }
    public int deleteUser(String account){
        return userInfoDao.deleteUser(account);
    }
    public int updatePointsByAccount(Double points, String account){return userInfoDao.updatePointsByAccount(points, account);}
    public int updatePowerByAccount(UserInfo userInfo){return userInfoDao.updatePowerByAccount(userInfo);}
    public List<UserInfo> findTopUserOnLabelType(String type){return userInfoDao.findTopUserOnLabelType(type);}
}
