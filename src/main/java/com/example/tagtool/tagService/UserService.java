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
//    根据用户账号更新标签标注成绩
    public int updateLabelPowerByUserAccount(String account,String power_l){
        return userDao.updateLabelPowerByUserAccount(account,power_l);
    }
//    根据用户账号更新序列标注成绩
    public int updateSequencePowerByUserAccount(String account,String power_s){
        return userDao.updateSequencePowerByUserAccount(account,power_s);
    }
    public int updateLabelScoresByUserAccount(String account,String label_scores){
        return userDao.updateLabelScoresByUserAccount(account,label_scores);
    }
    public int updateSequenceScoresByUserAccount(String account,String sequence_scores){
        return userDao.updateSequenceScoresByUserAccount(account,sequence_scores);
    }
    public int deleteUser(String account){
        return userDao.deleteUser(account);
    }
//    根据用户账号查询成绩
//    public List<User> findPowerByUserAccount(String account){return userDao.findPowerByUserAccount(account);}

}
