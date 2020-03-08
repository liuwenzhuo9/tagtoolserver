package com.example.tagtool.tagEntity;

import javax.persistence.*;

@Entity
@Table(name="tb_sentences")
public class Sentences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    private int is_marked;
    private String author;

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public int getIs_marked() {
        return is_marked;
    }

    public String getAuthor() {  return author; }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIs_marked(int is_marked) {
        this.is_marked = is_marked;
    }

    public void setAuthor(String author) {  this.author = author;}

    @Override
    public String toString() {
        return "Sentences{" +
                "id=" + id +
                ", content='" + content +
                ", is_marked=" + is_marked +
                ",author=" + author +
                '}';
    }

}
