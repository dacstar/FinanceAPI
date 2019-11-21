package com.kakao.kakaoexam.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kakao.kakaoexam.Dto.SupplyDto;
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
        //������ ������ ���ϱ�
      int older_year=Integer.MAX_VALUE;
      int latest_year=Integer.MIN_VALUE;
      
      
      //전체 주택 공급현황 가져오기
      List<HousesupplyEntity> list = iFinanceService.getSupplyList();
      
      for(int i=0;i<list.size();i++) {
    	  //제일 오래된 연도 구하기
         older_year=Math.min(older_year, list.get(i).getYear());
         //제일 최신 연도 구하기
         latest_year=Math.max(older_year, list.get(i).getYear());
      }
      
      System.out.println(older_year);
      System.out.println(latest_year);
      
      
      //과제 1번 출력을 위한 배열 선언
      SupplyDto[] supply = new SupplyDto[latest_year-older_year+1];
      
      //SupplyDto Index선언
      int index=0;
      
      for(int i=older_year;i<=latest_year;i++) {
    	  
    	  //제일 오래된 연도부터 연도별 공급현황 가져오기
         List<HousesupplyEntity>test = iFinanceService.getyearTotal(i);
         System.out.println(test.toString());
         int total_amount=0;
         int housefund=0;
         int year=0;
         int kb=0;
         int woori=0;
         int sh=0;
         int city=0;
         int hana=0;
         int nh=0;
         int keb=0;
         int etc=0;
         
         
         List<Map<String,String>> detail_amount = new LinkedList<>();
         Map<String,String> map = new HashMap<>();
         
         //찾은 연도의 월별 정보를 가져오기
         for(int month=0;month<test.size();month++) {
            year=test.get(month).getYear();
            
            
        /*              정보를 가져와 가공하여 금액을 누적.                */
               String Housefund=test.get(month).getHousefund();
               Housefund=Housefund.replace(",","");
               total_amount+=Integer.parseInt(Housefund);
               housefund+=Integer.parseInt(Housefund);
            

               String KB=test.get(month).getKb();
               KB=KB.replace(",","");
               kb+=Integer.parseInt(KB);
               total_amount+=Integer.parseInt(KB);
               
               String Woori=test.get(month).getWoori();
               Woori=Woori.replace(",","");
               woori+=Integer.parseInt(Woori);
               total_amount+=Integer.parseInt(Woori);
               
               String Sh=test.get(month).getSh();
               Sh=Sh.replace(",","");
               sh+=Integer.parseInt(Sh);
               total_amount+=Integer.parseInt(Sh);
               
               String City=test.get(month).getCity();
               City=City.replace(",","");
               city+=Integer.parseInt(City);
               total_amount+=Integer.parseInt(City);
               
               String Hana=test.get(month).getHana();
               Hana=Hana.replace(",","");
               hana+=Integer.parseInt(Hana);
               total_amount+=Integer.parseInt(Hana);
               
               String Nh=test.get(month).getNh();
               Nh=Hana.replace(",","");
               nh+=Integer.parseInt(Nh);
               total_amount+=Integer.parseInt(Nh);
               
               String Keb=test.get(month).getKeb();
               Keb=Hana.replace(",","");
               keb+=Integer.parseInt(Keb);
               total_amount+=Integer.parseInt(Keb);
               
               String Etc=test.get(month).getEtc();
               Etc=Hana.replace(",","");
               etc+=Integer.parseInt(Etc);
               total_amount+=Integer.parseInt(Etc);
   

         }
         map.put("주택도시기금",housefund+"");
         map.put("국민은행", kb+"");
         map.put("우리은행", woori+"");
         map.put("신한은행", sh+"");
         map.put("시티은행", city+"");
         map.put("하나은행", hana+"");
         map.put("농협은행", nh+"");
         map.put("KEB은행", keb+"");
         map.put("기타은행", etc+"");
         
         
         
         detail_amount.add(map);
         
         supply[index]= new SupplyDto(year+"년", total_amount+"", detail_amount);
         
         System.out.println(supply[index].toString());
         index++;
      }
      
      for(int i=0;i<supply.length;i++) {
         System.out.println(supply[i].toString());
      }
      
      
      
      return Gson().toJsonTree(supply).toString();
      
      
   }

}