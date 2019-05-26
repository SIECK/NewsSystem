package com.newssystem.NewsSystem.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
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

    public Comment() {
    }

    public Comment(String newsId, String comment, String author, String data) {
        NewsId = newsId;
        this.comment = comment;
        this.author = author;
        this.data = data;
    }
}
