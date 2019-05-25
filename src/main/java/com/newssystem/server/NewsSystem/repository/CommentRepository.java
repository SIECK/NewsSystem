package com.newssystem.server.NewsSystem.repository;

import com.newssystem.server.NewsSystem.domain.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

    public List<Comment> findByNewsId(String id);

}
