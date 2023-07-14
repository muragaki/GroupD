package com.example.CalLunch.app.comment;

//import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.CalLunch.app.cooking.CookingForm;
import com.example.CalLunch.domain.model.Comment;
import com.example.CalLunch.domain.service.comment.CommentService;

@Controller
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@GetMapping("comment")
	String comment(Model model) {
		model.addAttribute("comment", commentService.findComment());
		return "comment/comment";
	}

	@PostMapping("/comment")
    public String comment(@ModelAttribute("commentForm") CommentForm commentForm,
    		@ModelAttribute("cookingForm") CookingForm cookingForm,
    		Model model) {
	 // Commentオブジェクトの作成と保存
    Comment comment = new Comment();
   /* comment.setText(commentForm.getText()); 
    comment.setTitle(commentForm.getTitle());
    comment.setEvaluation(commentForm.getEvaluation());
    comment.setTime(LocalDateTime.now());
    comment.setImage(cookingForm.getImage()); */
    commentService.save(comment);
    model.addAttribute("commentForm", commentForm);

        return "lunchtop/top";
        
	    }
	}