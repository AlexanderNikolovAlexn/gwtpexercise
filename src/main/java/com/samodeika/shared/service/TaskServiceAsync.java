package com.samodeika.shared.service;

import com.samodeika.shared.model.TaskModel;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Path("/api/tasks")
public interface TaskServiceAsync extends RestService {

    @GET
    void getTasks(MethodCallback<Map<Date, List<TaskModel>>> callback);
    @GET
    @Path("/calendar")
    void getTasks(@QueryParam("calendarDate") String date, MethodCallback<List<TaskModel>> callback);
}
