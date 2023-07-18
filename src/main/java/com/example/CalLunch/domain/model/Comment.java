package com.example.CalLunch.domain.model;

import java.time.LocalDateTime;

//import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

	//@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Integer commentId;
	@Column(insertable = false, updatable = false)
	private Integer shopId;			//店舗ID
	//private String cookingName;		//料理名
	private String title;			//タイトル
	private String text;			//コメント
	private Integer evaluation;		//評価

	@Id
	private LocalDateTime time;		//時間
	//private String image;
	@ManyToOne
    @JoinColumn(name = "shopId", referencedColumnName = "shopId")
    private Shop shop;

//	private LocalDateTime time;		//時間
	private String image;			//写真

}
