package com.example.tagtool.tagDao;

import com.example.tagtool.tagEntity.TestContent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestContentDao {
    int insertTestContent(TestContent testContent);
    int deleteTestContentByTaskId(Integer task_id);
    List<TestContent> findTestContentByTaskId(Integer task_id);
    int findTestParagraphNumByTaskId(Integer task_id);
    String findTestContentByParagraphId(Integer id);
    int updateRightLabel(Integer task_id,String paragraph_position,String test_label);
}
