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
//    插入用户的标注结果
    public int insertLabelResult(LabelResult labelResult){return labelResultDao.insertLabelResult(labelResult);}
//    根据标注的信息id更新标注信息
    public int updateLabelById(Integer id,String label_result){return labelResultDao.updateLabelById(id,label_result);}
//    根据标注者账号删除标注信息
    public int deleteLabelByAccount(String user_account){return labelResultDao.deleteLabelByAccount(user_account);}
//    根据任务id删除标注信息
    public int deleteLabelByTaskId(Integer task_id){return labelResultDao.deleteLabelByTaskId(task_id);}
//    根据任务id和用户account删除标注信息
    public int deleteLabelByTaskIdAndAccount(String user_account,Integer task_id){return labelResultDao.deleteLabelByTaskIdAndAccount(user_account, task_id);}
//    根据任务id和段落id查询标注结果
    public List<LabelResult> findLabelByTaskAndParagraph(Integer task_id,Integer paragraph_id){return labelResultDao.findLabelByTaskAndParagraph(task_id, paragraph_id);}
//    根据任务id和用户account查询已标注的段落数
    public int findFinishParagraphNumByTaskId(Integer task_id,String user_account){return labelResultDao.findFinishParagraphNumByTaskId(task_id, user_account);}
//    根据任务id和用户account查询第一条未被标记的段落id
    public List<LabelResult> findFirstUnfinishedParagraph(Integer task_id,String user_account){return labelResultDao.findFirstUnfinishedParagraph(task_id, user_account);}
//    根据任务id、用户账号、当前段落位置找到下一条未被标记的段落
    public List<LabelResult> findNextUnfinishedParagraph(Integer task_id,String user_account,Integer paragraph_position){return labelResultDao.findNextUnfinishedParagraph(task_id, user_account,paragraph_position);}
//    根据任务id、用户账号、当前段落位置找到上一条未被标记的段落
    public List<LabelResult> findLastUnfinishedParagraph(Integer task_id,String user_account,Integer paragraph_position){return labelResultDao.findLastUnfinishedParagraph(task_id, user_account,paragraph_position);}
//    根据任务id和用户account查询第一条段落
    public List<LabelResult> findFirstParagraph(Integer task_id,String user_account){return labelResultDao.findFirstParagraph(task_id, user_account);}
//    根据任务id、用户账号、当前段落位置找到下一条段落
    public List<LabelResult> findNextParagraph(Integer task_id,String user_account,Integer paragraph_position){return labelResultDao.findNextParagraph(task_id, user_account,paragraph_position);}
//    根据任务id、用户账号、当前段落位置找到上一条段落
    public List<LabelResult> findLastParagraph(Integer task_id,String user_account,Integer paragraph_position){return labelResultDao.findLastParagraph(task_id, user_account,paragraph_position);}
//    根据任务id和用户账号查询标注结果
    public List<String> findLabelResultByTaskIdAndAccount(Integer task_id,String user_account){return labelResultDao.findLabelResultByTaskIdAndAccount(task_id, user_account);}
//    根据任务id和用户账号查询段落id
    public List<Integer> findParaIdByTaskIdAndAccount(Integer task_id, String user_account) {return labelResultDao.findParaIdByTaskIdAndAccount(task_id, user_account);}

}

