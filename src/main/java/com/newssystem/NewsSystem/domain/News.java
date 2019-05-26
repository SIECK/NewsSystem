package com.newssystem.NewsSystem.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Document
@NoArgsConstructor
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

    public News(String title, String text, String data, String author) {
        this.title = title;
        this.text = text;
        this.data = data;
        this.author = author;
    }

}
