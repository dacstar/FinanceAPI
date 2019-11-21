package com.kakao.kakaoexam.Dto;

import java.util.List;
import java.util.Map;

import lombok.Data;
//Test2�� ����� ���� Dto

public class SupplyDto {
	
	String year;
	String total_amount;
	List<Map<String,String>> detail_amount;
	
	
	public SupplyDto(String year, String total_amount, List<Map<String, String>> detail_amount) {
		super();
		this.year = year;
		this.total_amount = total_amount;
		this.detail_amount = detail_amount;
	}


	@Override
	public String toString() {
		return "SupplyDto [year=" + year + ", total_amount=" + total_amount + ", detail_amount=" + detail_amount + "]";
	}
	
	
	
	
	
	

	
	
	

}
