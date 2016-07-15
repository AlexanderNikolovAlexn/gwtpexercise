package com.samodeika.server.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.samodeika.shared.model.TaskModel;
import com.samodeika.shared.service.TaskService;

import java.util.ArrayList;
import java.util.List;

public class TaskServiceImpl extends RemoteServiceServlet implements TaskService {

    @Override
    public List<TaskModel> getTasks() {
        List<TaskModel> tasks = new ArrayList<>();
        tasks.add(new TaskModel("task 1"));
        tasks.add(new TaskModel("task 2"));
        tasks.add(new TaskModel("task 3"));
        return tasks;
    }
}
