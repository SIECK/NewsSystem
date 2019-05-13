package com.newssystem.server.NewsSystem.service;

import com.newssystem.server.NewsSystem.domain.Comment;
import com.newssystem.server.NewsSystem.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CommentService implements ServiceInterface<Comment>, CustomRepositoryComment{

    public CommentRepository commentRepository;

    private List<Comment> convertToDTOs(List<Comment> models){
        return models.stream().map(this::convertToDTO).collect(toList());
    }

    private Comment convertToDTO(Comment model){
        Comment dto = new Comment();
        dto.setId(model.getId());
        dto.setNewsId(model.getNewsId());
        dto.setComment(model.getComment());
        dto.setAuthor(model.getAuthor());
        dto.setDate(model.getDate());
        return dto;
    }

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> getObj() {
        List<Comment> commentList = commentRepository.findAll();
        return convertToDTOs(commentList);
    }

    @Override
    public Comment create(Comment object) {
        return commentRepository.save(object);
    }

    @Override
    public Comment findById(String id) {
        return null;
    }

    @Override
    public Comment update(Comment object) {
        return null;
    }

    @Override
    public List<Comment> findByNewsId(String id) {
        List<Comment> commentList = commentRepository.findByNewsId(id);
        return convertToDTOs(commentList);
    }
}
