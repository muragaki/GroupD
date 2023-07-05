package com.example.CalLunch.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.CalLunch.domain.repository.ShopService;

@Controller
public class ShopController {

	@Autowired
	ShopService shopService;
	
	@GetMapping("detail")
	public String detail(Model model) {

		model.addAttribute("detail", shopService.findShop());
		return "detail";
	}
}