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

    private String lang;

    private String source;

    public static final class Builder {
        private final static String NOT_GIVEN = "not given";
        private String id;
        private String title;
        private String text;
        private String data;
        private String author;
        private String lang;
        private String source;


        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder data(String data) {
            this.data = data;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder lang(String lang) {
            this.lang = lang;
            return this;
        }

        public Builder source(String source) {
            this.source = source;
            return this;
        }

        public News build() {
            if (this.lang == null || this.lang.trim().isEmpty()) {
                this.lang = NOT_GIVEN;
            }
            if (source == null || this.source.trim().isEmpty()) {
                this.source = NOT_GIVEN;
            }
            News news = new News();
            news.id = this.id;
            news.title = this.title;
            news.author = this.author;
            news.data = this.data;
            news.text = this.text;
            news.source = this.source;
            news.lang = this.lang;
            return news;
        }
    }

}
