package com.example.tagtool.tagEntity;

import javax.persistence.*;

@Entity
@Table(name = "tb_entityindex")
public class EntityIndex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int id_entity;
    private int id_sentence;
    private int start_index;
    private int end_index;
    private String author;

    public int getId() { return id; }

    public int getEnd_index() {
        return end_index;
    }

    public int getId_entity() {
        return id_entity;
    }

    public int getId_sentence() {
        return id_sentence;
    }

    public int getStart_index() {
        return start_index;
    }

    public String getAuthor() {  return author; }

    public void setId(int id) { this.id = id; }

    public void setEnd_index(int end_index) {
        this.end_index = end_index;
    }

    public void setId_entity(int id_entity) {
        this.id_entity = id_entity;
    }

    public void setId_sentence(int id_sentence) {
        this.id_sentence = id_sentence;
    }

    public void setStart_index(int start_index) {
        this.start_index = start_index;
    }

    public void setAuthor(String author) { this.author = author; }

    @Override
    public String toString() {
        return "EntityIndex{" +
                "id_entity=" + id_entity +
                ",id_sentence=" + id_sentence +
                ",start_index=" + start_index +
                ",end_index=" + end_index +
                ",author=" + author +
                '}';
    }
}
