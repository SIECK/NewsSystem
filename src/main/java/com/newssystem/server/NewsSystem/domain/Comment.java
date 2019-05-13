package com.newssystem.server.NewsSystem.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document
public class Comment {

    @Id
    public String id;
    @NotNull(message="Pole nie moze byc puste")
    public String newsId;
    @NotNull(message="Pole nie moze byc puste")
    @Size(min=5,max=2000, message="Komentarz musi miec 5-2000 znakow")
    public String comment;
    @NotNull(message="Pole nie moze byc puste")
    @Size(min=2,max=20, message="Autor musi miec 2-20 znakow")
    public String author;
    @NotNull(message="Pole nie moze byc puste")
    public String date;

    public Comment(){};

    public Comment(String newsId, String comment, String author, String date) {
        this.newsId = newsId;
        this.comment = comment;
        this.author = author;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
