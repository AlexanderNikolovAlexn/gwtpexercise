package com.samodeika.server.service;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.samodeika.shared.model.TaskModel;
import com.samodeika.shared.service.TaskService;
import com.samodeika.shared.utils.DateUtils;

import javax.ws.rs.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Path("/tasks")
public class TaskServiceImpl implements TaskService {

    private Map<Date, List<TaskModel>> result;
    private DateFormat format;

    public TaskServiceImpl() {
        result = new HashMap<>();
        format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = new Date();

        List<TaskModel> tasks1 = new ArrayList<>();
        tasks1.add(new TaskModel("task 1"));
        tasks1.add(new TaskModel("task 2"));
        tasks1.add(new TaskModel("task 3"));
        try {
            date = format.parse("18/07/2016");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        result.put(date, tasks1);

        List<TaskModel> tasks2 = new ArrayList<>();
        tasks2.add(new TaskModel("Alex 1"));
        tasks2.add(new TaskModel("Pesho 2"));
        tasks2.add(new TaskModel("Gosho 3"));
        try {
            date = format.parse("16/06/2016");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        result.put(date, tasks2);
    }

    private Date getDate(String s) {
        Date date = new Date();
        try {
            date = format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @GET
    @Produces("application/json")
    @Override
    public Map<Date, List<TaskModel>> getTasks() {

        return result;
    }

    @GET
    @Produces("application/json")
    @Path("/calendar")
    @Override
    public List<TaskModel> getTasks(@QueryParam("calendarDate") String date) {
        List<TaskModel> resultList = new ArrayList<>();
        resultList = result.get(getDate(date));
        return resultList;
    }
}
