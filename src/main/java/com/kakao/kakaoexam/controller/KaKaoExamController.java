package com.kakao.kakaoexam.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
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
import com.kakao.kakaoexam.Dto.Test04Dto;
import com.kakao.kakaoexam.entity.HousesupplyEntity;
import com.kakao.kakaoexam.service.IFinanceService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class KaKaoExamController {
   
   @Autowired
   private IFinanceService iFinanceService;
   
   //Data init
   @RequestMapping(value ="/init")
   public void init() throws Exception {
      boolean inputdate = iFinanceService.putDate();
      if(!inputdate) {
         throw new Exception("init Error");
      }
      List<HousesupplyEntity> list = iFinanceService.getSupplyList();
   //   HousesupplyEntity test = iFinanceService.getyearTotal(2015);
   }
   
   
   //test1
   @RequestMapping(value ="/test")
   public List<SupplyDto> exam() throws Exception {
       //주택 금융 공급현황을 출력하기 위한 Dto
       /*           출력양식을 위한 String fotmat  
        * 
        *                   */ 
	   List<SupplyDto> supplylist = iFinanceService.getTotalsupply();
      // String sts=String.format("{\"name\":\"%s\",%s}", "주택금융 공급현황",new Gson().toJsonTree(supplylist).toString());

      return  supplylist;
      
   }
   
   @RequestMapping(value ="/test2")
   public List<MaxsupplyDto> exam2() throws Exception {
       //주택 금융 공급현황을 출력하기 위한 Dto
       /*           출력양식을 위한 String fotmat                    */ 
	   
	   List<MaxsupplyDto> maxsupplylist =iFinanceService.getMaxsupply();
	   
	   for(MaxsupplyDto max : maxsupplylist) {
		   System.out.println(max.toString());
	   }

      return maxsupplylist;
      
   }
   
   @RequestMapping(value ="/test3")
   public Test03Dto exam3() throws Exception {
       //주택 금융 공급현황을 출력하기 위한 Dto
       /*           출력양식을 위한 String fotmat                    */ 
	   
	  List<KebDto> keblist = iFinanceService.getKebavg();
     Test03Dto test03dto=new Test03Dto();
     List<KebDto> list = new LinkedList<>();
     
     list.add(keblist.get(0));
     list.add(keblist.get(keblist.size()-1));
     test03dto.setBank("외환은행");
     test03dto.setKebDto(list);
    

	  
	  return test03dto;
      
   }
   @RequestMapping(value ="/test4/{bank}/{month}", method = RequestMethod.GET)
   public Test04Dto exam4(@PathVariable("bank") String name,@PathVariable("month") int month) throws Exception {
      Map<String,String> map = iFinanceService.name();

      double res=iFinanceService.svd(iFinanceService.getMonthsupply(month-1, "kb"));
      Test04Dto test04dto = new Test04Dto(map.get(name),2018,month,res);

      System.out.println(res);
      System.out.println(map.get("국민은행"));


      return test04dto;
     
    

      
   }
   
   

}