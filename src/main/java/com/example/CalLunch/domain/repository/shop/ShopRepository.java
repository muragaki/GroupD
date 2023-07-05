package com.example.CalLunch.domain.repository.shop;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CalLunch.domain.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Integer>{
	Shop findByShopId (Integer shopId);
	List<Shop> findAll ();
	Shop readByShopName(String shopName);
	Shop readByShopNameAndShopId(String shopName, Integer shopId);
}
