package com.example.CalLunch.app.cooking;

import java.util.ArrayList;

import com.example.CalLunch.domain.model.Cooking;

import jakarta.validation.Valid;
import lombok.Data;

@Data
public class CookingForm {
	@Valid
	private ArrayList<Cooking> cookingList = new ArrayList<>();

}