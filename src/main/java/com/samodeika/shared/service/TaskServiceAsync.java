package com.samodeika.shared.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.samodeika.shared.model.TaskModel;

import java.util.List;

public interface TaskServiceAsync {

    void getTasks(AsyncCallback<List<TaskModel>> async);
}
