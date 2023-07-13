package com.example.CalLunch.app.comment;

import java.util.ArrayList;

import com.example.CalLunch.domain.model.Comment;

import jakarta.validation.Valid;
import lombok.Data;

	@Data
	public class CommentForm {
		@Valid
		private ArrayList<Comment> commentList = new ArrayList<>();
		
		private String text;
		private String title;
		private Integer evaluation;
		

}
