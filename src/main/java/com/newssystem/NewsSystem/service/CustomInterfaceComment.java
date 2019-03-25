package com.newssystem.NewsSystem.service;

import com.newssystem.NewsSystem.domain.Comment;

import java.util.List;

public interface CustomInterfaceComment {
    List<Comment> findByNewsId(String id);
}
