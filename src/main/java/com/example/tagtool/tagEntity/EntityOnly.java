package com.example.tagtool.tagEntity;

import javax.persistence.*;

@Entity
@Table(name= "tb_entityonly")
public class EntityOnly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    private int length;

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public int getLength() {
        return length;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "EntityOnly{" +
                "id=" + id +
                ", content='" + content +'\'' +
                ", length=" + length +
                '}';
    }

}
