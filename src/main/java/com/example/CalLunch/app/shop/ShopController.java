package com.example.CalLunch.app.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.CalLunch.app.cooking.CookingForm;
import com.example.CalLunch.domain.model.Cooking;
import com.example.CalLunch.domain.model.Shop;
import com.example.CalLunch.domain.model.ShopDTO;
import com.example.CalLunch.domain.service.cooking.CookingService;
import com.example.CalLunch.domain.service.shop.ShopService;

@Controller
public class ShopController {

	@Autowired
	ShopService shopService;
	
	@Autowired
	CookingService cookingService; 
	
	/*
	 * private final ShopRepository shopRepository;
	 */
	
	/*
	  @PostMapping("detail")	//詳細画面確認用
	public String detail(Model model){
		String imagePath = "restaurant-449952_1280_small.jpg";
		model.addAttribute("imagePath", imagePath);
		model.addAttribute("detail", shopService.getShopByShopId(2));
		return "shop/detail1";
	}*/	
	
	/*@PostMapping("shopEdit")
		public String getShopDetails(@PathVariable Integer shopId, Model model) {
			Shop shop = shopService.getShopByShopId(shopId);
			String name = shop.getShopName();
			model.addAttribute("name", name);
		return "serch/edit";
	}
	*/
	@GetMapping("top")
	public String top(Model model) {
		model.addAttribute("top", shopService.findShop());
		return "lunchtop/top";
	}
	@PostMapping("register")
	public String register(@ModelAttribute("shopForm") ShopForm shopForm,Model model) {
		model.addAttribute("shopForm", shopForm);
		model.addAttribute("register", shopService.findShop());
		return "register/register";
	}
	
	
	@PostMapping("serch")
	public String sercher(@ModelAttribute("cookingForm") CookingForm cookingForm,Model model) {
		model.addAttribute("serch", shopService.findShop());
		model.addAttribute("cookingForm", cookingForm);
		return "serch/cooking";
	}
	@PostMapping("/confirmation")
	public String confirmation(@ModelAttribute("shopForm") ShopForm shopForm,
			BindingResult bindingResult,
			Model model) {
		if(shopForm.getPhone() == null) {
			shopForm.setPhone(0);
		}
		/*if(shopForm.getTakeOut() == null) {
			shopForm.setTakeOut(0);
		}*/
		if(shopForm.getDistance() == null) {
			shopForm.setDistance(0);
		}
		if(shopForm.getMapX() == null) {
			shopForm.setMapX(0);
		}
		if(shopForm.getMapY() == null) {
			shopForm.setMapY(0);
		}
		if(shopForm.getPrice() == null) {
			shopForm.setPrice(0);
		}
		if(shopForm.getImage() != null && !shopForm.getImage().isEmpty()) {
			
		}else {
			shopForm.setImage("");
		}
		//Shop shop = new Shop(shopName,genre,phone,takeOut,distance,mapX,mapY);
		//model.addAttribute("shop", shop);
		model.addAttribute("shopForm", shopForm);
		//model.addAttribute("shopForm", new ShopForm());
		//model.addAttribute("shopService", shopService);
		//model.addAttribute("cooking", cookingService.findCooking());
		
		return "register/preview";
	}
	@PostMapping("/preview")
    public String preview(@ModelAttribute("shopForm") ShopForm shopForm,
    		Model model) {
		// Shopオブジェクトの作成と保存
	    Shop shop = new Shop();
	    shop.setShopName(shopForm.getShopName());
	    shop.setDistance(shopForm.getDistance());
	    shop.setGenre(shopForm.getGenre());
	    shop.setTakeOut(shopForm.getTakeOut());
	    shop.setPhone(shopForm.getPhone());
	    shopService.save(shop);
	    
	    // shopIdの値を取得
	    Integer shopId = shop.getShopId();
	    
	 // Cookingオブジェクトの作成と保存
	    Cooking cooking = new Cooking();
	    cooking.setShopId(shopId); // 有効なshopIdを設定
	    cooking.setCookingName(shopForm.getCookingName());
	    cooking.setPrice(shopForm.getPrice());
	    cooking.setImage(shopForm.getImage());
	    cookingService.save(cooking);
	    model.addAttribute("shopForm", shopForm);

        return "lunchtop/top"; // 表示するビューの名前を返す
    }
	@PostMapping("upload")
	public String upload(Model model) {
		model.addAttribute("upload", shopService.findShop());
		return "lunchtop/top";
	}
	/*@PostMapping("comment")
	public String comment(Model model) {
		model.addAttribute("comment", shopService.findShop());
		return "table/table";
	}*/
	@PostMapping("access")
	public String access(Model model) {
		model.addAttribute("comment", shopService.findShop());
		return "comment/comment";
	}
	
	
	@PostMapping("shopEdit")
	public String shopEdit(Model model) {
		model.addAttribute("detail", shopService.getShopByShopId(1));
		return "serch/edit";
	}
	
	@PostMapping("save")
	public ModelAndView saveEntity(@RequestParam("name") String shopName,
								   @RequestParam("genre") String genre,
								   @RequestParam("phone") Integer phone,
								   @RequestParam("takeOut") Integer takeOut,
								   @RequestParam("distance") Integer distance,
								   @RequestParam("mapX") Integer mapX,
								   @RequestParam("mapY") Integer mapY) {
		Shop shop = new Shop();
		shop.setShopName(shopName);
		shop.setGenre(genre);
		shop.setPhone(phone);
		shop.setTakeOut(takeOut);
		shop.setDistance(distance);
		shop.setMapX(mapX);
		shop.setMapY(mapY);
		Shop savedEntity = shopService.saveShop(shop);
		return new ModelAndView("your-success-page").addObject("shop", savedEntity);
	}
	
	@PostMapping("input")
	public String input(Model model,
			@RequestParam Integer id,
			@RequestParam String name,
			@RequestParam String genre,
			@RequestParam Integer phone,
			@RequestParam Integer takeOut,
			@RequestParam Integer distance) {
		System.out.println("店舗ID:"+id);
		ShopDTO shopdto = new ShopDTO();
		shopdto.setShopId(id);
		shopdto.setShopName(name);
		shopdto.setGenre(genre);
		shopdto.setPhone(phone);
		shopdto.setTakeOut(takeOut);
		shopdto.setDistance(distance);
		model.addAttribute("shopdto", shopdto);
		return "edit/input";
	}
	
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
}
