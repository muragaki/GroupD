package com.example.CalLunch.app.shop;

import java.util.ArrayList;
import java.util.List;

import com.example.CalLunch.domain.model.Shop;

import jakarta.validation.Valid;
import lombok.Data;

@Data
public class ShopForm {
	@Valid
	private List<Shop> shopList = new ArrayList<>();
	
	private Integer shopId;
	private String shopName;
	private String phone;
	private Integer distance;
	private String genre;
	private Integer takeOut;
	private Integer mapX;
	private Integer mapY;
	private String cookingName;
	private Integer price;
	private String image;
	private String imagePath;
}
