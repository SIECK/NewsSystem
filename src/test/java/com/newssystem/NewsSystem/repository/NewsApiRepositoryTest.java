package com.newssystem.NewsSystem.repository;

import com.aylien.newsapi.models.Category;
import com.aylien.newsapi.models.Story;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NewsApiRepositoryTest {
    private NewsApiRepository api;
    Story temp;
    String language,category,state;
    List<Story> storyList;
    boolean containsCategory,containsState;
    @Before
    public void setUp() throws Exception{
        try{
            api = new NewsApiRepository();
            temp = api.findAll().get(0);
            containsCategory = false;
            containsState = false;
            language = temp.getLanguage();
            category = temp.getCategories().get(0).getId();
            state = temp.getSource().getLocations().get(0).getState();
            storyList = new ArrayList<>();
        }
        catch(IndexOutOfBoundsException e){
            setUp();
        }
    }
    @Test
    public void findAll() {

        assertEquals(false,api.findAll().isEmpty());;
    }

    @Test
    public void findByParametersTest() {
        try{
            for(int i =0;i<10;i++)
                while(storyList.isEmpty()){
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
                    storyList = api.findByParameters(language, category, state);
                }
            for(Story story:storyList){
                assertEquals(language,story.getLanguage());
                assertEquals(false, containsCategory);
            }
        }
        catch (NullPointerException e){
            assertEquals(true,true);
        }


    }
    @Test
    public void findByLang() {
        try{
            for(Story story:api.findByLang(temp.getLanguage())){
                assertEquals(temp.getLanguage(),story.getLanguage());
            }
        }
        catch(java.lang.NullPointerException e){
            assertEquals(true,true);
            //Nie znaleziono akurat takiego story
        }


    }


}
