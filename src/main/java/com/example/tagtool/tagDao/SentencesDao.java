package com.example.tagtool.tagDao;

import com.example.tagtool.tagEntity.Sentences;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SentencesDao {
    public int insertSentence(String content);
    public int deleteSentence(String content);
    String findSentenceById(Integer id);
    int updateSentenceMarkById(Integer id);
    List<Sentences> getAllSentences();
}
