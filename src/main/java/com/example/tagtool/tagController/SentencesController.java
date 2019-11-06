package com.example.tagtool.tagController;

import com.example.tagtool.tagEntity.Sentences;
import com.example.tagtool.tagService.EntityIndexService;
import com.example.tagtool.tagService.SentencesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class SentencesController {
    @Resource
    private SentencesService sentencesService;

    @Resource
    private EntityIndexService entityIndexService;

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
        int idData = sentencesService.findIdBySentence(content);
        int data = sentencesService.deleteSentence(content);
        if (data == 1) {
            return new ResponseBean("删除成功", idData);
        } else {
            return new ResponseBean("删除失败", data);
        }
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
    public ResponseBean getLastSentence(Integer id, Integer is_marked){
        List<Sentences> listData = sentencesService.getLastSentence(id, is_marked);
        if(listData == null||listData.isEmpty()){
            return new ResponseBean("查询失败", 0);
        }else{
            return new ResponseBean("查询成功", listData);
        }

    }

//    根据id查到下一条数据
    @RequestMapping("/getNextSentence")
    @ResponseBody
    public ResponseBean getNextSentence(Integer id, Integer is_marked){
        List<Sentences> listData = sentencesService.getNextSentence(id, is_marked);
        if(listData == null||listData.isEmpty()){
            return new ResponseBean("查询失败", 0);
        }else{
            return new ResponseBean("查询成功", listData);
        }
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
//    根据id查询句子的索引号
    @RequestMapping("/findIndexBySentenceId")
    @ResponseBody
    public ResponseBean findIndexBySentenceId(Integer id){
        ResponseBean response = new ResponseBean();
        response.setMessage("查询成功");
        response.setData(sentencesService.findIndexBySentenceId(id));
        return response;
    }
//    查询从offset开始的count条数据
    @RequestMapping("/findSentenceFromOffset")
    @ResponseBody
    public ResponseBean findSentenceFromOffset(Integer offset,Integer count){
        ResponseBean response = new ResponseBean();
        response.setMessage("查询成功");
        response.setData(sentencesService.findSentenceFromOffset(offset,count));
        return response;
    }

    @RequestMapping("/deleteSentenceFromOffset")
    @ResponseBody
    public ResponseBean deleteSentenceFromOffset (Integer offset,Integer count){
        List<Sentences> listData = sentencesService.findSentenceFromOffset(offset,count);
        int size = listData.size();
        int returnData = 0;
        for(int i = 0; i < size;i++){
            Sentences list = listData.get(i);
            int idData = sentencesService.deleteSentence(list.getContent());
            int indexData = entityIndexService.deleteEntityBySentenceId(list.getId());
            returnData = returnData + idData - indexData;
        }
        if(returnData == 0){
            return new ResponseBean("删除成功", 1);
        }else{
            return new ResponseBean("删除失败", 0);
        }

    }

}
