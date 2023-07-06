package com.example.CalLunch.app.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.CalLunch.domain.model.Shop;
import com.example.CalLunch.domain.service.shop.ShopService;

@Controller
public class ShopController {

	@Autowired
	ShopService shopService;
	Shop shop = new Shop();
	
	@GetMapping("detail")
	public String Detail(Model model) {

		model.addAttribute("detail", shopService.findShop());
		return "shop/detail";
	}
	
	@GetMapping("shopEdit")
	public String ShopEdit(Model model) {
		
		//model.addAttribute("shopEdit", shopService.findShop());
		return "serch/edit";
	}
}
