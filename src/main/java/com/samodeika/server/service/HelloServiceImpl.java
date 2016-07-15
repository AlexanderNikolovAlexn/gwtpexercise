package com.samodeika.server.service;

import com.samodeika.shared.model.Hello;
import com.samodeika.shared.service.HelloService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloServiceImpl implements HelloService {

    Map<String, Hello> database;
    public HelloServiceImpl() {
        database = new HashMap<String, Hello>();
        Hello hello1 = new Hello("1", "ronan");
        Hello hello2 = new Hello("2", "john");

        database.put(hello1.getId(), hello1);
        database.put(hello2.getId(), hello2);
    }

    @Override
    public List<Hello> getHellos() {
        List<Hello> list = new ArrayList<>(database.values());
        return list;
    }

    @Override
    public List<Hello> getHellos(String id) {
        List<Hello> list = new ArrayList<>();
        list.add(database.get(id));
        return list;
    }
}
