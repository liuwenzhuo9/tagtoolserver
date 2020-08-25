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
    public List<TaskContent> findContentByTaskIdAndIsTest(Integer task_id,Integer is_test){return taskContentDao.findContentByTaskIdAndIsTest(task_id, is_test);}
    public int findParagraphNumByTaskIdAndIsTest(Integer task_id, Integer is_test){return taskContentDao.findParagraphNumByTaskIdAndIsTest(task_id, is_test);}
    public String findContentByParagraphId(Integer id){return taskContentDao.findContentByParagraphId(id);}
    public int findLabeledTestNumByTaskId(Integer task_id){return taskContentDao.findLabeledTestNumByTaskId(task_id);}
    public int updateRightLabel(Integer task_id,String paragraph_position,String test_label){return taskContentDao.updateRightLabel(task_id, paragraph_position, test_label);}
    public List<TaskContent> findFirstUnfinishedTestParagraph(Integer task_id){return taskContentDao.findFirstUnfinishedTestParagraph(task_id);}
    public List<TaskContent> findNextUnfinishedTestParagraph(Integer task_id,String paragraph_position){return taskContentDao.findNextUnfinishedTestParagraph(task_id,paragraph_position);}
    public List<TaskContent> findLastUnfinishedTestParagraph(Integer task_id,String paragraph_position){return taskContentDao.findLastUnfinishedTestParagraph(task_id,paragraph_position);}
    public List<String> getTestLabelByTaskId(Integer task_id){return taskContentDao.getTestLabelByTaskId(task_id);}
}
