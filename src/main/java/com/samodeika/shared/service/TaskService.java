package com.samodeika.shared.service;

import com.samodeika.shared.model.TaskModel;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TaskService {

    Map<Date, List<TaskModel>> getTasks();
    List<TaskModel> getTasks(String date);

}
