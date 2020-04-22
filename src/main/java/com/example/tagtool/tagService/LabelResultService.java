package com.example.tagtool.tagService;

import com.example.tagtool.tagDao.LabelResultDao;
import com.example.tagtool.tagEntity.LabelResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LabelResultService {
    @Resource
    private LabelResultDao labelResultDao;
    public int insertLabelResult(LabelResult labelResult){return labelResultDao.insertLabelResult(labelResult);}
    public int updateLabelById(Integer id,String label_result){return labelResultDao.updateLabelById(id,label_result);}
    public int deleteLabelByAccount(String user_account){return labelResultDao.deleteLabelByAccount(user_account);}
    public int deleteLabelByTaskId(Integer task_id){return labelResultDao.deleteLabelByTaskId(task_id);}
    public List<LabelResult> findLabelByTaskAndParagraph(Integer task_id,Integer paragraph_id){return labelResultDao.findLabelByTaskAndParagraph(task_id, paragraph_id);}
    public int findFinishParagraphNumByTaskId(Integer task_id,String user_account){return labelResultDao.findFinishParagraphNumByTaskId(task_id, user_account);}
    public List<LabelResult> findFirstUnfinishedParagraph(Integer task_id,String user_account){return labelResultDao.findFirstUnfinishedParagraph(task_id, user_account);}
    public List<LabelResult> findNextUnfinishedParagraph(Integer task_id,String user_account,String paragraph_position){return labelResultDao.findNextUnfinishedParagraph(task_id, user_account,paragraph_position);}
    public List<LabelResult> findLastUnfinishedParagraph(Integer task_id,String user_account,String paragraph_position){return labelResultDao.findLastUnfinishedParagraph(task_id, user_account,paragraph_position);}
    public List<LabelResult> findLabelResultById(Integer id){return labelResultDao.findLabelResultById(id);}

}

