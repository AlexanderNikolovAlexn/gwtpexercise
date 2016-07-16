package com.samodeika.client.application;

import com.google.gwt.core.client.GWT;
import com.google.inject.Inject;
import com.samodeika.shared.service.HelloServiceAsync;
import com.samodeika.shared.service.TaskService;
import com.samodeika.shared.service.TaskServiceAsync;
import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Resource;
import org.fusesource.restygwt.client.RestServiceProxy;

public class ServiceFactory {

    @Inject
    TaskServiceAsync taskService;

    @Inject
    HelloServiceAsync helloService;

    public TaskServiceAsync getTaskService() {
        if(taskService == null) {
            taskService = GWT.create(TaskService.class);
        }
        return taskService;
    }

    public HelloServiceAsync getHelloService() {
        if(helloService == null) {
            helloService = GWT.create(HelloServiceAsync.class);
        }
        return helloService;
    }
}
