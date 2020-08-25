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
    private int is_test;//为1表示测试句子
    private String test_label;
    private int task_type;//为1表示标签标注

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

    public void setIs_test(int is_test) {
        this.is_test = is_test;
    }

    public int getIs_test() {
        return is_test;
    }

    public void setTask_type(int task_type) {
        this.task_type = task_type;
    }

    public int getTask_type() {
        return task_type;
    }

    public void setTest_label(String test_label) {
        this.test_label = test_label;
    }

    public String getTest_label() {
        return test_label;
    }

    @Override
    public String toString(){
        return "TaskContent{" +
                "id=" + id +
                ",task_id=" + task_id +
                ", task_name='" + task_name + '\'' +
                ", content='" + content + '\'' +
                ",paragraph_position=" + paragraph_position +
                "is_test=" + is_test +
                "task_type=" + task_type +
                ", test_label='" + test_label + '\'' +
                '}';
    }
}
