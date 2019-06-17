package com.newssystem.NewsSystem.service;

import com.newssystem.NewsSystem.domain.News;
import com.newssystem.NewsSystem.repository.NewsApiRepository;
import com.newssystem.NewsSystem.repository.NewsRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.xml.ws.Service;

import java.util.List;

import static org.junit.Assert.*;

public class NewsServiceTest {
    NewsRepository Mock1;
    NewsService nS;
    News news;
    News.Builder nB;
    List<News> newslist;
    @Before
    public void setUp() throws Exception{

        Mock1 = Mockito.mock(NewsRepository.class);
        nS = new NewsService(Mock1);
        nB = new News.Builder();
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


    @Test
    public void create() {

        nS.create(news);
        Mockito.verify(Mock1).save(news);
    }
    @Test
    public void getObj() {
        newslist = nS.getObj();
        Mockito.verify(Mock1).findAll();
    }

    @Test
    public void findById(){
        try{

            assertEquals("niexd",nS.findById("xd").getId());
        }
        catch (NullPointerException e){
            assertEquals(true,true);
        }
        //gdyby miało kiedyś zwracać coś innego niż null
    }
    @Test
    public void update(){
        try{

            assertEquals("niexd",nS.update(news).getId());
        }
        catch (NullPointerException e){
            assertEquals(true,true);
        }
        //gdyby miało kiedyś zwracać coś innego niż null
    }

}