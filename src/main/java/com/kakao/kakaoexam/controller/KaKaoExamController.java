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
	// csv ������ �о� JPA�� �̿��� ����
	@RequestMapping(value ="/init")
	public void init() throws Exception {
		System.out.println("����");
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
        //������ ������ ���ϱ�
		int older_year=Integer.MAX_VALUE;
		int latest_year=Integer.MIN_VALUE;
		
		
		//��� ���� ���� ��������
		List<HousesupplyEntity> list = iFinanceService.getSupplyList();
		
		
		List<HousesupplyEntity>test = iFinanceService.getyearTotal(2015);
		
		
		
		
	}

}
