package com.example.CalLunch.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_cooking")
public class Cooking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cookingId;		//料理ID
	private Integer shopId;			//店舗ID
	private String cookingName;		//料理名
	private Integer price;			//お値段
	
	private String image;			//画像
}
