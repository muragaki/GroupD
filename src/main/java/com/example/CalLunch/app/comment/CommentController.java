package com.example.CalLunch.app.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.CalLunch.domain.service.comment.CommentService;

@Controller
public class CommentController {
	
	@Autowired
	CommentService commentservice;
	
	@GetMapping("comment")
	String comment(Model model) {
		model.addAttribute("comment",commentService.findComent());
		return "comment/comment";
	}

}
