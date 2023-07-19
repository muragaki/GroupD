package com.example.CalLunch.app.edit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.CalLunch.app.comment.CommentForm;
import com.example.CalLunch.app.shop.ShopForm;
import com.example.CalLunch.domain.model.Comment;
import com.example.CalLunch.domain.model.Shop;
import com.example.CalLunch.domain.repository.shop.ShopRepository;
import com.example.CalLunch.domain.service.comment.CommentService;
import com.example.CalLunch.domain.service.shop.ShopService;

@Controller
public class EditController {
@Autowired
	ShopService shopService;

@Autowired
	ShopRepository shopRepository;
@Autowired
	CommentService commentService;
	/*
	public EditController(ShopService shopService) {
		this.shopService = shopService;
	}
	
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
	
	@PostMapping("overrite")
	public String overrite(@RequestParam Integer shopId,
						   @RequestParam String shopName,
						   @RequestParam String genre,
						   @RequestParam String phone,
						   @RequestParam Integer takeOut,
						   @RequestParam Integer distance) {
		Shop shop = shopRepository.findByShopId(shopId);
		//店舗詳細のidを持ってくる
		//if(shop.getShopId() == editForm.getShopId()) {	//idが一致すれば
		shop.setShopName(shopName);
		shop.setGenre(genre);
		shop.setPhone(phone);
		shop.setTakeOut(takeOut);
		shop.setDistance(distance);
		shopService.saveShop(shop);
		return "edit/success";
		}
	
	@PostMapping("specifics")
	public String specifics(@RequestParam Integer shopId,
			   @RequestParam String shopName,
			   @RequestParam String genre,
			   @RequestParam String phone,
			   @RequestParam Integer takeOut,
			   @RequestParam Integer distance, @ModelAttribute("shopForm") ShopForm shopForm,
				@ModelAttribute("commentForm") CommentForm commentForm, Model model) {
		Shop shop = shopRepository.findByShopId(shopId);
		//店舗詳細のidを持ってくる
		//if(shop.getShopId() == editForm.getShopId()) {	//idが一致すれば
		shop.setShopName(shopName);
		shop.setGenre(genre);
		shop.setPhone(phone);
		shop.setTakeOut(takeOut);
		shop.setDistance(distance);
		model.addAttribute("shop", shop);
		
		List<Comment> list = new ArrayList<>();
		list.addAll(commentService.findShopId(commentForm.getShopId()));
		model.addAttribute("shopForm", shopForm);
		model.addAttribute("commentForm", commentForm);
		model.addAttribute("commentList", list);
		
		return "edit/specifics";
	}
	/*
	@PostMapping("specifics")
		public String access(@ModelAttribute("shopForm") ShopForm shopForm,
				@ModelAttribute("commentForm") CommentForm commentForm,Model model) {
			//model.addAttribute("comment", shopService.findShop());
			List<Comment> list = new ArrayList<>();
			list.addAll(commentService.findShopId(commentForm.getShopId()));
			model.addAttribute("shopForm", shopForm);
			model.addAttribute("commentForm", commentForm);
			model.addAttribute("commentList", list);
		
		return "edit/specifics";
	}*/
}