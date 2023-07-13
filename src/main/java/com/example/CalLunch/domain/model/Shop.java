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
@Table(name = "t_shop")
public class Shop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer shopId;		//店舗ID
	private String shopName;	//店舗名
	private String genre;		//ジャンル
	private Integer phone;		//電話番号
	private Integer takeOut;	//店内かテイクアウトか
	private Integer distance;	//距離
	private Integer mapX;       //座標X
	private Integer mapY;       //座標Y
	
	//@Lob
	//private byte[] image;	//画像
	
	public Shop(String shopName, String genre,Integer phone, Integer takeOut, Integer distance, Integer mapX, Integer mapY) {
		this.shopName = shopName;
		this.genre = genre;
		this.phone = phone;
		this.takeOut = takeOut;
		this.distance = distance;
		this.mapX = mapX;
		this.mapY = mapY;
		
	}
}