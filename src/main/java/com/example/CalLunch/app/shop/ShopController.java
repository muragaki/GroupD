package com.example.CalLunch.app.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.CalLunch.domain.model.Cooking;
import com.example.CalLunch.domain.model.Shop;
import com.example.CalLunch.domain.service.cooking.CookingService;
import com.example.CalLunch.domain.service.shop.ShopService;

@Controller
public class ShopController {

	@Autowired
	ShopService shopService;
	Shop shop = new Shop();
	
	@Autowired
	CookingService cookingService; 
	
	@GetMapping("detail")
	public String Detail(Model model) {

		model.addAttribute("detail", shopService.findShop());
		return "shop/detail";
	}
	
	@PostMapping("shopEdit")
	public String shopEdit(Model model) {
		
		model.addAttribute("shopEdit", shopService.findShop());
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
	
	
	@PostMapping("serch")
	public String sercher(Model model) {
		model.addAttribute("serch", shopService.findShop());
		return "serch/cooking";
	}
	@PostMapping("confirmation")
	public String confirmation(Model model) {
		model.addAttribute("item", shopService.findShop());
		model.addAttribute("cook", cookingService.findCooking());
		//shopService.save(shop);
		//cookingService.save(cooking);
		return "register/preview";
	}
	@PostMapping("preview")
    public String preview(@ModelAttribute("shop") Shop shop, @ModelAttribute("cooking") Cooking cooking) {
        // shopListとcookingListのデータを使用して処理を行う
        // 例: データの表示、保存、操作など
		shopService.save(shop);
		cookingService.save(cooking);

        return "lunchtop/top"; // 表示するビューの名前を返す
    }
	@PostMapping("upload")
	public String upload(Model model) {
		model.addAttribute("upload", shopService.findShop());
		return "lunchtop/top";
	}
	@PostMapping("comment")
	public String comment(Model model) {
		model.addAttribute("comment", shopService.findShop());
		return "table/table";
	}
	@PostMapping("access")
	public String access(Model model) {
		model.addAttribute("comment", shopService.findShop());
		return "comment/comment";
	}
	@PostMapping("shopserch")
	public String shopserch(Model model) {
		return "shop/detail";
	}
}
