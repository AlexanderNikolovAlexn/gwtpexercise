package com.samodeika.shared.model;

import java.io.Serializable;

public class TaskModel implements Serializable{

    private String message;

    public TaskModel() {
    }

    public TaskModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
