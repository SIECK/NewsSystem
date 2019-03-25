package com.newssystem.NewsSystem.repository;

import com.newssystem.NewsSystem.domain.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
    List<Comment> findByNewsId(String id);
}
