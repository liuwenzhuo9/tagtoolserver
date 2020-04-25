package com.example.tagtool.tagDao;

import com.example.tagtool.tagEntity.TestResult;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestResultDao {
    int insertTestRes(TestResult testResult);
    int updateTestResById(Integer id,String res_label);
    int deleteTestLabelByAccount(String user_account);
    int deleteTestLabelByTaskId(Integer task_id);
    List<TestResult> findTestLabelByTaskAndParagraph(Integer task_id,Integer paragraph_id);
    int findFinishTestParagraphNumByTaskId(Integer task_id,String user_account);
    List<TestResult> findFirstUnfinishedTestParagraph(Integer task_id, String user_account);
    List<TestResult> findNextUnfinishedTestParagraph(Integer task_id,String user_account,String paragraph_position);
    List<TestResult> findLastUnfinishedTestParagraph(Integer task_id,String user_account,String paragraph_position);
    List<TestResult> findTestLabelResultById(Integer id);}
