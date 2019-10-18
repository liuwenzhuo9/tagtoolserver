package com.example.tagtool.tagDao;

import com.example.tagtool.tagEntity.EntityIndex;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntityIndexDao {
    int insertEntityIndex (EntityIndex entityIndex);
    int deleteEntityBySentenceId (Integer id_sentence);
    List<EntityIndex> getEntityIndexBySentenceId(Integer id_sentence);
    int deleteEntityByEntityId(Integer id_entity);
}
