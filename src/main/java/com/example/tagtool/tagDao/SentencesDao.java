package com.example.tagtool.tagDao;

import com.example.tagtool.tagEntity.Sentences;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SentencesDao {
    public int insertSentence(String content);
    public int deleteSentence(String content);
    String findSentenceById(Integer id);
    int findIdBySentence(String content);
    int updateSentenceContentById(Sentences sentences);
    int updateSentenceMarkById(Sentences sentences);
    List<Sentences> getAllSentences();
    List<Sentences> getLastSentence(Integer id);
    List<Sentences> getNextSentence(Integer id);
    List<Sentences> getFirstUnmarkedSentence();
    int findIndexBySentenceId(Integer id);
    List<Sentences> findSentenceFromOffset(Integer offset,Integer count);
}
