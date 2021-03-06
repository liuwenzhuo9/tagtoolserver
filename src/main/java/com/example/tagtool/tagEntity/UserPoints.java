package com.example.tagtool.tagEntity;

import javax.persistence.*;

@Entity
@Table(name = "tb_user_points")
public class UserPoints {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String account;
    private int task_id;
    private int task_type;
    private double points;
    private double power;
    private int operation_type;
    private double complete_rate;

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

    public double getPower() {
        return power;
    }

    public int getOperation_type() {
        return operation_type;
    }

    public void setOperation_type(int operation_type) {
        this.operation_type = operation_type;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public void setComplete_rate(double complete_rate) {
        this.complete_rate = complete_rate;
    }

    public double getComplete_rate() {
        return complete_rate;
    }

    @Override
    public String toString(){
        return "UserPoints{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", task_id=" + task_id +
                ", task_type=" + task_type +
                ", points=" + points +
                ", power=" + power +
                ", operation_type=" + operation_type +
                ", complete_rate=" + complete_rate +
                '}';
    }
}
