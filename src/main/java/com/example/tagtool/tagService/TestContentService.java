package com.example.tagtool.tagService;

import com.example.tagtool.tagDao.TestContentDao;
import com.example.tagtool.tagEntity.TestContent;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestContentService {
    @Resource
    private TestContentDao testContentDao;
    public int insertTestContent(TestContent testContent){return testContentDao.insertTestContent(testContent);}
    public int deleteTestContentByTaskId(Integer task_id){return testContentDao.deleteTestContentByTaskId(task_id);}
    public List<TestContent> findTestContentByTaskId(Integer task_id){return testContentDao.findTestContentByTaskId(task_id);}
    public int findTestParagraphNumByTaskId(Integer task_id){return testContentDao.findTestParagraphNumByTaskId(task_id);}
    public String findTestContentByParagraphId(Integer id){return testContentDao.findTestContentByParagraphId(id);}
    public int updateRightLabel(Integer task_id,String paragraph_position,String test_label){return testContentDao.updateRightLabel(task_id, paragraph_position, test_label);}
}
