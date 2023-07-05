package com.example.CalLunch.domain.service.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CalLunch.domain.model.Comment;
import com.example.CalLunch.domain.repository.comment.CommentRepository;

@Service
public class CommentService {
	@Autowired
	CommentRepository commentRepository;
	
	public void save(Comment comment) {
		commentRepository.save(comment);
	}
	public List<Comment> findComment() {
		return commentRepository.findAllByOrderByShopId();
	}


}
