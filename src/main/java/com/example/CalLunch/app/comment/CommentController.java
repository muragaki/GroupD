package com.example.CalLunch.app.comment;

//import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	    @PostMapping("/post")
	    public String postComment(
	            @RequestParam("title") String title,
	            @RequestParam("evaluation") String evaluation,
	            @RequestParam("comment") String comment) {
	        
	        // ここで受け取ったデータを処理するロジックを実装します
	        // 例えば、データベースに保存したり、他のサービスに送信したりできます
	        
	        // データの処理が完了した後、リダイレクトするなどの適切なレスポンスを返します
	        return "redirect:/comment/thankyou";
	    }

//	@PostMapping("/comment")
//    public String comment(@ModelAttribute("commentForm") CommentForm commentForm,
//    		@ModelAttribute("cookingForm") CookingForm cookingForm,
//    		Model model) {
//	 // Commentオブジェクトの作成と保存
//    Comment comment = new Comment();
//   /* comment.setText(commentForm.getText()); 
//    comment.setTitle(commentForm.getTitle());
//    comment.setEvaluation(commentForm.getEvaluation());
//    comment.setTime(LocalDateTime.now());
//    comment.setImage(cookingForm.getImage()); */
//    commentService.save(comment);
//    model.addAttribute("commentForm", commentForm);
//
//        return "lunchtop/top";
//        
//
//	    }
	}