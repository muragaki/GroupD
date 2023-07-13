package com.example.CalLunch.app.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CalLunch.domain.model.Shop;
import com.example.CalLunch.domain.repository.shop.ShopRepository;

@Service
public class EditService {
	private ShopRepository shopRepository;
	
	@Autowired
	public EditService(ShopRepository shopRepository) {
		this.shopRepository = shopRepository;
	}
	
	public Shop overrite(Shop shop) {
		return shopRepository.save(shop);
	}
}
