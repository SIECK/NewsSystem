package com.newssystem.server.NewsSystem.service;

import com.newssystem.server.NewsSystem.domain.Comment;

import java.util.List;

public interface CustomRepositoryComment {

    List<Comment> findByNewsId(String id);

}
