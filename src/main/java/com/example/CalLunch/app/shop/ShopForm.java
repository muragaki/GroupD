package com.example.CalLunch.app.shop;

import java.util.ArrayList;

import com.example.CalLunch.domain.model.Shop;

import jakarta.validation.Valid;
import lombok.Data;

@Data
public class ShopForm {

	@Valid
	private ArrayList<Shop> shopList = new ArrayList<>();

}
