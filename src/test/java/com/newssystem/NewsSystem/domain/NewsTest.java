package com.newssystem.NewsSystem.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NewsTest {

    News.Builder newsBuilder;
    News news;

    @Before
    public void setUp() throws Exception{
        newsBuilder = new News.Builder();
        newsBuilder
                .id("1")
                .data("2000-03-03")
                .text("Random Text")
                .title("Random Title")
                .author("Tester")
                .lang("PL")
                .source("Brain");
        news = newsBuilder.build();
    }
    @Test
    public void getId() {
        assertEquals("1",news.getId());
    }

    @Test
    public void getTitle() {
        assertEquals("Random Title",news.getTitle());
    }

    @Test
    public void setTitle() {
        news.setTitle("New Title");
        assertEquals("New Title",news.getTitle());
    }

    @Test
    public void getText() {
        assertEquals("Random Text",news.getText());
    }

    @Test
    public void setText() {
        news.setText("New Text");
        assertEquals("New Text",news.getText());
    }

    @Test
    public void getData() {
        assertEquals("2000-03-03",news.getData());
    }

    @Test
    public void setData() {
        news.setData("2077-03-03");
        assertEquals("2077-03-03",news.getData());
    }

    @Test
    public void getAuthor() {
        assertEquals("Tester",news.getAuthor());
    }

    @Test
    public void setAuthor() {
        news.setAuthor("New Tester");
        assertEquals("New Tester",news.getAuthor());
    }

    @Test
    public void getLang() {
        assertEquals("PL",news.getLang());
    }

    @Test
    public void setLang() {
        news.setLang("ENG");
        assertEquals("ENG",news.getLang());
    }

    @Test
    public void getSource() {
        assertEquals("Brain",news.getSource());
    }

    @Test
    public void setSource() {
        news.setSource("Wiki");
        assertEquals("Wiki",news.getSource());
    }

    @Test
    public void notGivenSource(){
        newsBuilder = new News.Builder();
        newsBuilder
                .id("1")
                .data("2000-03-03")
                .text("Random Text")
                .title("Random Title")
                .author("Tester")
                .lang("PL");
        news = newsBuilder.build();
        assertEquals("not given",news.getSource());
    }

    @Test
    public void notGivenLang(){
        newsBuilder = new News.Builder();
        newsBuilder
                .id("1")
                .data("2000-03-03")
                .text("Random Text")
                .title("Random Title")
                .author("Tester");
        news = newsBuilder.build();
        assertEquals("not given",news.getLang());
    }
}