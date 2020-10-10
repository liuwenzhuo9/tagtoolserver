package com.example.tagtool.tagDao;

import com.example.tagtool.tagEntity.InferResult;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InferResultDao {
    int insertInferResult(InferResult inferResult);
    int updateInferLabelById(Integer id,String infer_result);
    int deleteInferLabelByTaskId(Integer task_id);
    List<InferResult> findInferLabelByTaskAndParagraph(Integer task_id,Integer paragraph_id);
    List<String> findInferLabelResultByTaskId(Integer task_id);
}
