package com.kakao.kakaoexam.Dto;

import lombok.Builder;
import lombok.Data;

@Data
public class MaxsupplyDto {
	
	private String year;
	private String bank;
	
	public MaxsupplyDto(String year, String bank) {
		super();
		this.year = year;
		this.bank = bank;
	}
	
	
	
	

}
