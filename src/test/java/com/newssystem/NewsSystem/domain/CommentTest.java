package com.newssystem.NewsSystem.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommentTest {
    private Comment comment;

    @Before
    public void setUp() throws Exception{
        comment = new Comment("1","3","Komentarz Testowy","Tester","2000-01-01");
    }

    @After
    public void after() throws Exception{
        //po kazdym tescie
    }

    @Test
    public void getId() {
        assertEquals("1",comment.getId());
    }

    @Test
    public void setId() {
        comment.setId("2");
        assertEquals("2",comment.getId());
    }

    @Test
    public void getNewsId() {
        assertEquals("3", comment.getNewsId());
    }

    @Test
    public void setNewsId() {
        comment.setNewsId("4");
        assertEquals("4", comment.getNewsId());
    }

    @Test
    public void getComment() {
        assertEquals("Komentarz Testowy", comment.getComment());
    }

    @Test
    public void setComment() {
        comment.setComment("Komentarz po zmianie");
        assertEquals("Komentarz po zmianie", comment.getComment());
    }

    @Test
    public void getAuthor() {
        assertEquals("Tester", comment.getAuthor());
    }

    @Test
    public void setAuthor() {
        comment.setAuthor("Tester2");
        assertEquals("Tester2", comment.getAuthor());
    }

    @Test
    public void getData() {
        assertEquals("2000-01-01", comment.getData());
    }

    @Test
    public void setData() {
        comment.setData("2002-01-03");
        assertEquals("2002-01-03", comment.getData());
    }

    @Test
    public void emptyConstructorTest(){
        comment = new Comment();
        assertEquals("", comment.getData());
        assertEquals("", comment.getAuthor());
        assertEquals("", comment.getComment());
        assertEquals("", comment.getNewsId());
        assertEquals("",comment.getId());
    }
}