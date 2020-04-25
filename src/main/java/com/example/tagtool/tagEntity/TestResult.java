package com.example.tagtool.tagEntity;

import javax.persistence.*;

@Entity
@Table(name = "tb_test_result")
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int task_id;
    private int paragraph_id;
    private String paragraph_position;
    private String res_label;
    private String user_account;
    private int task_type;

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public void setParagraph_position(String paragraph_position) {
        this.paragraph_position = paragraph_position;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParagraph_position() {
        return paragraph_position;
    }

    public int getTask_id() {
        return task_id;
    }

    public int getId() {
        return id;
    }

    public int getTask_type() {
        return task_type;
    }

    public int getParagraph_id() {
        return paragraph_id;
    }

    public String getRes_label() {
        return res_label;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setParagraph_id(int paragraph_id) {
        this.paragraph_id = paragraph_id;
    }

    public void setRes_label(String res_label) {
        this.res_label = res_label;
    }

    public void setTask_type(int task_type) {
        this.task_type = task_type;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }
    @Override
    public String toString(){
        return "TestResult{" +
                "id=" + id +
                "task_id=" + task_id +
                "paragraph_id=" + paragraph_id +
                ", paragraph_position='" + paragraph_position + '\'' +
                ", user_account='" + user_account + '\'' +
                ", res_label='" + res_label + '\'' +
                ", task_type=" + task_type +
                '}';
    }
}
