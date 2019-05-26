package com.newssystem.NewsSystem.service;

import java.util.List;

public interface ServiceInterface<T> {
    List<T> getObj();

    T create(T obj);

    T findById(String id);

    T update(T obj);
}
