package com.newssystem.NewsSystem.service;

import com.aylien.newsapi.models.Story;
import com.newssystem.NewsSystem.domain.News;
import com.newssystem.NewsSystem.repository.NewsApiRepository;
import com.newssystem.NewsSystem.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class NewsApiService implements ServiceInterface<News> {

    private NewsApiRepository newsRepository;

    @Autowired
    public NewsApiService(NewsApiRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<News> getObj() {
        List<Story> newsList = newsRepository.findAll();
        return convertToDTOs(newsList);
    }

    private List<News> convertToDTOs(List<Story> models) {
        return models.stream().map(this::convertToDTO).collect(toList());
    }

    private News convertToDTO(Story model) {
        News dto = new News();
        dto.setId(model.getId().toString());
        dto.setData(model.getPublishedAt().toString());
        dto.setText(model.getBody());
        dto.setTitle(model.getTitle());
        dto.setAuthor(model.getAuthor().getName());
        return dto;
    }

    @Override
    public News create(News obj) {
        return null;
    }

    @Override
    public News findById(String id) {
        return null;
    }

    @Override
    public News update(News obj) {
        return null;
    }
}
