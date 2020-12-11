package com.example.tagtool.tagEntity;

import javax.persistence.*;

@Entity
@Table(name = "tb_user_points")
public class UserPoints {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String account;
    private int task_id;
    private int task_type;
    private double points;

    public void setPoints(double points) {
        this.points = points;
    }

    public double getPoints() {
        return points;
    }

    public void setTask_type(int task_type) {
        this.task_type = task_type;
    }

    public int getTask_type() {
        return task_type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "UserPoints{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                "task_id=" + task_id +
                "task_type=" + task_type +
                "points=" + points +
                '}';
    }
}
