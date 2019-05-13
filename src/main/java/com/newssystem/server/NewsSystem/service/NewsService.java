package com.newssystem.server.NewsSystem.service;

import com.newssystem.server.NewsSystem.domain.News;
import com.newssystem.server.NewsSystem.repository.NewsRepository;
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

    private List<News> convertToDTOs(List<News> models){
        return models.stream().map(this::convertToDTO).collect(toList());
    }

    private News convertToDTO(News model){
        News dto = new News();
        dto.setId(model.getId());
        dto.setDate(model.getDate());
        dto.setText(model.getText());
        dto.setTitle(model.getTitle());
        dto.setAuthor(model.getAuthor());
        return dto;
    }

    @Override
    public List<News> getObj() {
        List<News> newsList = newsRepository.findAll();
        return convertToDTOs(newsList);
    }

    @Override
    public News create(News object) {
        return newsRepository.save(object);
    }

    @Override
    public News findById(String id) {
        return null;
    }

    @Override
    public News update(News object) {
        return null;
    }
}
