package com.example.tagtool.tagEntity;

import javax.persistence.*;

@Entity
@Table(name = "tb_taskContent")
public class TaskContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int task_id;
    private String content;
    private int paragh_postion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParagh_postion() {
        return paragh_postion;
    }

    public int getTask_id() {
        return task_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setParagh_postion(int paragh_postion) {
        this.paragh_postion = paragh_postion;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    @Override
    public String toString(){
        return "TaskContent{" +
                "id=" + id +
                ",task_id=" + task_id +
                ", content='" + content + '\'' +
                ",paragh_postion=" + paragh_postion +
                '}';
    }
}
