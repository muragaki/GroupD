package com.example.CalLunch.domain.repository.comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CalLunch.domain.model.Comment;

public interface CommentRepository extends JpaRepository<Comment,Integer>{
	List<Comment> findAllByOrderByShopId();
	List<Comment> findByShopId(Integer shopId);
	

}
