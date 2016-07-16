package com.samodeika.server.service;

import com.samodeika.shared.model.Hello;
import com.samodeika.shared.service.HelloService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/hellos")
public class HelloServiceImpl implements HelloService {

    Map<String, Hello> database;
    public HelloServiceImpl() {
        database = new HashMap<String, Hello>();
        Hello hello1 = new Hello("1", "ronan");
        Hello hello2 = new Hello("2", "john");
        Hello hello3 = new Hello("3", "pesho");

        database.put(hello1.getId(), hello1);
        database.put(hello2.getId(), hello2);
        database.put(hello3.getId(), hello3);
    }

    @GET
    @Produces("application/json")
    @Override
    public List<Hello> getHellos() {
        List<Hello> list = new ArrayList<>();
        list.addAll(database.values());
        return list;
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    @Override
    public List<Hello> getHellos(String id) {
        List<Hello> list = new ArrayList<>();
        list.add(database.get(id));
        return list;
    }
}
