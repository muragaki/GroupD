package com.example.CalLunch.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_coment")
public class Comment {

	@Id
	private Integer shopId;			//店舗ID
	private String cookingName;		//料理名
	private String title;			//タイトル
	private String text;			//コメント
	private Integer evaluation;		//評価
	private LocalDateTime time;		//時間
	private String image;			//写真
}
