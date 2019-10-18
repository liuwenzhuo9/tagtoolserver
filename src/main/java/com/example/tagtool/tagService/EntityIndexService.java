package com.example.tagtool.tagService;

import com.example.tagtool.tagDao.EntityIndexDao;
import com.example.tagtool.tagEntity.EntityIndex;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EntityIndexService {
    @Resource
    private EntityIndexDao entityIndexDao;

//插入实体位置信息
    public int insertEntityIndex (EntityIndex entityIndex) {return entityIndexDao.insertEntityIndex(entityIndex);}

//    根据句子id删除实体位置信息
    public int deleteEntityBySentenceId (Integer id_sentence) {return entityIndexDao.deleteEntityBySentenceId(id_sentence);}

//    根据句子id获取实体位置信息
    public List<EntityIndex> getEntityIndexBySentenceId(Integer id_sentence) {return entityIndexDao.getEntityIndexBySentenceId(id_sentence);}

//    根据实体id删除实体位置信息
    public int deleteEntityByEntityId(Integer id_entity) {return entityIndexDao.deleteEntityByEntityId(id_entity);}
}
