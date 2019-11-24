package com.kakao.kakaoexam.entity;

import java.util.Map;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@IdClass(HousesupplyId.class)
public class HousesupplyEntity {
	
	
	
	@Id
	private int month;
	@Id
	private int year;   
	private String housefund; 
    private String kb; //����
    private String woori; //�츮;
    private String sh; //����
    private String city; //��Ƽ
    private String hana; //�ϳ�
    private String nh; //����
    private String keb; //��ȯ
	private String etc;  //��Ÿ
	
    
    //findAll을 위한 생성자
    public HousesupplyEntity() {
    	
    }
    
    // CSV 저장을 위한 생성자
	public HousesupplyEntity(String[] str) {
		this.year = Integer.parseInt(str[0]);
		this.month =Integer.parseInt(str[1]); 
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

	
    
    
    
    
}
