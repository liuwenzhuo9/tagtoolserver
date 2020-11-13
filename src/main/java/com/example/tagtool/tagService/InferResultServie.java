package com.example.tagtool.tagService;


import com.example.tagtool.tagDao.InferResultDao;
import com.example.tagtool.tagEntity.InferResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InferResultServie {
    @Resource
    private InferResultDao inferResultDao;
//     插入用户的标注预测结果
    public int insertInferResult(InferResult inferResult){return inferResultDao.insertInferResult(inferResult);}
//    根据任务id删除标注结果信息
    public int deleteInferResultByTaskId(Integer task_id){return inferResultDao.deleteInferResultByTaskId(task_id);}
//    根据句子id更新标注预测信息
    public int updateInferResultBySentenceId(Integer paragraph_id, String infer_result){return inferResultDao.updateInferResultBySentenceId(paragraph_id, infer_result);}
//    根据句子id更新一致性ci
    public int updateFinalResultBySentenceId(Integer paragraph_id, String final_result){return inferResultDao.updateFinalResultBySentenceId(paragraph_id, final_result);}
//    根据句子id更新最终标注结果final_result
    public int updateCIBySentenceId(Integer paragraph_id, String ci){return inferResultDao.updateCIBySentenceId(paragraph_id, ci);}
//    根据句子位置和任务id更新标注预测信息
    public int updateInferResultByPosition(Integer task_id, Integer paragraph_position, String infer_result){return inferResultDao.updateInferResultByPosition(task_id, paragraph_position, infer_result);}
//    根据句子位置和任务id更新一致性ci
    public int updateCIByPosition(Integer task_id, Integer paragraph_position, String ci){return inferResultDao.updateCIByPosition(task_id, paragraph_position, ci);}
//      根据句子位置和任务id更新最终标注结果final_result
    public int updateFinalResultByPosition(Integer task_id, Integer paragraph_position, String final_result){return inferResultDao.updateFinalResultByPosition(task_id, paragraph_position, final_result);}//    根据任务id获取所有句子标注信息
//    根据任务id获取所有句子标注信息
    public List<InferResult> findInferInfoByTaskId(Integer task_id){return inferResultDao.findInferInfoByTaskId(task_id);}
//    根据句子id获取标注信息
    public List<InferResult> findInferInfoBySentenceId(Integer paragraph_id){return inferResultDao.findInferInfoBySentenceId(paragraph_id);}
//    根据句子位置获取标注信息
    public List<InferResult> findInferInfoByPosition(Integer task_id, Integer paragraph_position){return inferResultDao.findInferInfoByPosition(task_id, paragraph_position);}
}
