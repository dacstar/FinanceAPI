package com.kakao.kakaoexam.Dto;

import lombok.Builder;
import lombok.Data;

@Data
public class MaxsupplyDto {
	
	private int year;
	private String bank;
	
	public MaxsupplyDto(int year, String bank) {
		super();
		this.year = year;
		this.bank = bank;
	}
	
	
	
	

}
