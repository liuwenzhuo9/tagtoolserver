package com.example.tagtool.tagEntity;

import javax.persistence.*;

@Entity
@Table(name = "tb_test_content")
public class TestContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int task_id;
    private String content;
    private String paragraph_position;
    private String test_label;

    public int getId() {
        return id;
    }

    public int getTask_id() {
        return task_id;
    }

    public String getContent() {
        return content;
    }

    public String getParagraph_position() {
        return paragraph_position;
    }

    public String getTest_label() {
        return test_label;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setParagraph_position(String paragraph_position) {
        this.paragraph_position = paragraph_position;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public void setTest_label(String test_label) {
        this.test_label = test_label;
    }
    @Override
    public String toString(){
        return "TaskContent{" +
                "id=" + id +
                ",task_id=" + task_id +
                ", content='" + content + '\'' +
                ", paragraph_position='" + paragraph_position + '\'' +
                ",test_label=" + test_label + '\'' +
                '}';
    }
}
