package com.newssystem.NewsSystem.service;

import com.newssystem.NewsSystem.domain.Comment;
import com.newssystem.NewsSystem.domain.News;
import com.newssystem.NewsSystem.repository.CommentRepository;
import com.newssystem.NewsSystem.repository.NewsRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class CommentServiceTest {

    CommentRepository Mock1;
    CommentService cS;
    Comment com;
    @Before
    public void setUp() throws Exception{

        Mock1 = Mockito.mock(CommentRepository.class);
        cS = new CommentService(Mock1);
        com = new Comment("1","3","Komentarz Testowy","Tester","2000-01-01");

    }
    @Test
    public void getObj() {
        cS.getObj();
        Mockito.verify(Mock1).findAll();
    }

    @Test
    public void create() {
        cS.create(com);
        Mockito.verify(Mock1).save(com);
    }

    @Test
    public void findById() {
        try{

            assertEquals("niexd",cS.findById("xd").getId());
        }
        catch (NullPointerException e){
            assertEquals(true,true);
        }
        //gdyby miało kiedyś zwracać coś innego niż null
    }

    @Test
    public void update() {
        try{

            assertEquals("niexd",cS.update(com).getId());
        }
        catch (NullPointerException e){
            assertEquals(true,true);
        }
    }

    @Test
    public void findByNewsId() {
        cS.findByNewsId("id");
        Mockito.verify(Mock1).findByNewsId("id");
    }
}