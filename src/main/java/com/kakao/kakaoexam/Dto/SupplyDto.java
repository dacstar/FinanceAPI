package com.kakao.kakaoexam.Dto;

import java.util.Map;

import lombok.Data;
//Test2�� ����� ���� Dto
@Data
public class SupplyDto {
	
	String year;
	String total_amount;
	Map<String,Long>[] detail_amount;
	
	
	public SupplyDto() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
	

}
