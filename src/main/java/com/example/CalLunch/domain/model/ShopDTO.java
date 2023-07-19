package com.example.CalLunch.domain.model;

import lombok.Data;

@Data
public class ShopDTO {

	private Integer shopId;		//店舗ID
	private String shopName;	//店舗名
	private String genre;		//ジャンル
	private String phone;		//電話番号
	private Integer takeOut;	//店内かテイクアウトか
	private Integer distance;	//距離
	private Integer mapX;       //座標X
	private Integer mapY;       //座標Y
}