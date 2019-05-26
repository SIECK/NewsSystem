package com.newssystem.NewsSystem;

import com.newssystem.NewsSystem.domain.Comment;
import com.newssystem.NewsSystem.domain.News;
import com.newssystem.NewsSystem.service.CommentService;
import com.newssystem.NewsSystem.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@Configuration
public class NewsSystemApplication implements CommandLineRunner {

    @Autowired
    public NewsService newsService;

    @Autowired
    public CommentService commentService;

    public static void main(String[] args) {
        SpringApplication.run(NewsSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        News news = new News("Tytul", "Tresc", "01.01.2001", "Autor");
//        newsService.create(news);
//
//        Comment comment = new Comment("1", "Komentarz", "Autor", "02.01.2001");
//        commentService.create(comment);
    }
}
