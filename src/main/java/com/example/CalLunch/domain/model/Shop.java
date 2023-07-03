package com.example.CalLunch.domain.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer shopId;		//店舗ID
	private String shopName;	//店舗名
	private String genre;		//ジャンル
	private Integer phone;		//電話番号
	private Integer map;		//MAP位置情報
	private Integer takeOut;	//店内かテイクアウトか
	private Integer distance;	//距離

}
