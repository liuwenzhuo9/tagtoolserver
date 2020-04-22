package com.example.tagtool.tagController;

import com.example.tagtool.tagEntity.TaskContent;
import com.example.tagtool.tagEntity.TestContent;
import com.example.tagtool.tagService.TaskContentService;
import com.example.tagtool.tagService.TestContentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestContentController {
    @Resource
    private TestContentService testContentService;

    @RequestMapping("/insertTestContent")
    @ResponseBody
    public ResponseBean insertTestContent(TestContent testContent){
        int data = testContentService.insertTestContent(testContent);
        if(data == 1){
            return new ResponseBean("插入成功",data);
        }else{
            return new ResponseBean("插入失败",data);
        }
    }

    @RequestMapping("/deleteTestContentByTaskId")
    @ResponseBody
    public ResponseBean deleteTestContentByTaskId(Integer task_id){
        int data = testContentService.deleteTestContentByTaskId(task_id);
        return new ResponseBean("删除成功",data);
    }

    @RequestMapping("/findTestContentByTaskId")
    @ResponseBody
    public ResponseBean findContentByTaskId(Integer task_id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(testContentService.findTestContentByTaskId(task_id));
        responseBean.setMessage("查询成功");
        return responseBean;
    }
    @RequestMapping("/findTestParagraphNumByTaskId")
    @ResponseBody
    public ResponseBean findTestParagraphNumByTaskId(Integer task_id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(testContentService.findTestParagraphNumByTaskId(task_id));
        responseBean.setMessage("查询成功");
        return responseBean;
    }
    @RequestMapping("/findTestContentByParagraphId")
    @ResponseBody
    public ResponseBean findTestContentByParagraphId(Integer id){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(testContentService.findTestContentByParagraphId(id));
        responseBean.setMessage("查询成功");
        return responseBean;
    }
    @RequestMapping("/updateRightLabel")
    @ResponseBody
    public ResponseBean updateRightLabel(Integer task_id,String paragraph_position,String test_label){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(testContentService.updateRightLabel(task_id, paragraph_position, test_label));
        responseBean.setMessage("更新成功");
        return responseBean;
    }
}

