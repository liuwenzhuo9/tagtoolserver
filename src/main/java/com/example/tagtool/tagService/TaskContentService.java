package com.example.tagtool.tagService;

import com.example.tagtool.tagDao.TaskContentDao;
import com.example.tagtool.tagEntity.TaskContent;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TaskContentService {
    @Resource
    private TaskContentDao taskContentDao;
//    插入任务具体段落内容
    public int insertTaskContent(TaskContent taskContent){return taskContentDao.insertTaskContent(taskContent);}
//    根据任务id删除段落内容
    public int deleteContentByTaskId(Integer task_id){return taskContentDao.deleteContentByTaskId(task_id);}
//    根据任务id查找段落内容
    public List<TaskContent> findContentByTaskId(Integer task_id){return taskContentDao.findContentByTaskId(task_id);}
}
