package com.samodeika.shared.service;

import com.samodeika.shared.model.Hello;

import java.util.List;

public interface HelloService {
    List<Hello> getHellos();
    List<Hello> getHellos(String id);
}
