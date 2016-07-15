package com.samodeika.shared.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.samodeika.shared.model.TaskModel;

import java.util.List;

@RemoteServiceRelativePath("tasks")
public interface TaskService extends RemoteService {

    List<TaskModel> getTasks();

}
