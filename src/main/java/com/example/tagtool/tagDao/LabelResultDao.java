package com.example.tagtool.tagDao;

import com.example.tagtool.tagEntity.LabelResult;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelResultDao {
//    插入用户的标注结果
    int insertLabelResult(LabelResult labelResult);
    int updateLabelById(Integer id,String label_result);
    int deleteLabelByAccount(String user_account);
    int deleteLabelByTaskId(Integer task_id);
    List<LabelResult> findLabelByTaskAndParagraph(Integer task_id,Integer paragraph_id);
}
