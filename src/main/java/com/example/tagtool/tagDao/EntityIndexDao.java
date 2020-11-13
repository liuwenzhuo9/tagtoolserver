package com.example.tagtool.tagDao;

import com.example.tagtool.tagEntity.EntityIndex;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntityIndexDao {
//    插入实体位置信息
    int insertEntityIndex (EntityIndex entityIndex);
//    根据句子id删除实体位置信息
    int deleteEntityBySentenceId (Integer id_sentence);
//    根据句子id获取实体位置信息
    List<EntityIndex> getEntityIndexBySentenceId(Integer id_sentence);
//    根据实体id删除实体位置信息
    int deleteEntityByEntityId(Integer id_entity);
}
