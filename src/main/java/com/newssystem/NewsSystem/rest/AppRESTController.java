package com.newssystem.NewsSystem.rest;

import com.newssystem.NewsSystem.domain.Comment;
import com.newssystem.NewsSystem.domain.News;
import com.newssystem.NewsSystem.service.CommentService;
import com.newssystem.NewsSystem.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/news")
public class AppRESTController {
    private final CommentService commentService;
    private final NewsService newsService;

    @Autowired
    public AppRESTController(CommentService commentService, NewsService newsService) {
        this.commentService = commentService;
        this.newsService = newsService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getNews")
    public @ResponseBody
    List<News> findAllNews(){
        return newsService.getObj();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getComments")
    public @ResponseBody
    List<Comment> findAllComments() {return commentService.getObj(); }

    @RequestMapping(method = RequestMethod.POST, value = "/saveNews")
    public @ResponseBody
    News create(@RequestBody News newsEntity){
        return newsService.create(newsEntity);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveComment")
    public @ResponseBody
    Comment create(@RequestBody Comment commentEntity){
        return commentService.create(commentEntity);
    }

}
