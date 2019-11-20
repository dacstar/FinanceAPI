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
	private long year;   //����
	private String housefund; //���õ��ñ��
    private String kb; //����
    private String woori; //�츮;
    private String sh; //����
    private String city; //��Ƽ
    private String hana; //�ϳ�
    private String nh; //����
    private String keb; //��ȯ
    private String etc;  //��Ÿ
    
    //findAll ������
    public HousesupplyEntity() {
    	
    }
    
    // CSV ���� �Է� ������
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
