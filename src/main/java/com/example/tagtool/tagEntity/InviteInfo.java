package com.example.tagtool.tagEntity;

import javax.persistence.*;

@Entity
@Table(name = "tb_invite_info")
public class InviteInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String invitee;
    private String inviter;
    private int task_id;
    private int task_type;
    private int is_join;
    private double power;

    public void setPower(double power) {
        this.power = power;
    }

    public double getPower() {
        return power;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTask_type(int task_type) {
        this.task_type = task_type;
    }

    public int getTask_type() {
        return task_type;
    }

    public int getIs_join() {
        return is_join;
    }

    public String getInvitee() {
        return invitee;
    }

    public String getInviter() {
        return inviter;
    }

    public void setInvitee(String invitee) {
        this.invitee = invitee;
    }

    public void setInviter(String inviter) {
        this.inviter = inviter;
    }

    public void setIs_join(int is_join) {
        this.is_join = is_join;
    }

    @Override
    public String toString(){
        return "InferResult{" +
                "id=" + id +
                ", invitee='" + invitee + '\'' +
                ", inviter='" + inviter + '\'' +
                ", task_id=" + task_id +
                ", task_type=" + task_type +
                ", is_join='" + is_join +
                ", power=" + power +
                '}';
    }
}
