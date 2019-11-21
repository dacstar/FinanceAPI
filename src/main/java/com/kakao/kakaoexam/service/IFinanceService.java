package com.kakao.kakaoexam.service;

import java.util.ArrayList;
import java.util.List;

import com.kakao.kakaoexam.Dto.KebDto;
import com.kakao.kakaoexam.Dto.MaxsupplyDto;
import com.kakao.kakaoexam.Dto.SupplyDto;
import com.kakao.kakaoexam.entity.HousesupplyEntity;

public interface IFinanceService {
	
	public int putDate();
	public List<HousesupplyEntity> getSupplyList();
	public List<HousesupplyEntity> getyearTotal(int year);
	public List<SupplyDto> getTotalsupply();
	public List<MaxsupplyDto> getMaxsupply();
	public List<KebDto> getKebavg();
	public int findMonth(int year);
	public List<Integer> getYear();
	
	

}
