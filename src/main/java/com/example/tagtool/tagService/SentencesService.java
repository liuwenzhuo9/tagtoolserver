package com.example.tagtool.tagService;

import com.example.tagtool.tagDao.SentencesDao;
import com.example.tagtool.tagEntity.Sentences;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SentencesService {
    @Resource
    private SentencesDao sentencesDao;
//    插入句子
    public int insertSentence(Sentences content) {return sentencesDao.insertSentence(content);}
//    删除句子
    public int deleteSentence(Sentences content) {return sentencesDao.deleteSentence(content);}
//    根据句子id获取句子内容
    public String findSentenceById(Integer id) {return sentencesDao.findSentenceById(id);}
}
