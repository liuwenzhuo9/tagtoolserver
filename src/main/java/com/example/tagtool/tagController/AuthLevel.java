package com.example.tagtool.tagController;

public enum AuthLevel {
    LOGGED(0),
    ALL(Integer.MAX_VALUE);

    private int lever;

    AuthLevel(int lever){
        this.lever = lever;
    }

    public int getLever(){
        return lever;
    }
}
