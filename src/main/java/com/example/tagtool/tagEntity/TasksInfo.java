package com.example.tagtool.tagEntity;

import javax.persistence.*;

@Entity
@Table(name = "tb_tasks_info")
public class TasksInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String leader_account;
    private String leader_name;
//    private String tfile_path;
    private String tfile_name;
    private String task_name;
    private String task_type;
    private String task_reward;
    private String task_intro;
    private String task_label;
    private int member_num;
    private String member_ability;
    private int member_finish;
    private String member_account;
    private String sds_name;
    private String sds_path;
    private int is_finished;
    private String deadline;

    public int getId() {
        return id;
    }

    public int getMember_num() {
        return member_num;
    }

    public String getMember_ability() {
        return member_ability;
    }

    public String getMember_account() {
        return member_account;
    }

    public String getSds_name() {
        return sds_name;
    }

    public String getTask_label() {
        return task_label;
    }

    public String getLeader_account() {
        return leader_account;
    }

    public void setLeader_account(String leader_account) {
        this.leader_account = leader_account;
    }

    public String getTask_name() {
        return task_name;
    }

    public int getIs_finished() {
        return is_finished;
    }

    public String getTask_reward() {
        return task_reward;
    }

    public String getSds_path() {
        return sds_path;
    }

    public String getTask_type() {
        return task_type;
    }

//    public String getTfile_path() {
//        return tfile_path;
//    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMember_ability(String member_ability) {
        this.member_ability = member_ability;
    }

    public void setMember_account(String member_account) {
        this.member_account = member_account;
    }

    public void setMember_num(int member_num) {
        this.member_num = member_num;
    }

    public void setIs_finished(int is_finished) {
        this.is_finished = is_finished;
    }

    public void setSds_name(String sds_name) {
        this.sds_name = sds_name;
    }

    public void setTask_label(String task_label) {
        this.task_label = task_label;
    }

    public void setSds_path(String sds_path) {
        this.sds_path = sds_path;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public void setTask_reward(String task_reward) {
        this.task_reward = task_reward;
    }

    public void setTask_type(String task_type) {
        this.task_type = task_type;
    }

//    public void setTfile_path(String tfile_path) {
//        this.tfile_path = tfile_path;
//    }

    public String getTask_intro() {
        return task_intro;
    }

    public void setTask_intro(String task_intro) {
        this.task_intro = task_intro;
    }

    public String getLeader_name() {
        return leader_name;
    }

    public void setLeader_name(String leader_name) {
        this.leader_name = leader_name;
    }

    public int getMember_finish() {
        return member_finish;
    }

    public void setMember_finish(int member_finish) {
        this.member_finish = member_finish;
    }

    public void setTfile_name(String tfile_name) {
        this.tfile_name = tfile_name;
    }

    public String getTfile_name() {
        return tfile_name;
    }

    @Override
    public String toString() {
        return "TasksInfo{" +
                "id=" + id +
                ", leader_account='" + leader_account + '\'' +
                ", leader_name='" + leader_name + '\'' +
//                ", tfile_path='" + tfile_path + '\'' +
                ", tfile_name='" + tfile_name + '\'' +
                ", task_name='" + task_name + '\'' +
                ", task_type='" + task_type + '\'' +
                ", task_reward='" + task_reward + '\'' +
                ", task_intro='" + task_intro + '\'' +
                ", task_label='" + task_label + '\'' +
                ", member_num=" + member_num +
                ", member_ability='" + member_ability + '\'' +
                ", member_account='" + member_account + '\'' +
                ", member_finish='" + member_finish +
                ", sds_name='" + sds_name + '\'' +
                ", sds_path='" + sds_path + '\'' +
                ", is_finished=" + is_finished +
                ", deadline='" + deadline + '\'' +
                '}';
    }
}
