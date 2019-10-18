package com.example.tagtool.tagController;

import com.example.tagtool.tagEntity.EntityIndex;
import com.example.tagtool.tagService.EntityIndexService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class EntityIndexController {
    @Resource
    private EntityIndexService entityIndexService;

//    插入实体位置信息
    @RequestMapping("/insertEntityIndex")
    @ResponseBody
    public ResponseBean insertEntityIndex(EntityIndex entityIndex){
        ResponseBean response = new ResponseBean();
        response.setData(entityIndexService.insertEntityIndex(entityIndex));
        response.setMessage("插入成功");
        return response;
    }

//    根据句子id删除实体位置信息
    @RequestMapping("/deleteEntityBySentenceId")
    @ResponseBody
    public ResponseBean deleteEntityBySentenceId(Integer id_sentence){
        ResponseBean response = new ResponseBean();
        response.setMessage("删除成功");
        response.setData(entityIndexService.deleteEntityBySentenceId(id_sentence));
        return response;
    }

//根据句子id获取实体位置信息
    @RequestMapping("/getEntityIndexBySentenceId")
    @ResponseBody
    public ResponseBean getEntityIndexBySentenceId(Integer id_sentence){
        ResponseBean response = new ResponseBean();
        response.setData(entityIndexService.getEntityIndexBySentenceId(id_sentence));
        response.setMessage("查询成功");
        return response;
    }

//    根据实体id删除实体位置信息
    @RequestMapping("/deleteEntityByEntityId")
    @ResponseBody
    public ResponseBean deleteEntityByEntityId(Integer id_entity){
        ResponseBean response = new ResponseBean();
        response.setMessage("删除成功");
        response.setData(entityIndexService.deleteEntityByEntityId(id_entity));
        return response;
    }
}
