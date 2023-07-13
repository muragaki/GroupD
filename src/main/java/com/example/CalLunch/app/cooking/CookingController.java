package com.example.CalLunch.app.cooking;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.CalLunch.domain.model.Shop;
import com.example.CalLunch.domain.service.cooking.CookingService;
import com.example.CalLunch.domain.service.shop.ShopService;


@Controller
public class CookingController {
	
	@Autowired
	ShopService shopService;
	@Autowired
	CookingService cookingService;

	@GetMapping("cooking")
	String cooking(@ModelAttribute("cookingForm") CookingForm cookingForm,
			Model model) {
		
		
		model.addAttribute("cooking", cookingService.findCooking());
		model.addAttribute("cookingForm", cookingForm);
		
		return "serch/cooking";
	}
	
	@PostMapping("cookingserch")
	String cookingserch(@ModelAttribute("cookingForm") @Validated CookingForm cookingForm, BindingResult result, Model model) {
		return "serch/edit";
	}
	@PostMapping("shopserch")
	public String shopserch(@ModelAttribute("cookingForm") CookingForm cookingForm,Model model) {
		List<Shop> list = new ArrayList<>();
		if(StringUtils.hasText(cookingForm.getShopName())) {
		String shopName = cookingForm.getShopName();
		List<Shop> shopList = shopService.getfindByShopNameContaining(shopName);
		if(cookingForm.getDistance() != null) {
			
		}else {
			cookingForm.setDistance(0);
		}
		for(Shop sh : shopList) {
			if(!sh.getTakeOut().equals(cookingForm.getTakeOut()) && !cookingForm.getTakeOut().equals(0)) {
				
				//continue;
			}else {
				if(!sh.getGenre().equals(cookingForm.getGenre()) && !cookingForm.getGenre().equals("選択してください")){
					//list.add(sh);			//genreだけ記入で追加
					//continue;
				}else {
					if(sh.getDistance() > cookingForm.getDistance() && !cookingForm.getDistance().equals(0)) {
						//list.add(sh);
						//continue;
					}else {
						list.add(sh);
						continue;
					}
				}
			}
			if(cookingForm.getTakeOut().equals(0)) {
				if(cookingForm.getGenre().equals("選択してください")){
					if(sh.getDistance() > cookingForm.getDistance() && !cookingForm.getDistance().equals(0)) {
					}else {
						list.add(sh);
						continue;
					}
					
				}
			}
		}
		
		
		
		
		}else {
			List<Shop> shopList = shopService.findShop();
			for(Shop sh : shopList) {
				if(!sh.getTakeOut().equals(cookingForm.getTakeOut()) && !cookingForm.getTakeOut().equals(0)) {
					//continue;
				}else {
					if(!sh.getGenre().equals(cookingForm.getGenre()) && !cookingForm.getGenre().equals("選択してください")){
						//continue;
					}else {
						if(cookingForm.getDistance() != null && sh.getDistance() > cookingForm.getDistance() && cookingForm.getDistance() != 0) {
							//continue;
						}else {
							list.add(sh);		// 店舗名なし、テイクアウトジャンル距離が一致時に追加
						}
					}

				}
			}
		}
	
		model.addAttribute("shopList", list);
		model.addAttribute("cookingForm", cookingForm);
		//model.addAttribute("shopForm", shopForm);
		return "shop/detail";
	}
}
