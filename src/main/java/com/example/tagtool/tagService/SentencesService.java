package com.example.tagtool.tagService;

import com.example.tagtool.tagDao.SentencesDao;
import com.example.tagtool.tagEntity.Sentences;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SentencesService {
    @Resource
    private SentencesDao sentencesDao;
//    插入句子
    public int insertSentence(String content) {return sentencesDao.insertSentence(content);}
//    删除句子
    public int deleteSentence(String content) {return sentencesDao.deleteSentence(content);}
//    根据句子id获取句子内容
    public String findSentenceById(Integer id) {return sentencesDao.findSentenceById(id);}
    //    根据句子内容获取句子id
    public int findIdBySentence(String content) {return sentencesDao.findIdBySentence(content);}
//    更新句子内容
    public int updateSentenceContentById(Sentences sentences) {return sentencesDao.updateSentenceContentById(sentences);}
    //    更新句子编辑状态
    public int updateSentenceMarkById(Sentences sentences){return sentencesDao.updateSentenceMarkById(sentences);}
//获取所有句子
    public List<Sentences> getAllSentences(Integer is_marked){return sentencesDao.getAllSentences(is_marked);}
//    根据id查到上一条数据
    public List<Sentences> getLastSentence(Integer id,Integer is_marked){return sentencesDao.getLastSentence(id,is_marked);}
//    根据id查到下一条数据
    public List<Sentences> getNextSentence(Integer id,Integer is_marked){return sentencesDao.getNextSentence(id,is_marked);}
//    找到第一个可被标记的句子
    public List<Sentences> getFirstUnmarkedSentence(){return sentencesDao.getFirstUnmarkedSentence();}
//    根据id查询句子的索引号
    public int findIndexBySentenceId(Integer id){return sentencesDao.findIndexBySentenceId(id);}
//    查询从offset开始的count条数据
    public List<Sentences> findSentenceFromOffset(Integer offset,Integer count){return sentencesDao.findSentenceFromOffset(offset,count);}
    public int deleteSentenceFromOffset(Integer offset,Integer count){return sentencesDao.deleteSentenceFromOffset(offset,count);}
    public int findUnmarkedNum(){return sentencesDao.findUnmarkedNum();}
}
