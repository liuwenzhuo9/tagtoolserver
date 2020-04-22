package com.example.tagtool.tagEntity;

import javax.persistence.*;

@Entity
@Table(name = "tb_task_content")
public class TaskContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int task_id;
    private String content;
    private int paragraph_position;
    private String task_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParagraph_position() {
        return paragraph_position;
    }

    public void setParagraph_position(int paragraph_position) {
        this.paragraph_position = paragraph_position;
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

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_name() {
        return task_name;
    }

    @Override
    public String toString(){
        return "TaskContent{" +
                "id=" + id +
                ",task_id=" + task_id +
                ", task_name='" + task_name + '\'' +
                ", content='" + content + '\'' +
                ",paragraph_position=" + paragraph_position +
                '}';
    }
}
