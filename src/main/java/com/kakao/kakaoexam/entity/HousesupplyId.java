package com.kakao.kakaoexam.entity;

import java.io.Serializable;

import javax.persistence.Id;

import lombok.Data;

@Data
public class HousesupplyId implements Serializable {
	
	

	private static final long serialVersionUID = 1L;
	private long month;
	private long year;

}
