package com.example.tagtool.tagDao;

import com.example.tagtool.tagEntity.InferResult;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InferResultDao {
    int insertInferResult(InferResult inferResult);
    int deleteInferResultByTaskId(Integer task_id);
    int updateInferResultBySentenceId(Integer paragraph_id, String infer_result);
    int updateCIBySentenceId(Integer paragraph_id, String ci);
    int updateFinalResultBySentenceId(Integer paragraph_id, String final_result);
    int updateInferResultByPosition(Integer task_id, Integer paragraph_position, String infer_result);
    int updateCIByPosition(Integer task_id, Integer paragraph_position, String ci);
    int updateFinalResultByPosition(Integer task_id, Integer paragraph_position, String final_result);
    List<InferResult> findInferInfoByTaskId(Integer task_id);
    List<InferResult> findInferInfoBySentenceId(Integer paragraph_id);
    List<InferResult> findInferInfoByPosition(Integer task_id, Integer paragraph_position);
}
