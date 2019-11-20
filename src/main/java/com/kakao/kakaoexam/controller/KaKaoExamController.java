package com.kakao.kakaoexam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kakao.kakaoexam.entity.HousesupplyEntity;
import com.kakao.kakaoexam.service.IFinanceService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class KaKaoExamController {
	
	@Autowired
	private IFinanceService iFinanceService;
	
	//Data init
	// csv 파일을 읽어 JPA를 이용해 저장
	@RequestMapping(value ="/init")
	public void init() throws Exception {
		System.out.println("하하");
		int inputdate = iFinanceService.putDate();
		if(inputdate ==0) {
			throw new Exception("init Error");
		}
		List<HousesupplyEntity> list = iFinanceService.getSupplyList();
	//	HousesupplyEntity test = iFinanceService.getyearTotal(2015);
	}
	
	
	//test1
	@RequestMapping(value ="/test")
	public void test() throws Exception {
        //연도별 총합을 구하기
		int older_year=Integer.MAX_VALUE;
		int latest_year=Integer.MIN_VALUE;
		
		
		//모든 공급 내역 가져오기
		List<HousesupplyEntity> list = iFinanceService.getSupplyList();
		
		
		List<HousesupplyEntity>test = iFinanceService.getyearTotal(2015);
		
		
		
		
	}

}
