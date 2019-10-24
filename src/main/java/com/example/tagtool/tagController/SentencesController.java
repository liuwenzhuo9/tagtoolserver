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

    //    根据句子内容查询id
    @RequestMapping("/findIdBySentence")
    @ResponseBody
    public ResponseBean findIdBySentence(String content){
        ResponseBean response = new ResponseBean();
        response.setData(sentencesService.findIdBySentence(content));
        response.setMessage("查询成功");
        return response;
    }

//    更新句子内容
    @RequestMapping("/updateSentenceContentById")
    @ResponseBody
    public ResponseBean updateSentenceContentById(Sentences sentences){
        ResponseBean response = new ResponseBean();
        response.setData(sentencesService.updateSentenceContentById(sentences));
        response.setMessage("更新成功");
        return response;
    }

    //    更新句子编辑状态
    @RequestMapping("/updateSentenceMarkById")
    @ResponseBody
    public ResponseBean updateSentenceMark(Sentences sentences){
        ResponseBean response = new ResponseBean();
        response.setData(sentencesService.updateSentenceMarkById(sentences));
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

//根据id查到上一条数据
    @RequestMapping("/getLastSentence")
    @ResponseBody
    public ResponseBean getLastSentence(Integer id){
        ResponseBean response = new ResponseBean();
        response.setMessage("查询成功");
        response.setData(sentencesService.getLastSentence(id));
        return response;
    }

//    根据id查到下一条数据
    @RequestMapping("/getNextSentence")
    @ResponseBody
    public ResponseBean getNextSentence(Integer id){
        ResponseBean response = new ResponseBean();
        response.setMessage("查询成功");
        response.setData(sentencesService.getNextSentence(id));
        return response;
    }

//    找到第一个可被标记的句子
    @RequestMapping("/getFirstUnmarkedSentence")
    @ResponseBody
    public ResponseBean getFirstUnmarkedSentence(){
        ResponseBean response = new ResponseBean();
        response.setMessage("查询成功");
        response.setData(sentencesService.getFirstUnmarkedSentence());
        return response;
    }
}
