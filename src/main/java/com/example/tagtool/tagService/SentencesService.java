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
    //    更新句子编辑状态
    public int updateSentenceMarkById(Sentences sentences){return sentencesDao.updateSentenceMarkById(sentences);}
//获取所有句子
    public List<Sentences> getAllSentences(){return sentencesDao.getAllSentences();}
}
