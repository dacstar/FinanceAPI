package com.kakao.kakaoexam.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class HousesupplyEntity {
	
	private String year;   //연도
	
	@Id
	private String month;
	private String housefund; //주택도시기금
    private String kb; //국민
    private String woori; //우리;
    private String sh; //신한
    private String city; //시티
    private String hana; //하나
    private String nh; //농협
    private String keb; //외환
    private String etc;  //기타
    
    public HousesupplyEntity() {
    	
    }
    
    // CSV 파일 입력 생성자
	public HousesupplyEntity(String[] str) {
		this.year = str[0];
		this.housefund = str[1];
		this.kb = str[2];
		this.woori = str[3];
		this.sh = str[4];
		this.city = str[5];
		this.hana = str[6];
		this.nh = str[7];
		this.keb = str[8];
		this.etc = str[9];
	}
    
}
