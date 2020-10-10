package com.example.tagtool.tagEntity;

import javax.persistence.*;

@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String account;
    private String involved_tasks;
    private String finished_tasks;
    private String progress_tasks;
    private String issue_tasks;
    private String sds_score;
    private String overall_score;
    private String power_l;
    private String power_s;
    private String label_scores;
    private String sequence_scores;

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

    public String getOverall_score() {
        return overall_score;
    }

    public String getProgress_tasks() {
        return progress_tasks;
    }

    public String getSds_score() {
        return sds_score;
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

    public void setOverall_score(String overall_score) {
        this.overall_score = overall_score;
    }

    public void setProgress_tasks(String progress_tasks) {
        this.progress_tasks = progress_tasks;
    }

    public void setSds_score(String sds_score) {
        this.sds_score = sds_score;
    }

    public String getIssue_tasks() {
        return issue_tasks;
    }

    public void setIssue_tasks(String issue_tasks) {
        this.issue_tasks = issue_tasks;
    }

    public String getLabel_scores() {
        return label_scores;
    }

    public void setLabel_scores(String label_scores) {
        this.label_scores = label_scores;
    }

    public String getSequence_scores() {
        return sequence_scores;
    }

    public void setSequence_scores(String sequence_scores) {
        this.sequence_scores = sequence_scores;
    }

    public String getPower_l() {
        return power_l;
    }

    public String getPower_s() {
        return power_s;
    }

    public void setPower_l(String power_l) {
        this.power_l = power_l;
    }

    public void setPower_s(String power_s) {
        this.power_s = power_s;
    }

    @Override
    public String toString(){
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", involved_tasks='" + involved_tasks + '\'' +
                ", finished_tasks='" + finished_tasks + '\'' +
                ", progress_tasks='" + progress_tasks + '\'' +
                ", issue_tasks='" + issue_tasks + '\'' +
                ", sds_score='" + sds_score + '\'' +
                ", overall_score='" + overall_score + '\'' +
                ", power_l='" + power_l + '\'' +
                ", label_scores='" + label_scores + '\'' +
                ", sequence_scores='" + sequence_scores + '\'' +
                '}';
    }
}
