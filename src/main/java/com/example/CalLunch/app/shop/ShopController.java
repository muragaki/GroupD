package com.example.CalLunch.app.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.CalLunch.domain.model.Shop;
import com.example.CalLunch.domain.service.shop.ShopService;

@Controller
public class ShopController {

	@Autowired
	ShopService shopService;
	Shop shop = new Shop();
	
	@GetMapping("detail")
	public String detail(Model model){

		model.addAttribute("detail", shopService.findShop());
		return "shop/detail";
	}
	
	@PostMapping("shopEdit")
		public String getShopDetails(@PathVariable Integer shopId, Model model) {
			Shop shop = shopService.getShopByShopId(shopId);
			String name = shop.getShopName();
			model.addAttribute("name", name);
		return "serch/edit";
	}
	
	@GetMapping("top")
	public String top(Model model) {
		model.addAttribute("top", shopService.findShop());
		return "lunchtop/top";
	}
	@PostMapping("register")
	public String register(Model model) {
		model.addAttribute("register", shopService.findShop());
		return "register/register";
	}
	
	@PostMapping("confirmation")
	public String confirmation(Model model) {
		return "";
	}
	
	@PostMapping("serch")
	public String sercher(Model model) {
		model.addAttribute("serch", shopService.findShop());
		return "serch/cooking";
	}
}
