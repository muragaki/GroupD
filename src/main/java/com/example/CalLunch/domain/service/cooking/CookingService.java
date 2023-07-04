package com.example.CalLunch.domain.service.cooking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.CalLunch.domain.model.Cooking;
import com.example.CalLunch.domain.repository.cooking.CookingRepository;

public class CookingService {
	
	@Autowired
	CookingRepository cookingRepository;
	
	public void save(Cooking cooking) {
		if (cookingRepository.readByCookingIdAndShopId(cooking.getCookingId(), cooking.getShopId()) == null) {
			cookingRepository.save(cooking);
		} else {
			// 既に登録されている場合は登録しない
		}
	}

	public List<Cooking> finditem(Integer shopId) {
		return cookingRepository.findByShopIdOrderByCookingIdAsc(shopId);
	}
}
