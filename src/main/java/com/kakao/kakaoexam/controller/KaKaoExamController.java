package com.kakao.kakaoexam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kakao.kakaoexam.service.IFinanceService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class KaKaoExamController {
	
	@Autowired
	private IFinanceService iFinanceService;
	
	@RequestMapping(value ="/init")
	public void init() throws Exception {
		System.out.println("гого");
		int inputdate = iFinanceService.putDate();
		if(inputdate ==0) {
			throw new Exception("init Error");
		}
		
	}

}
