package com.example.CalLunch.app.edit;

import jakarta.validation.Valid;
import lombok.Data;

@Data
public class EditForm {
	@Valid
	
	private Integer shopId;
	private String shopName;
	private String genre;
	private Integer phone;
	private Integer takeOut;
	private Integer distance;
	private Integer mapX;
	private Integer mapY;
}
