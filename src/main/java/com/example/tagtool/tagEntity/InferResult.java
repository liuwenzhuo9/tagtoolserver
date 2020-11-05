package com.example.tagtool.tagEntity;

import javax.persistence.*;

@Entity
@Table(name = "tb_infer_result")
public class InferResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int task_id;
    private int paragraph_id;
    private int paragraph_position;
    private String infer_result;
    private int task_type;
    private String content;
    private String ci;
    private String final_result;//存放众包发布者确认后的结果

    public int getId() {
        return id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public int getParagraph_position() {
        return paragraph_position;
    }

    public void setParagraph_position(int paragraph_position) {
        this.paragraph_position = paragraph_position;
    }

    public int getTask_type() {
        return task_type;
    }

    public void setTask_type(int task_type) {
        this.task_type = task_type;
    }

    public String getInfer_result() {
        return infer_result;
    }

    public void setInfer_result(String infer_result) {
        this.infer_result = infer_result;
    }

    public void setParagraph_id(int paragraph_id) {
        this.paragraph_id = paragraph_id;
    }

    public int getParagraph_id() {
        return paragraph_id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getCi() {
        return ci;
    }

    public void setFinal_result(String final_result) {
        this.final_result = final_result;
    }

    public String getFinal_result() {
        return final_result;
    }

    @Override
    public String toString(){
        return "InferResult{" +
                "id=" + id +
                "task_id=" + task_id +
                "paragraph_id=" + paragraph_id +
                "paragraph_position='" + paragraph_position +
                ", infer_result='" + infer_result + '\'' +
                ", task_type=" + task_type +
                ", content=" + content + '\'' +
                ", ci=" + ci + '\'' +
                ", final_result=" + final_result + '\'' +
                '}';
    }
}
