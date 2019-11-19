package com.kakao.kakaoexam.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Item {
	
	@Column(name="name")
	@Id
	private String name;
	private int price;
	
	

}
