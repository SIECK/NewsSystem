package com.newssystem.server.NewsSystem.rest;

import com.newssystem.server.NewsSystem.domain.Comment;
import com.newssystem.server.NewsSystem.domain.News;
import com.newssystem.server.NewsSystem.repository.NewsRepository;
import com.newssystem.server.NewsSystem.service.CommentService;
import com.newssystem.server.NewsSystem.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/news")
public class AppRESTController {

    private final CommentService commentService;
    private final NewsService newsService;

    @Autowired
    public AppRESTController(CommentService commentService, NewsService newsService) {
        this.commentService = commentService;
        this.newsService = newsService;
    }

    @RequestMapping(method=RequestMethod.GET, value = "/getComments")
    public @ResponseBody
    List<Comment> findAllComments(){
        return commentService.getObj();
    }

    @RequestMapping(method=RequestMethod.GET, value = "/getNews")
    public @ResponseBody
    List<News> findAll(){
        return newsService.getObj();
    }

    @RequestMapping(method=RequestMethod.POST, value="/saveNews")
    public @ResponseBody Map<String, Object> create(@Valid @RequestBody News newsEntity, BindingResult bindingResult){
        Map<String, Object> response = new LinkedHashMap<>();
        if(bindingResult.hasErrors()){
            List<FieldError> errors = bindingResult.getFieldErrors();
            response.put("message", "Error!");
            for(FieldError error : errors){
                response.put(error.getField(), error.getDefaultMessage());
            }
        }
        else {
            response.put("message", "News created successfully");
            response.put("news", newsService.create(newsEntity));
        }
        return response;
    }

    @RequestMapping(method=RequestMethod.POST, value="/saveComment")
    public @ResponseBody
    Map<String,Object> create(@Valid @RequestBody Comment commentEntity, BindingResult bindingResult){
        Map<String, Object> response = new LinkedHashMap<>();
        if(bindingResult.hasErrors()){
            List<FieldError> errors = bindingResult.getFieldErrors();
            response.put("message", "Error [comment]!");
            for(FieldError error : errors){
                response.put(error.getField(), error.getDefaultMessage());
            }
        }
        else {
            response.put("message", "Comment created successfully");
            response.put("comment", commentService.create(commentEntity));
        }
        return response;
    }

}
