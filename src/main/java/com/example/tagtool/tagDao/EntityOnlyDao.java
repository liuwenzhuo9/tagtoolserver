package com.example.tagtool.tagDao;

import com.example.tagtool.tagEntity.EntityOnly;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntityOnlyDao {
    int insertEntity(EntityOnly entityOnly);
    int deleteEntity(String content);
    String findEntityById(Integer id);
    int findIdByEntity(String content);
    List<EntityOnly> getAllEntity();
}
