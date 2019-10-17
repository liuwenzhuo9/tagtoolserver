package com.example.tagtool.tagController;

import com.example.tagtool.tagEntity.EntityOnly;
import com.example.tagtool.tagService.EntityOnlyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class EntityOnlyController {
    @Resource
    private EntityOnlyService entityOnlyService;

//    插入实体
@RequestMapping("/insertEntity")
    @ResponseBody
    public ResponseBean insertEntity(String content){
    int data = entityOnlyService.insertEntity(content);
    if(data == 1){
        return new ResponseBean("插入成功", content);
    }else {
        return new ResponseBean("插入失败", data);
    }
    }

//    删除实体
    @RequestMapping("/deleteEntity")
    @ResponseBody
    public ResponseBean deleteEntity(String content){
    ResponseBean response = new ResponseBean();
    int result = entityOnlyService.deleteEntity(content);
    if (result == 1){
        response.setData(result);
        response.setMessage("删除成功");
    }else{
        response.setMessage("删除失败");
        response.setData(0);
    }
    return response;
    }

//    根据实体id查询实体内容
    @RequestMapping("/findEntityById")
    @ResponseBody
    public ResponseBean findEntityById(Integer id){
    ResponseBean response = new ResponseBean();
        response.setMessage("查询成功");
        response.setData(entityOnlyService.findEntityById(id));
        return response;
    }

//    根据实体内容查询实体id
    @RequestMapping("/findIdByEntity")
    @ResponseBody
    public ResponseBean findIdByEntity(String content){
    ResponseBean response = new ResponseBean();
        response.setData(entityOnlyService.findIdByEntity(content));
        response.setMessage("查询成功");
    return response;
    }
}
