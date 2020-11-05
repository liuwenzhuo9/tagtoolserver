package com.example.tagtool.tagDao;

import com.example.tagtool.tagEntity.TaskContent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskContentDao {
//    插入任务具体段落内容
    int insertTaskContent(TaskContent taskContent);
//    根据任务id删除段落内容
    int deleteContentByTaskId(Integer task_id);
//    根据任务id查找段落内容
    List<TaskContent> findContentByTaskIdAndIsTest(Integer task_id, Integer is_test);
    int findParagraphNumByTaskIdAndIsTest(Integer task_id,  Integer is_test);
    String findContentByParagraphId(Integer id);
    int findLabeledTestNumByTaskId(Integer task_id);
    int updateRightLabel(Integer task_id,String paragraph_position,String test_label);
    List<TaskContent> findFirstUnfinishedTestParagraph(Integer task_id);
    List<TaskContent> findNextUnfinishedTestParagraph(Integer task_id,String paragraph_position);
    List<TaskContent> findLastUnfinishedTestParagraph(Integer task_id,String paragraph_position);
    List<TaskContent> findFirstTestParagraph(Integer task_id);
    List<TaskContent> findNextTestParagraph(Integer task_id,String paragraph_position);
    List<TaskContent> findLastTestParagraph(Integer task_id,String paragraph_position);
    List<String> getTestLabelByTaskId(Integer task_id);
    List<TaskContent> getFormalParagraph(Integer task_id);
}
