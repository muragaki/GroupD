package com.example.CalLunch.app.comment;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import com.example.CalLunch.domain.model.Comment;

import jakarta.validation.Valid;
import lombok.Data;

	@Data
	public class CommentForm {
		@Valid
		private ArrayList<Comment> commentList = new ArrayList<>();
		
		private Integer shopId;
		private String cookingName;
		private String text;
		private String title;
		private Integer evaluation;
		private MultipartFile image;
		private LocalDateTime time;
		

}
