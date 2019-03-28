package com.newssystem.NewsSystem.rest;

import com.newssystem.NewsSystem.domain.Comment;
import com.newssystem.NewsSystem.domain.News;
import com.newssystem.NewsSystem.service.CommentService;
import com.newssystem.NewsSystem.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
    public @ResponseBody Map<String, Object> create(@RequestBody News newsEntity){

        Map<String, Object> response = new LinkedHashMap<>();
        newsService.create(newsEntity);
        response.put("message", "News created");
        response.put("news", newsService.create(newsEntity));

        return response;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveComment")
    public @ResponseBody
    Comment create(@RequestBody Comment commentEntity){
        return commentService.create(commentEntity);
    }

}
