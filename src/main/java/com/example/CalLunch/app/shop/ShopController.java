package com.example.CalLunch.app.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.CalLunch.domain.service.shop.ShopService;

@Controller
public class ShopController {

	@Autowired
	ShopService shopService;
	
	@GetMapping("detail")
	public String detail(Model model) {

		model.addAttribute("detail", shopService.findShop());
		return "shop/detail";
	}
	@PostMapping("shopserch")
	public String serch(Model model) {
		return "";
	}
}
