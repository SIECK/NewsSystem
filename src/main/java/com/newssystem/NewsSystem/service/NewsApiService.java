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

    public List<News> findByLang(String lang) {
        List<Story> newsList = newsRepository.findByLang(lang);
        return convertToDTOs(newsList);
    }

    public List<News> findByParameters(String lang, String categoryId, String sourceLocationsState) {
        List<Story> newsList = newsRepository.findByParameters(lang, categoryId, sourceLocationsState);
        return convertToDTOs(newsList);
    }

    private List<News> convertToDTOs(List<Story> models) {
        return models.stream().map(this::convertToDTO).collect(toList());
    }

    private News convertToDTO(Story model) {
        News.Builder dto = new News.Builder();
        dto
                .id(model.getId().toString())
                .data(model.getPublishedAt().toString())
                .text(model.getBody())
                .title(model.getTitle())
                .author(model.getAuthor().getName())
                .lang(model.getLanguage())
                .source(model.getSource().getName());
        return dto.build();
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
