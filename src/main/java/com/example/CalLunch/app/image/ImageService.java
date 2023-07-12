package com.example.CalLunch.app.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CalLunch.domain.model.Shop;

@Service
public class ImageService {

	private final ImageRepository imageRepository;
	
	@Autowired
	public ImageService(ImageRepository imageRepository) {
		this.imageRepository = imageRepository;
	}
	
	public void saveEntity(Shop shop) {
		imageRepository.save(shop);
	}
}
