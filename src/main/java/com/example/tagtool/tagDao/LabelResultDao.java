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
    int deleteLabelByTaskIdAndAccount(String user_account,Integer task_id);
    List<LabelResult> findLabelByTaskAndParagraph(Integer task_id,Integer paragraph_id);
    int findFinishParagraphNumByTaskId(Integer task_id,String user_account);
    List<LabelResult> findFirstUnfinishedParagraph(Integer task_id,String user_account);
    List<LabelResult> findNextUnfinishedParagraph(Integer task_id,String user_account,Integer paragraph_position);
    List<LabelResult> findLastUnfinishedParagraph(Integer task_id,String user_account,Integer paragraph_position);
    List<String> findLabelResultByTaskIdAndAccount(Integer task_id,String user_account);
    List<Integer> findParaIdByTaskIdAndAccount(Integer task_id,String user_account);
}
