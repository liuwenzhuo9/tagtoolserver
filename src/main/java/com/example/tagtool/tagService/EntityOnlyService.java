package com.example.tagtool.tagService;

import com.example.tagtool.tagDao.EntityOnlyDao;
import com.example.tagtool.tagEntity.EntityOnly;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EntityOnlyService {
    @Resource
    private EntityOnlyDao entityOnlyDao;
//插入实体
    public int insertEntity(EntityOnly entityOnly) { return entityOnlyDao.insertEntity(entityOnly);}

//删除实体
    public int deleteEntity(String content) {return entityOnlyDao.deleteEntity(content);}

//    根据id查询实体
    public String findEntityById(Integer id) {return entityOnlyDao.findEntityById(id);}

//    根据实体内容查询实体id
    public int findIdByEntity(String content) {return entityOnlyDao.findIdByEntity(content);}

//    获取所有实体，用于预标记
    public List<EntityOnly> getAllEntity(){return entityOnlyDao.getAllEntity();}
}
