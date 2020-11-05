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
    public int insertInferResult(InferResult inferResult){return inferResultDao.insertInferResult(inferResult);}
    public int deleteInferResultByTaskId(Integer task_id){return inferResultDao.deleteInferResultByTaskId(task_id);}
    public int updateInferResultBySentenceId(Integer paragraph_id, String infer_result){return inferResultDao.updateInferResultBySentenceId(paragraph_id, infer_result);}
    public int updateFinalResultBySentenceId(Integer paragraph_id, String final_result){return inferResultDao.updateFinalResultBySentenceId(paragraph_id, final_result);}
    public int updateCIBySentenceId(Integer paragraph_id, String ci){return inferResultDao.updateCIBySentenceId(paragraph_id, ci);}
    public int updateInferResultByPosition(Integer task_id, Integer paragraph_position, String infer_result){return inferResultDao.updateInferResultByPosition(task_id, paragraph_position, infer_result);}
    public int updateCIByPosition(Integer task_id, Integer paragraph_position, String ci){return inferResultDao.updateCIByPosition(task_id, paragraph_position, ci);}
    public int updateFinalResultByPosition(Integer task_id, Integer paragraph_position, String final_result){return inferResultDao.updateFinalResultByPosition(task_id, paragraph_position, final_result);}
    public List<InferResult> findInferInfoByTaskId(Integer task_id){return inferResultDao.findInferInfoByTaskId(task_id);}
    public List<InferResult> findInferInfoBySentenceId(Integer paragraph_id){return inferResultDao.findInferInfoBySentenceId(paragraph_id);}
    public List<InferResult> findInferInfoByPosition(Integer task_id, Integer paragraph_position){return inferResultDao.findInferInfoByPosition(task_id, paragraph_position);}
}
