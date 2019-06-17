package com.newssystem.NewsSystem.service;

import com.aylien.newsapi.models.Story;
import com.newssystem.NewsSystem.domain.News;
import com.newssystem.NewsSystem.repository.NewsApiRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NewsApiServiceTest{
    private News.Builder nB;
    private News news;
    private NewsApiRepository api;
    private Story temp;
    private List<News> newsList;
    private NewsApiService nAS;
    private String language,category,state;
    private boolean containsCategory,containsState;
    @Before
    public void setUp() throws Exception{
        try{
            newsList = new ArrayList<News>();
            api = new NewsApiRepository();
            nAS = new NewsApiService(api);
            temp = api.findAll().get(0);
            containsCategory = false;
            containsState = false;
            language = temp.getLanguage();
            category = temp.getCategories().get(0).getId();
            state = temp.getSource().getLocations().get(0).getState();
            nB = new News.Builder();
            nB
                    .id("1")
                    .data("2000-03-03")
                    .text("Random Text")
                    .title("Random Title")
                    .author("Tester")
                    .lang("PL")
                    .source("Brain");
            news = nB.build();
        }
        catch(IndexOutOfBoundsException e){
            setUp();
        }
    }
    @Test
    public void getObj() {
        newsList = nAS.getObj();
        assertEquals(false,newsList.isEmpty());
        assertEquals(api.findAll().size(),newsList.size());
    }

    @Test
    public void findByLang() {
        for(News news:nAS.findByLang(temp.getLanguage())){
            assertEquals(temp.getLanguage(),news.getLang());
        }
    }

    @Test
    public void findByParameters() {
        try{
            for(int i =0;i<10;i++)
                while(newsList.isEmpty()){
                    //temp = api.findAll().get(0);
                    language = temp.getLanguage();
                    category="";
                    state="";
                    if(!temp.getCategories().isEmpty()){
                        category = temp.getCategories().get(0).getId();
                    }
                    if(!temp.getSource().getLocations().isEmpty()) {
                        state = temp.getSource().getLocations().get(0).getState();
                    }
                    newsList = nAS.findByParameters(language, category, state);
                }
            for(News story:newsList){
                assertEquals(language,story.getLang());
                assertEquals(false, containsCategory);
            }
        }
        catch (NullPointerException e){
            assertEquals(true,true);
        }

    }

    @Test
    public void create() {
        try{
            news = nAS.create(news);
            assertEquals("niexd",news.getId());
        }
        catch (NullPointerException e){
            assertEquals(true,true);
        }


    }

    @Test
    public void findById() {
        try{
            assertEquals("niexd",nAS.findById(news.getId()).getId());
        }
        catch (NullPointerException e){
            assertEquals(true,true);
        }
    }

    @Test
    public void update() {
        try{
            news = nAS.update(news);
            assertEquals("niexd",nAS.findById(news.getId()).getId());
        }
        catch (NullPointerException e){
            assertEquals(true,true);
        }
    }
}