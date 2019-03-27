package com.newssystem.NewsSystem.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document
public class Comment {

    @Id
    private String id;

    @NotNull(message = "Pole nie moze byc puste")
    private String NewsId;

    @NotNull(message = "Pole nie moze byc puste")
    @Size(min = 5, max = 500)
    private String comment;

    @NotNull(message = "Pole nie moze byc puste")
    @Size(min = 1, max = 20)
    private String author;

    @NotNull(message = "Pole nie moze byc puste")
    private String data;

    public Comment () {}

    public Comment(String newsId, String comment, String author, String data) {
        NewsId = newsId;
        this.comment = comment;
        this.author = author;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNewsId() {
        return NewsId;
    }

    public void setNewsId(String newsId) {
        NewsId = newsId;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
