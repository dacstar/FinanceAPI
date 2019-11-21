package com.kakao.kakaoexam.service;

import java.util.ArrayList;
import java.util.List;

import com.kakao.kakaoexam.entity.HousesupplyEntity;

public interface IFinanceService {
	
	public int putDate();
	public List<HousesupplyEntity> getSupplyList();
	public List<HousesupplyEntity> getyearTotal(int year);
	
	

}
