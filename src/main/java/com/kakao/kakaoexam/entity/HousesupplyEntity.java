package com.kakao.kakaoexam.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class HousesupplyEntity {
	
	private String year;   //����
	
	@Id
	private String month;
	private String housefund; //���õ��ñ��
    private String kb; //����
    private String woori; //�츮;
    private String sh; //����
    private String city; //��Ƽ
    private String hana; //�ϳ�
    private String nh; //����
    private String keb; //��ȯ
    private String etc;  //��Ÿ
    
    public HousesupplyEntity() {
    	
    }
    
    // CSV ���� �Է� ������
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
