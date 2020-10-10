package com.example.tagtool.tagService;

import com.example.tagtool.tagDao.TimeDao;
import com.example.tagtool.tagEntity.Time;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TimeService {
    @Resource
    private TimeDao timeDao;
    //    插入用户在每个任务中的标注用时
    public int insertLabelTime(Time time){return timeDao.insertLabelTime(time);}
    //    根据用户账号和任务id获取标注用时
    public List<Time> getLabelTimeByAccount(String account,int task_id){return timeDao.getLabelTimeByAccount(account, task_id);}
    //    根据用户账号和任务id更新标注用时
    public int updateLabelTime(String account,int task_id, int use_time){return timeDao.updateLabelTime(account, task_id, use_time);}
//    根据用户账号和任务id删除标注用时
    public int deleteLabelTime(String account,int task_id){return timeDao.deleteLabelTime(account, task_id);}
//    根据用户账号和任务id更新任务完成情况
    public int updateIsFinishInTime(String account,int task_id, int is_finish){return timeDao.updateIsFinishInTime(account, task_id, is_finish);}
//    根据任务id获取全部用户用时
    public List<Time> getLabelTimeByTaskId(int task_id){return timeDao.getLabelTimeByTaskId(task_id);}
}
