package com.example.CalLunch.domain.repository.shop;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CalLunch.domain.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Integer>{
	List<Shop> findAllByShopId ();
	Shop readByItemcode(String shopName);
	Shop readByItemcodeAndShopId(String shopName, Integer shopId);
}
