package com.example.tagtool.tagService;

import com.example.tagtool.tagDao.UserDao;
import com.example.tagtool.tagEntity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserDao userDao;
//    插入人员信息
    public int insertUserInfo(User user){return userDao.insertUserInfo(user);}
//    根据用户账号查询任务情况
    public List<User> findInfoByUserAccount(String account){return userDao.findInfoByUserAccount(account);}
//    根据用户账号更新任务情况
    public int updateTasksByUserAccount(String account,String involved_tasks,String finished_tasks,String progress_tasks,String issue_tasks){
        return userDao.updateTasksByUserAccount(account,involved_tasks,finished_tasks,progress_tasks,issue_tasks);
    }
    public int updateJoinTasksByUserAccount(String account,String involved_tasks,String progress_tasks){
        return userDao.updateJoinTasksByUserAccount(account, involved_tasks, progress_tasks);
    }
    public int updateFinishTasksByUserAccount(String account,String progress_tasks,String finished_tasks){
        return userDao.updateFinishTasksByUserAccount(account, progress_tasks, finished_tasks);
    }
//    根据用户账号更新成绩
    public int updateScoreByUserAccount(String account,String sds_score,String overall_score){
        return userDao.updateScoreByUserAccount(account,sds_score,overall_score);
    }
    public int deleteUser(String account){
        return userDao.deleteUser(account);
    }
//    根据用户账号查询成绩
//    public String findScoreByUserAccount(String account){return userDao.findScoreByUserAccount(account);}

}
