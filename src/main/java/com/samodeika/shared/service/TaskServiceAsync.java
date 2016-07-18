package com.samodeika.shared.service;

import com.samodeika.shared.model.TaskModel;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/api/tasks")
public interface TaskServiceAsync extends RestService {

    @GET
    void getTasks(MethodCallback<List<TaskModel>> callback);
}
