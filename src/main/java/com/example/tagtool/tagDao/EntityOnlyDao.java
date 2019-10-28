package com.example.tagtool.tagDao;

import com.example.tagtool.tagEntity.EntityOnly;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityOnlyDao {
    int insertEntity(EntityOnly entityOnly);
    int deleteEntity(String content);
    String findEntityById(Integer id);
    int findIdByEntity(String content);
//    int updateLengthByEntityId(EntityOnly entityOnly);
}
