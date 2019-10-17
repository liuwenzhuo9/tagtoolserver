package com.example.tagtool.tagEntity;

import javax.persistence.*;

@Entity
@Table(name= "tb_entityonly")
public class EntityOnly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "EntityOnly{" +
                "id=" + id +
                ", content='" + content +'\'' +
                '}';
    }

}
