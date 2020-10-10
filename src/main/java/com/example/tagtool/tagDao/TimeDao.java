package com.example.tagtool.tagDao;

import com.example.tagtool.tagEntity.Time;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeDao {
    //    插入用户在每个任务中的标注用时
    int insertLabelTime(Time time);
    //    根据用户账号和任务id获取标注用时
    List<Time> getLabelTimeByAccount(String account,int task_id);
    //    根据用户账号和任务id更新标注用时
    int updateLabelTime(String account,int task_id, int use_time);
//    根据用户账号和任务id删除标注用时
    int deleteLabelTime(String account,int task_id);
//    根据用户账号和任务id更新任务完成情况
    int updateIsFinishInTime(String account,int task_id, int is_finish);
    //    根据任务id获取全部用户用时
    List<Time> getLabelTimeByTaskId(int task_id);
}
