package com.example.tagtool.tagService;

import com.example.tagtool.tagDao.LabelResultDao;
import com.example.tagtool.tagDao.TestResultDao;
import com.example.tagtool.tagEntity.LabelResult;
import com.example.tagtool.tagEntity.TestResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestResultService {
    @Resource
    private TestResultDao testResultDao;
    public int insertTestRes(TestResult testResult){return testResultDao.insertTestRes(testResult);}
    public int updateTestResById(Integer id,String res_label){return testResultDao.updateTestResById(id,res_label);}
    public int deleteTestLabelByAccount(String user_account){return testResultDao.deleteTestLabelByAccount(user_account);}
    public int deleteTestLabelByTaskId(Integer task_id){return testResultDao.deleteTestLabelByTaskId(task_id);}
    public List<TestResult> findTestLabelByTaskAndParagraph(Integer task_id, Integer paragraph_id){return testResultDao.findTestLabelByTaskAndParagraph(task_id, paragraph_id);}
    public int findFinishTestParagraphNumByTaskId(Integer task_id,String user_account){return testResultDao.findFinishTestParagraphNumByTaskId(task_id, user_account);}
    public List<TestResult> findFirstUnfinishedTestParagraph(Integer task_id,String user_account){return testResultDao.findFirstUnfinishedTestParagraph(task_id, user_account);}
    public List<TestResult> findNextUnfinishedTestParagraph(Integer task_id,String user_account,String paragraph_position){return testResultDao.findNextUnfinishedTestParagraph(task_id, user_account,paragraph_position);}
    public List<TestResult> findLastUnfinishedTestParagraph(Integer task_id,String user_account,String paragraph_position){return testResultDao.findLastUnfinishedTestParagraph(task_id, user_account,paragraph_position);}
    public List<TestResult> findTestLabelResultById(Integer id){return testResultDao.findTestLabelResultById(id);}
}
