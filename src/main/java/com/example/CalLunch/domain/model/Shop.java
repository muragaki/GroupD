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

}
