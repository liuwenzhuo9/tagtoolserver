package com.example.tagtool.tagDao;

import com.example.tagtool.tagEntity.TaskContent;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskContentDao {
//    插入任务具体段落内容
    int insertTaskContent(TaskContent taskContent);
//    根据任务id删除段落内容
    int deleteContentByTaskId(Integer task_id);
//    根据任务id查找段落内容
    List<TaskContent> findContentByTaskId(Integer task_id);
}
