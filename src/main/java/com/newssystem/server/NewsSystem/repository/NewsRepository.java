package com.newssystem.server.NewsSystem.repository;


import com.newssystem.server.NewsSystem.domain.News;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends MongoRepository<News, String> {

}
