package com.newssystem.NewsSystem.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document
public class News {

    @Id
    private String id;

    @NotNull(message = "Pole nie moze byc puste")
    @Size(min = 5, max = 70)
    private String title;

    @NotNull(message = "Pole nie moze byc puste")
    @Size(min = 5)
    private String text;

    @NotNull(message = "Pole nie moze byc puste")
    private String data;

    @NotNull(message = "Pole nie moze byc puste")
    @Size(min = 1)
    private String author;

    public News() {}

    public News(String title, String text, String data, String author) {
        this.title = title;
        this.text = text;
        this.data = data;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

}
