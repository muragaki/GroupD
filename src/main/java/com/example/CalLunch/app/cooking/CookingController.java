package com.example.CalLunch.app.cooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.CalLunch.domain.service.cooking.CookingService;

@Controller
public class CookingController {
	
	@Autowired
	CookingService cookingService;

	@GetMapping("cooking")
	String cooking(Model model) {
		
		model.addAttribute("cooking", cookingService.findCooking());
		return "cooking/cooking";
	}
}
