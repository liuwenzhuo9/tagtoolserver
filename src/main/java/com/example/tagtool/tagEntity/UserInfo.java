package com.example.tagtool.tagEntity;

import javax.persistence.*;

@Entity
@Table(name = "tb_user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String account;
    private String involved_tasks;
    private String finished_tasks;
    private String progress_tasks;
    private String issue_tasks;
    private double power_l1;
    private double power_l2;
    private double power_l3;
    private double power_s;
    private double points;
    private double complete_rate;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public String getFinished_tasks() {
        return finished_tasks;
    }

    public String getInvolved_tasks() {
        return involved_tasks;
    }

    public String getName() {
        return name;
    }

    public String getProgress_tasks() {
        return progress_tasks;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setFinished_tasks(String finished_tasks) {
        this.finished_tasks = finished_tasks;
    }

    public void setInvolved_tasks(String involved_tasks) {
        this.involved_tasks = involved_tasks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProgress_tasks(String progress_tasks) {
        this.progress_tasks = progress_tasks;
    }

    public String getIssue_tasks() {
        return issue_tasks;
    }

    public void setIssue_tasks(String issue_tasks) {
        this.issue_tasks = issue_tasks;
    }

    public void setPower_l1(double power_l1) {
        this.power_l1 = power_l1;
    }

    public void setPower_l2(double power_l2) {
        this.power_l2 = power_l2;
    }

    public void setPower_l3(double power_l3) {
        this.power_l3 = power_l3;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public void setPower_s(double power_s) {
        this.power_s = power_s;
    }

    public double getPoints() {
        return points;
    }

    public double getPower_l3() {
        return power_l3;
    }

    public double getPower_s() {
        return power_s;
    }

    public double getPower_l2() {
        return power_l2;
    }

    public double getPower_l1() {
        return power_l1;
    }

    public double getComplete_rate() {
        return complete_rate;
    }

    public void setComplete_rate(double complete_rate) {
        this.complete_rate = complete_rate;
    }

    @Override
    public String toString(){
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", involved_tasks='" + involved_tasks + '\'' +
                ", finished_tasks='" + finished_tasks + '\'' +
                ", progress_tasks='" + progress_tasks + '\'' +
                ", issue_tasks='" + issue_tasks + '\'' +
                ", power_l1=" + power_l1 +
                ", power_l2=" + power_l2 +
                ", power_l3=" + power_l3 +
                ", power_s=" + power_s +
                ", points=" + points +
                ", complete_rate=" + complete_rate +
                '}';
    }
}
