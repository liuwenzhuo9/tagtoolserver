package com.example.tagtool.tagController;

import com.example.tagtool.tagEntity.Sentences;
import com.example.tagtool.tagService.SentencesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SentencesController {
    @Resource
    private SentencesService sentencesService;

//    插入句子
    @RequestMapping("/insertSentence")
    @ResponseBody
    public ResponseBean insertSentence(String content){
        ResponseBean response = new ResponseBean();
        response.setMessage("插入成功");
        response.setData(sentencesService.insertSentence(content));
        return response;
    }

//    删除句子
    @RequestMapping("/deleteSentence")
    @ResponseBody
    public ResponseBean deleteSentence(String content){
        ResponseBean response = new ResponseBean();
        response.setData(sentencesService.deleteSentence(content));
        response.setMessage("删除成功");
        return response;
    }

//    根据id查询句子内容
    @RequestMapping("/findSentenceById")
    @ResponseBody
    public ResponseBean findSentenceById(Integer id){
        ResponseBean response = new ResponseBean();
        response.setData(sentencesService.findSentenceById(id));
        response.setMessage("查询成功");
        return response;
    }

    //    更新句子编辑状态
    @RequestMapping("/updateSentenceMark")
    @ResponseBody
    public ResponseBean updateSentenceMark(Integer is_marked){
        ResponseBean response = new ResponseBean();
        response.setData(sentencesService.updateSentenceMarkById(is_marked));
        response.setMessage("更新成功");
        return response;
    }

//    获取所有句子
    @RequestMapping("/getAllSentences")
    @ResponseBody
    public ResponseBean getAllSentences(){
        ResponseBean response = new ResponseBean();
        response.setMessage("查询成功");
        response.setData(sentencesService.getAllSentences());
        return response;
    }
}
