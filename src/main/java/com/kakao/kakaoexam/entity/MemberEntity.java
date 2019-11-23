package com.kakao.kakaoexam.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class MemberEntity {
	
	
	
    @Id
    private String id;
    private String password;
    
    //findAll을 위한 생성자
    public HousesupplyEntity() {
    	
    }
    
    @Builder
    public MemberEntity(String id, String password) {
        this.id = id;
        this.password = password;
     
    }

	
    
    
    
    
}
