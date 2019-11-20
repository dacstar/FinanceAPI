package com.kakao.kakaoexam.entity;

import javax.persistence.*;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@IdClass(HousesupplyId.class)
public class HousesupplyEntity {
	
	
	
	@Id
	private long month;
	@Id
	private long year;   //연도
	private String housefund; //주택도시기금
    private String kb; //국민
    private String woori; //우리;
    private String sh; //신한
    private String city; //시티
    private String hana; //하나
    private String nh; //농협
    private String keb; //외환
    private String etc;  //기타
    
    //findAll 생성자
    public HousesupplyEntity() {
    	
    }
    
    // CSV 파일 입력 생성자
    @Builder
	public HousesupplyEntity(String[] str) {
		this.year = Long.parseLong(str[0]);
		this.month =Long.parseLong(str[1]); 
		this.housefund = str[2];
		this.kb = str[3];
		this.woori = str[4];
		this.sh = str[5];
		this.city = str[6];
		this.hana = str[7];
		this.nh = str[8];
		this.keb = str[9];
		this.etc = str[10];
	}

	@Override
	public String toString() {
		return "HousesupplyEntity [month=" + month + ", year=" + year + ", housefund=" + housefund + ", kb=" + kb
				+ ", woori=" + woori + ", sh=" + sh + ", city=" + city + ", hana=" + hana + ", nh=" + nh + ", keb="
				+ keb + ", etc=" + etc + "]";
	}
    
    
    
    
}
