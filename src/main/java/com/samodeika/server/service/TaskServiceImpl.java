package com.samodeika.server.service;

import com.samodeika.shared.model.TaskModel;
import com.samodeika.shared.service.TaskService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

@Path("/tasks")
public class TaskServiceImpl implements TaskService {

    @GET
    @Produces("application/json")
    @Override
    public List<TaskModel> getTasks() {
        List<TaskModel> tasks = new ArrayList<>();
        tasks.add(new TaskModel("task 1"));
        tasks.add(new TaskModel("task 2"));
        tasks.add(new TaskModel("task 3"));
        return tasks;
    }
}
