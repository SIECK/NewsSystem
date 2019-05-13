package com.newssystem.server.NewsSystem.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document
public class News {

    @Id
    public String id;
    @NotNull(message="Pole nie moze byc puste!")
    @Size(min=5, max=70, message="Tytul musi miec 5-70 znakow")
    public String title;
    @NotNull
    @Size(min=5, message="Tekst musi miec wiecej niz 5 znakow")
    public String text;

    public String date;
    @NotNull(message="Pole nie moze byc puste")
    @Size(min=1, message="Autor musi miec wiecej niz 1 znak")
    public String author;

    public News(){};

    public News(String title, String text, String date, String author) {
        this.title = title;
        this.text = text;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor (String author){
        this.author = author;
    }
}
