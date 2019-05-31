package com.newssystem.NewsSystem.service;

import com.newssystem.NewsSystem.domain.News;
import com.newssystem.NewsSystem.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class NewsService implements ServiceInterface<News> {

    private NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<News> getObj() {
        List<News> newsList = newsRepository.findAll();
        return convertToDTOs(newsList);
    }

    private List<News> convertToDTOs(List<News> models) {
        return models.stream().map(this::convertToDTO).collect(toList());
    }

    private News convertToDTO(News model) {
        News.Builder dto = new News.Builder();
        dto
                .id(model.getId())
                .data(model.getData())
                .text(model.getText())
                .title(model.getTitle())
                .author(model.getAuthor());
        return dto.build();
    }

    @Override
    public News create(News obj) {
        return newsRepository.save(obj);
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
