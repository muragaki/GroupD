package com.example.CalLunch.app.image;

import org.springframework.web.multipart.MultipartFile;

public class ImageForm {

	private MultipartFile image;
	
	public MultipartFile getImage() {
		return image;
	}
	
	public void setImage(MultipartFile image) {
		this.image = image;
	}
}
