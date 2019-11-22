package com.kakao.kakaoexam.Dto;

import java.util.List;

import lombok.Data;

public class Test03Dto {
	
	 String bank="외환은행";
	 List<KebDto> kebDto;
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public List<KebDto> getKebDto() {
		return kebDto;
	}
	public void setKebDto(List<KebDto> kebDto) {
		this.kebDto = kebDto;
	}
	 
	 
	 
	 
	
	

}
