package com.newssystem.NewsSystem.rest;

import com.newssystem.NewsSystem.domain.Comment;
import com.newssystem.NewsSystem.domain.News;
import com.newssystem.NewsSystem.service.CommentService;
import com.newssystem.NewsSystem.service.NewsApiService;
import com.newssystem.NewsSystem.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/news")
public class AppRESTController {

    private final CommentService commentService;
    private final NewsService newsService;
    private final NewsApiService newsApiService;

    private final Map<String, Object> response = new LinkedHashMap<>();

    @Autowired
    public AppRESTController(CommentService commentService, NewsService newsService, NewsApiService newsApiService) {
        this.commentService = commentService;
        this.newsService = newsService;
        this.newsApiService = newsApiService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getNews")
    public @ResponseBody
    List<News> findAllNews() {
        return newsService.getObj();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getApiNews")
    public @ResponseBody
    List<News> findAllNewsFromApi() {
        return newsApiService.getObj();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getComments")
    public @ResponseBody
    List<Comment> findAllComments() {
        return commentService.getObj();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveNews")
    public @ResponseBody
    Map<String, Object> create(@Valid @RequestBody News newsEntity, BindingResult bindingResult) {
        if (checkError(bindingResult)) {
            newsService.create(newsEntity);
            response.put("message", "News created successfully");
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveComment")
    public @ResponseBody
    Map<String, Object> create(@Valid @RequestBody Comment commentEntity, BindingResult bindingResult) {
        if (checkError(bindingResult)) {
            commentService.create(commentEntity);
            response.put("message", "Comment created successfully");
        }
        return response;
    }

    public boolean checkError(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            response.put("message", "Error");
            for (FieldError error : errors) {
                response.put(error.getField(), error.getDefaultMessage());
            }
            return false;
        } else {
            return true;
        }
    }
}
