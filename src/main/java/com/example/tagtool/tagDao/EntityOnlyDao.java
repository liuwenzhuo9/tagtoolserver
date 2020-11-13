package com.example.tagtool.tagDao;

import com.example.tagtool.tagEntity.EntityOnly;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntityOnlyDao {
//    插入实体
    int insertEntity(EntityOnly entityOnly);
//    删除实体
    int deleteEntity(String content);
//    根据实体id找实体内容
    String findEntityById(Integer id);
//    根据实体内容找实体id
    int findIdByEntity(String content);
//    获取所有实体，用于预标记
    List<EntityOnly> getAllEntity();
}
