package com.kakao.kakaoexam.Dto;

import lombok.Data;

@Data
public class Test04Dto {
	
    private String bank;
    private int year;
    private int month;
    private double amount;

    public Test04Dto(String bank, int year, int month,double amount) {
		super();
		this.bank = bank;
		this.year = year;
        this.month = month;
        this.amount = amount;
	}
	
	
	
	

}
