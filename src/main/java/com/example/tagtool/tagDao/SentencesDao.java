package com.example.tagtool.tagDao;

import com.example.tagtool.tagEntity.Sentences;
import org.springframework.stereotype.Repository;

@Repository
public interface SentencesDao {
    public int insertSentence(Sentences content);
    public int deleteSentence(Sentences content);
    public String findSentenceById(Integer id);
}
