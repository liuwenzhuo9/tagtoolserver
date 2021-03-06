package com.example.tagtool.tagEntity;

import javax.persistence.*;

@Entity
@Table(name = "tb_label_result")
public class LabelResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int task_id;
    private int paragraph_id;
    private int paragraph_position;
    private String user_account;
    private String label_result;
    private int task_type;
    private int is_test;

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public void setTask_type(int task_type) {
        this.task_type = task_type;
    }

    public void setParagraph_id(int paragraph_id) {
        this.paragraph_id = paragraph_id;
    }

    public String getUser_account() {
        return user_account;
    }

    public int getParagraph_id() {
        return paragraph_id;
    }

    public int getTask_type() {
        return task_type;
    }

    public int getId() {
        return id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setParagraph_position(int paragraph_position) {
        this.paragraph_position = paragraph_position;
    }

    public int getParagraph_position() {
        return paragraph_position;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getLabel_result() {
        return label_result;
    }

    public void setLabel_result(String label_result) {
        this.label_result = label_result;
    }

    public int getIs_test() {
        return is_test;
    }

    public void setIs_test(int is_test) {
        this.is_test = is_test;
    }

    @Override
    public String toString(){
        return "LabelResult{" +
                "id=" + id +
                ", task_id=" + task_id +
                ", paragraph_id=" + paragraph_id +
                ", paragraph_position='" + paragraph_position +
                ", user_account='" + user_account + '\'' +
                ", label_result='" + label_result + '\'' +
                ", task_type=" + task_type +
                ", is_test=" + is_test +
                '}';
    }
}
