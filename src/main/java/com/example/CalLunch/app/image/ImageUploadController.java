package com.example.CalLunch.app.image;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageUploadController {

	@PostMapping("img_upload")
	public String uploadImage(@RequestParam("file") MultipartFile file) {
		
	}
}
