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
  
	   List<SupplyDto> supplylist = iFinanceService.getTotalsupply();
  

      return  supplylist;
      
   }
   //exam2
   @RequestMapping(value ="/test2")
   public List<MaxsupplyDto> exam2() throws Exception {
     
	   
	   List<MaxsupplyDto> maxsupplylist =iFinanceService.getMaxsupply();
	   
	   for(MaxsupplyDto max : maxsupplylist) {
		   System.out.println(max.toString());
	   }

      return maxsupplylist;
      
   }
   //exam3
   @RequestMapping(value ="/test3")
   public Test03Dto exam3() throws Exception {

	   
	  List<KebDto> keblist = iFinanceService.getKebavg();
     Test03Dto test03dto=new Test03Dto();
     List<KebDto> list = new LinkedList<>();
     
     list.add(keblist.get(0));
     list.add(keblist.get(keblist.size()-1));
     test03dto.setBank("외환은행");
     test03dto.setKebDto(list);
    

	  
	  return test03dto;
      
   }
   //exam4
   @RequestMapping(value ="/test4/{bank}/{month}", method = RequestMethod.GET)
   public Test04Dto exam4(@PathVariable("bank") String name,@PathVariable("month") int month) throws Exception {
      Map<String,String> map = iFinanceService.name();

      double res=iFinanceService.svd(iFinanceService.getMonthsupply(month-1, map.get(name)));
      Test04Dto test04dto = new Test04Dto(map.get(name),2018,month,res);

      System.out.println(res);
      System.out.println(map.get(name));


      return test04dto;
     
    

      
   }
   
   

}