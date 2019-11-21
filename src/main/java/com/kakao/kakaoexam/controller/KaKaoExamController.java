package com.kakao.kakaoexam.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kakao.kakaoexam.Dto.KebDto;
import com.kakao.kakaoexam.Dto.MaxsupplyDto;
import com.kakao.kakaoexam.Dto.SupplyDto;
import com.kakao.kakaoexam.Dto.Test03Dto;
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
   //   HousesupplyEntity test = iFinanceService.getyearTotal(2015);
   }
   
   
   //test1
   @RequestMapping(value ="/test")
   public String test() throws Exception {
       //주택 금융 공급현황을 출력하기 위한 Dto
       /*           출력양식을 위한 String fotmat  
        * 
        *                   */ 
	   List<SupplyDto> supplylist = iFinanceService.getTotalsupply();
	   
      JsonObject js = new JsonObject();
      JsonObject js2 = new JsonObject();
      String name="주택금융 공급현황";
     

      String sts=String.format("{\"name\":\"%s\",%s}", "주택금융 공급현황",new Gson().toJsonTree(supplylist).toString());

      return  sts;
      
   }
   
   @RequestMapping(value ="/test2")
   public List<MaxsupplyDto> test2() throws Exception {
       //주택 금융 공급현황을 출력하기 위한 Dto
       /*           출력양식을 위한 String fotmat                    */ 
	   
	   List<MaxsupplyDto> maxsupplylist =iFinanceService.getMaxsupply();
	   
	   for(MaxsupplyDto max : maxsupplylist) {
		   System.out.println(max.toString());
	   }

      return maxsupplylist;
      
   }
   
   @RequestMapping(value ="/test3")
   public Test03Dto test3() throws Exception {
       //주택 금융 공급현황을 출력하기 위한 Dto
       /*           출력양식을 위한 String fotmat                    */ 
	   
	  List<KebDto> keblist = iFinanceService.getKebavg();
     Test03Dto test03dto=new Test03Dto();
     List<KebDto> list = new LinkedList<>();

     list.add(keblist.get(0));
     list.add(keblist.get(keblist.size()-1));

     test03dto.setKebDto(list);
    

	  
	  return test03dto;
      
   }
   
   

}