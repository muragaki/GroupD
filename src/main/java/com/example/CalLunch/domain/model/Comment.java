package com.example.CalLunch.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

	private Integer shopId;			//店舗ID
	private String cookingName;		//料理名
	private String title;			//タイトル
	private String text;			//コメント
	private Integer evaluation;		//評価
	private LocalDateTime time;		//時間
}
