package com.samodeika.client.application;

import com.google.gwt.core.client.GWT;
import com.google.inject.Inject;
import com.samodeika.shared.service.TaskServiceAsync;

public class ServiceFactory {

    @Inject
    TaskServiceAsync taskService;

    public TaskServiceAsync getTaskService() {
        if(taskService == null) {
            taskService = GWT.create(TaskServiceAsync.class);
        }
        return taskService;
    }

}
