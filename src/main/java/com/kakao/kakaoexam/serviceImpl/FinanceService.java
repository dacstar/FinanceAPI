package com.kakao.kakaoexam.serviceImpl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kakao.kakaoexam.repository.HousesupplyRespository;
import com.kakao.kakaoexam.service.IFinanceService;

import ch.qos.logback.core.net.server.ConcurrentServerRunner;
@Service
public class FinanceService implements IFinanceService{
	
	
	
	@Autowired
	private HousesupplyRespository housesupplyRespository; 

	@Override
	public int putDate() {
		// TODO Auto-generated method stub
		int status=1;
		
		//CSV 파일의 내용을 HousesupplyEntity에 저장
		try {
			BufferedReader data = new BufferedReader(new FileReader("src/main/resources/static/사전과제3.csv"));
			
			while(data.readLine() != null ) {
				ArrayList<String[]> list = new ArrayList<>();
			
          
				
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status=0;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	

}
