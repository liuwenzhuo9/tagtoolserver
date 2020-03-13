package com.example.tagtool.tagService;

import com.example.tagtool.tagDao.UserDao;
import com.example.tagtool.tagEntity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserDao userDao;
//    插入人员信息
    public int insertUserInfo(User user){return userDao.insertUserInfo(user);}
//    根据用户账号查询任务情况
    public String findTasksByUserAccount(String account){return userDao.findTasksByUserAccount(account);}
//    根据用户账号更新任务情况
    public int updateTasksByUserAccount(String account,String involved_tasks,String finished_tasks,String progress_tasks,String issue_tasks){
        return userDao.updateTasksByUserAccount(account,involved_tasks,finished_tasks,progress_tasks,issue_tasks);
    }
//    根据用户账号更新成绩
    public int updateScoreByUserAccount(String account,String sds_score,String overall_score){
        return userDao.updateScoreByUserAccount(account,sds_score,overall_score);
    }
//    根据用户账号查询成绩
    public String findScoreByUserAccount(String account){return userDao.findScoreByUserAccount(account);}

}
