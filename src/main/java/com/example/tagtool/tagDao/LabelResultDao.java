package com.example.tagtool.tagDao;

import com.example.tagtool.tagEntity.LabelResult;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelResultDao {
//    插入用户的标注结果
    int insertLabelResult(LabelResult labelResult);
//    根据标注的信息id更新标注信息
    int updateLabelById(Integer id,String label_result);
//    根据标注者账号删除标注信息
    int deleteLabelByAccount(String user_account);
//    根据任务id删除标注信息
    int deleteLabelByTaskId(Integer task_id);
//    根据任务id和用户account删除标注信息
    int deleteLabelByTaskIdAndAccount(String user_account,Integer task_id);
//    根据任务id和段落id查询标注结果
    List<LabelResult> findLabelByTaskAndParagraph(Integer task_id,Integer paragraph_id);
//    根据任务id和用户account查询已标注的段落数
    int findFinishParagraphNumByTaskId(Integer task_id,String user_account);
//    根据任务id和用户account查询第一条未被标记的段落id
    List<LabelResult> findFirstUnfinishedParagraph(Integer task_id,String user_account);
//    根据任务id、用户账号、当前段落位置找到下一条未被标记的段落
    List<LabelResult> findNextUnfinishedParagraph(Integer task_id,String user_account,Integer paragraph_position);
//    根据任务id、用户账号、当前段落位置找到上一条未被标记的段落
    List<LabelResult> findLastUnfinishedParagraph(Integer task_id,String user_account,Integer paragraph_position);
//    根据任务id和用户account查询第一条段落
    List<LabelResult> findFirstParagraph(Integer task_id,String user_account);
//    根据任务id、用户账号、当前段落位置找到下一条段落
    List<LabelResult> findNextParagraph(Integer task_id,String user_account,Integer paragraph_position);
//    根据任务id、用户账号、当前段落位置找到上一条段落
    List<LabelResult> findLastParagraph(Integer task_id,String user_account,Integer paragraph_position);
//    根据任务id和用户账号查询标注结果
    List<String> findLabelResultByTaskIdAndAccount(Integer task_id,String user_account);
//    根据任务id和用户账号查询段落id
    List<Integer> findParaIdByTaskIdAndAccount(Integer task_id,String user_account);
}
