package com.example.CalLunch.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CalLunch.domain.model.Shop;

@Service
public class ShopService {

	@Autowired
	ShopRepository shopRepository;
	
	public void save(Shop shop) {
		if(shopRepository.readByItemcodeAndShopId(shop.getShopName(), shop.getShopId()) == null) {
			shopRepository.save(shop);
		}else {
		}
	}
	
	public void delete(Shop shop) {
		shopRepository.delete(shop);
	}
	
	public List<Shop> findShop(){
		return shopRepository.findAllByShopId();
	}
	
	public void update(Shop shop) {
		if(shop.getShopId() == 0) {
			shopRepository.deleteById(shop.getShopId());
		}else {
			Shop tempshopid = shopRepository.findAllByShopId().get(0);
			tempshopid.setShopId(shop.getShopId());
			shopRepository.save(tempshopid);
			
		}
	}
}
