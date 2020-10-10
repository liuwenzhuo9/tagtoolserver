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
    public int updateInferLabelById(Integer id,String infer_result){return inferResultDao.updateInferLabelById(id,infer_result);}
    public int deleteInferLabelByTaskId(Integer task_id){return inferResultDao.deleteInferLabelByTaskId(task_id);}
    public List<InferResult> findInferLabelByTaskAndParagraph(Integer task_id,Integer paragraph_id){return inferResultDao.findInferLabelByTaskAndParagraph(task_id, paragraph_id);}
    public List<String> findInferLabelResultByTaskId(Integer task_id){return inferResultDao.findInferLabelResultByTaskId(task_id);}
}
