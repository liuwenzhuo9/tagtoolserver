package com.example.tagtool.tagEntity;

import javax.persistence.*;
@Entity
@Table(name = "tb_time")
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String account;
    private int task_id;
    private int use_time;
    private int is_finish;

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTask_id() {
        return task_id;
    }

    public int getId() {
        return id;
    }

    public int getIs_finish() {
        return is_finish;
    }

    public int getUse_time() {
        return use_time;
    }

    public void setUse_time(int use_time) {
        this.use_time = use_time;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setIs_finish(int is_finish) {
        this.is_finish = is_finish;
    }


    @Override
    public String toString(){
        return "Time{" +
                "id=" + id +
                ", account='" + account + '\'' +
                "task_id=" + task_id +
                "use_time=" + use_time +
                "is_finish=" + is_finish +
                '}';
    }
}
