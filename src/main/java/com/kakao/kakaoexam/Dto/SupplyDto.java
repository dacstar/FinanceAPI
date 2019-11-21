package com.kakao.kakaoexam.Dto;

import java.util.List;
import java.util.Map;

import lombok.Getter;
//Test2�� ����� ���� Dto
import lombok.Setter;

@Getter
@Setter
public class SupplyDto {
	
	private String year;
	private int total_amount;
	private List<Map<String,Integer>> detail_amount;
	
	
	public SupplyDto(String year, int total_amount, List<Map<String, Integer>> detail_amount) {
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
