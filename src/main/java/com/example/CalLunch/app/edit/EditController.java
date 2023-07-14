package com.example.CalLunch.app.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.CalLunch.domain.model.Shop;
import com.example.CalLunch.domain.service.shop.ShopService;

@Controller
public class EditController {
@Autowired
	private final ShopService shopService;
	
	
	public EditController(ShopService shopService) {
		this.shopService = shopService;
	}
	/*
	@PostMapping("input")
	public String input(@ModelAttribute("editForm") EditForm editForm) {
		return "edit/input";
	}
	*/
	/*
	@PostMapping("editInfo")
	public String toEditInfo
		(@ModelAttribute("editForm") EditForm editForm, Model model){
		
		//editForm.setMapY(100);
		Shop shop = new Shop();
		shop.setShopName(editForm.getShopName());
		shop.setGenre(editForm.getGenre());
		shop.setPhone(editForm.getPhone());
		shop.setTakeOut(editForm.getTakeOut());
		shop.setDistance(editForm.getDistance());
		shop.setMapX(editForm.getMapX());
		shop.setMapY(editForm.getMapY());
		
		model.addAttribute("editForm", editForm);
		
		return "edit/editInfo";
	}*/
	/*
	@PostMapping("editInfo")
	public String editInfo(Model model,
							@RequestParam String shopName,
							@RequestParam String genre,
							@RequestParam Integer phone,
							@RequestParam Integer takeOut,
							@RequestParam Integer distance,
							@RequestParam Integer mapX,
							@RequestParam Integer mapY) {
		model.addAttribute("shopName", shopName);	
		model.addAttribute("genre", genre);	
		model.addAttribute("phone", phone);	
		model.addAttribute("takeOut", takeOut);	
		model.addAttribute("distance", distance);	
		model.addAttribute("mapX", mapX);
		model.addAttribute("mapY", mapY);	
		return "edit/editInfo";
	}
	*/
	
	@PostMapping("overrite")
	public String overrite(@RequestParam String shopName,
						@RequestParam String genre,
						@RequestParam Integer phone,
						@RequestParam Integer takeOut,
						@RequestParam Integer distance,
						@RequestParam Integer mapX,
						@RequestParam Integer mapY) {
		Shop shop = new Shop();
		//店舗詳細のidを持ってくる
		
		//if(shop.getShopId() == editForm.getShopId()) {	//idが一致すれば
		shop.setShopName(shopName);
		shop.setGenre(genre);
		shop.setPhone(phone);
		shop.setTakeOut(takeOut);
		shop.setDistance(distance);
		shop.setMapX(mapX);
		shop.setMapY(mapY);
		shopService.save(shop);
		return "lunchtop/top";
		}
	}
