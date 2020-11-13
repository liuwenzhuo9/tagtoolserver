package com.example.tagtool.tagDao;

import com.example.tagtool.tagEntity.InferResult;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InferResultDao {
//    插入用户的标注预测结果
    int insertInferResult(InferResult inferResult);
//    根据任务id删除标注结果信息
    int deleteInferResultByTaskId(Integer task_id);
//    根据句子id更新标注预测信息
    int updateInferResultBySentenceId(Integer paragraph_id, String infer_result);
//    根据句子id更新一致性ci
    int updateCIBySentenceId(Integer paragraph_id, String ci);
//    根据句子id更新最终标注结果final_result
    int updateFinalResultBySentenceId(Integer paragraph_id, String final_result);
//    根据句子位置和任务id更新标注预测信息
    int updateInferResultByPosition(Integer task_id, Integer paragraph_position, String infer_result);
//    根据句子位置和任务id更新一致性ci
    int updateCIByPosition(Integer task_id, Integer paragraph_position, String ci);
//    根据句子位置和任务id更新最终标注结果final_result
    int updateFinalResultByPosition(Integer task_id, Integer paragraph_position, String final_result);
//    根据任务id获取所有句子标注信息
    List<InferResult> findInferInfoByTaskId(Integer task_id);
//    根据句子id获取标注信息
    List<InferResult> findInferInfoBySentenceId(Integer paragraph_id);
//    根据句子位置获取标注信息
    List<InferResult> findInferInfoByPosition(Integer task_id, Integer paragraph_position);
}
