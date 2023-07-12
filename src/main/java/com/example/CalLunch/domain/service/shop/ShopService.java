package com.example.CalLunch.domain.service.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CalLunch.domain.model.Shop;
import com.example.CalLunch.domain.repository.shop.ShopRepository;

@Service
public class ShopService {

	@Autowired
	ShopRepository shopRepository;
	
	
	public void save(Shop shop) {
		if(shopRepository.findByShopNameAndShopId(shop.getShopName(), shop.getShopId()) == null) {
			shopRepository.save(shop);
		}else {
		}
	}
	
	
	public void delete(Shop shop) {
		shopRepository.delete(shop);
	}
	
	public List<Shop> findShop(){
		return shopRepository.findAll();
	}
	
	public void update(Shop shop) {
		if(shop.getShopId() == 0) {
			shopRepository.deleteById(shop.getShopId());
		}else {
			Shop tempshopid = shopRepository.findByShopId(shop.getShopId());//.get(0);
			tempshopid.setShopId(shop.getShopId());
			shopRepository.save(tempshopid);
			
		}
	}
	
	public Shop getShopByShopId(Integer shopId) {
		return shopRepository.findByShopId(shopId);
	}
	public Shop getfindByShopName(String shopName) {
		return shopRepository.findByShopName(shopName);
	}
	public List<Shop> getfindByShopNameContaining(String shopName) {
        return shopRepository.findByShopNameContaining(shopName);
    }
}
