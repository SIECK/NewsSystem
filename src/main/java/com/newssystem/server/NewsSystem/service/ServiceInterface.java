package com.newssystem.server.NewsSystem.service;

import java.util.List;

public interface ServiceInterface<T> {

    List<T> getObj();
    T create(T object);
    T findById(String id);
    T update(T object);

}
