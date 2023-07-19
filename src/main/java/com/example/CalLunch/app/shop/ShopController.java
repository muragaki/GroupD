package com.example.CalLunch.app.shop;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.CalLunch.app.comment.CommentForm;
import com.example.CalLunch.app.cooking.CookingForm;
import com.example.CalLunch.domain.model.Comment;
import com.example.CalLunch.domain.model.Cooking;
import com.example.CalLunch.domain.model.Shop;
import com.example.CalLunch.domain.model.ShopDTO;
import com.example.CalLunch.domain.service.comment.CommentService;
//github.com/muragaki/GroupD.git
import com.example.CalLunch.domain.service.cooking.CookingService;
import com.example.CalLunch.domain.service.shop.ShopService;

@Controller
public class ShopController {

	@Autowired
	ShopService shopService;
	
	@Autowired
	CookingService cookingService; 
	
	@Autowired
	CommentService commentService;
	
	// プロパティから保存先ディレクトリのパスを取得
    @Value("${file.upload.dir}") // application.propertiesまたはapplication.ymlで指定
    private String uploadDir;
    
    
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
			Model model,
			@RequestParam("image") MultipartFile image) throws IOException {
		if(shopForm.getPhone() == null) {
			shopForm.setPhone("");
		}
		
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
		//if(shopForm.getImage() != null && !shopForm.getImage().isEmpty()) {
			
		//}else {
			 String originalFilename = StringUtils.cleanPath(image.getOriginalFilename());
			shopForm.setImage(originalFilename);
		//}
		
		if (!image.isEmpty()) {
            
	        //String filePath = uploadDir + "/" + originalFilename;
	        //File saveFile = new File(filePath);
	        //image.transferTo(saveFile);
                // ファイルを保存するディレクトリパスを構築
                String savePath =  uploadDir + originalFilename;
                // 保存先ディレクトリが存在しない場合は作成
                File saveDir = new File(savePath);
                if (!saveDir.exists()) {
                    saveDir.mkdirs();
                }
                FileCopyUtils.copy(image.getBytes(), new File(savePath));
		}
		// 画像を保存するパス
       /* String uploadDir = environment.getProperty("file.upload.dir");
	    String imagePath = uploadDir + image.getOriginalFilename();

	    // 画像を指定のパスに保存
	    File imageFile = new File(imagePath);
	    image.transferTo(imageFile);
		*/
	    // 保存した画像のパスをShopFormにセット
	   // shopForm.setImagePath("/image/" + image.getOriginalFilename());
		//}
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
	public String upload(@ModelAttribute("commentForm") CommentForm commentForm,Model model) {
		Comment comment = new Comment();
		comment.setShopId(commentForm.getShopId());
		comment.setTitle(commentForm.getTitle());
		comment.setEvaluation(commentForm.getEvaluation());
		comment.setText(commentForm.getText());
		comment.setTime(LocalDateTime.now());
		//String originalFilename = StringUtils.cleanPath(image.getOriginalFilename());
		//comment.setImage(commentForm.getImage().getBytes());
		//comment.setImage(commentForm.getImage());
		// 店舗エンティティを取得する（例として、idが1の店舗を取得するとします）
		if(commentForm.getShopId() == null) {
			
		}else {
		Shop shop = new Shop();
		shop.setShopId(commentForm.getShopId());
		comment.setShop(shop);
		
		}
		commentService.save(comment);
		//model.addAttribute("upload", shopService.findShop());
		model.addAttribute("commentForm", new CommentForm()); // コメントフォームをリセット
		return "lunchtop/top";
	}
	@PostMapping("comment")
	public String comment(@ModelAttribute("shopForm") ShopForm shopForm,
			@ModelAttribute("commentForm") CommentForm commentForm,Model model) {
		List<Shop> shopList = shopService.findShop();
		model.addAttribute("shopList", shopList);
		//model.addAttribute("comment", shopService.findShop());
		model.addAttribute("shopForm", shopForm);
		model.addAttribute("commentForm", commentForm);
		return "table/table";
	}
	
	@PostMapping("access")
	public String access(@ModelAttribute("shopForm") ShopForm shopForm,
			@ModelAttribute("commentForm") CommentForm commentForm,Model model) {
		//model.addAttribute("comment", shopService.findShop());
		List<Comment> list = new ArrayList<>();
		list.addAll(commentService.findShopId(commentForm.getShopId()));
		model.addAttribute("shopForm", shopForm);
		model.addAttribute("commentForm", commentForm);
		model.addAttribute("commentList", list);
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
								   @RequestParam("phone") String phone,
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
			@RequestParam String phone,
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
							@RequestParam String phone,
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
