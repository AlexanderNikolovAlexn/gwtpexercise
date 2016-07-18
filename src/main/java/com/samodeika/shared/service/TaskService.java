package com.samodeika.shared.service;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.samodeika.shared.model.TaskModel;

import java.util.List;

@RemoteServiceRelativePath("tasks")
public interface TaskService {

    List<TaskModel> getTasks();

}
