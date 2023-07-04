package com.example.CalLunch.domain.repository.cooking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CalLunch.domain.model.Cooking;



public interface CookingRepository extends JpaRepository<Cooking, Integer>{
	List<Cooking> findAllByOrderByCookingId();
	Cooking readByCookingIdAndShopId(Integer cookingId, Integer shopId);
	List<Cooking> findByShopIdOrderByCookingIdAsc(Integer shopId);

}
