package com.kakao.kakaoexam.serviceImpl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakao.kakaoexam.Dto.KebDto;
import com.kakao.kakaoexam.Dto.MaxsupplyDto;
import com.kakao.kakaoexam.Dto.SupplyDto;
import com.kakao.kakaoexam.entity.HousesupplyEntity;
import com.kakao.kakaoexam.repository.HousesupplyRespository;
import com.kakao.kakaoexam.service.IFinanceService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import ch.qos.logback.core.net.server.ConcurrentServerRunner;
@Service
public class FinanceService implements IFinanceService{
	
	
	
	@Autowired
	private HousesupplyRespository housesupplyRespository;
	
	//은행갯수
    private final int bank= 11;

    
	@Override
	public int putDate() {
		// TODO Auto-generated method stub
		int status=1;
		
		//CSV 파일 입력 받아서 내용을  HousesupplyEntity에 저장
		try {
			BufferedReader data = new BufferedReader(new FileReader("src/main/resources/static/사전과제3.csv"));
			
			while (data.readLine() != null) {
                
				CSVReader reder = new CSVReader(data);
				List<String[]> list = reder.readAll();
				

				for(String[] str : list) {
					String[] str2= new String[bank];
					for(int i=0;i<bank;i++) {
					str2[i]=str[i];
					    System.out.print(str2[i]+" ");					
					}
					System.out.println();
					
                    housesupplyRespository.save(new HousesupplyEntity(str2));
                }

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status=0;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	//
	@Override
	public List<HousesupplyEntity> getSupplyList() {
		// TODO Auto-generated method stub
		
		// JPA Select
		
		//when
        Iterable<HousesupplyEntity> supplyInfIter = housesupplyRespository.findAll();
       
        
        //then
        HousesupplyEntity h; 
        
        List<HousesupplyEntity> supplyInfList = new LinkedList<>();
        
        
        supplyInfIter.forEach(supplyInfList::add);
		
//        for(int i=0;i<supplyInfList.size();i++) {
//        	System.out.println(supplyInfList.get(i).toString());
//        }
        
		return supplyInfList;
	}
	
	@Override
	//연도 정보를 통해 연도별 공급 현황가져오기
	public List<HousesupplyEntity> getyearTotal(int year) {
		// TODO Auto-generated method stub
		 List<HousesupplyEntity> supplyInfList = housesupplyRespository.findByyear(year);

		return supplyInfList;
	}
	
	
	
	//전체 주택공급현황을 구해주는 매소드
	@Override
	public List<SupplyDto> getTotalsupply() {
		// TODO Auto-generated method stub
		 int older_year=Integer.MAX_VALUE;
	     int latest_year=Integer.MIN_VALUE;
	      List<SupplyDto> supplylist = new LinkedList<>();
	      
	      
	      /*                    전체 주택 공급현황 가져오기                     */
	      List<HousesupplyEntity> list = this.getSupplyList();
	      
	      for(int i=0;i<list.size();i++) {
	    	  //제일 오래된 연도 구하기
	         older_year=Math.min(older_year, list.get(i).getYear());
	         //제일 최신 연도 구하기
	         latest_year=Math.max(older_year, list.get(i).getYear());
	      }
	      
	      System.out.println(older_year);
	      System.out.println(latest_year);
	      
	      
	    
	      
	      for(int i=older_year;i<=latest_year;i++) {
	    	  
	    	  //제일 오래된 연도부터 연도별 공급현황 가져오기
	         List<HousesupplyEntity>test = this.getyearTotal(i);
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
	         
	         
	         List<Map<String,Integer>> detail_amount = new LinkedList<>();
	         Map<String,Integer> map = new HashMap<>();
	         
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
	         map.put("주택도시기금",housefund);
	         map.put("국민은행", kb);
	         map.put("우리은행", woori);
	         map.put("신한은행", sh);
	         map.put("시티은행", city);
	         map.put("하나은행", hana);
	         map.put("농협은행", nh);
	         map.put("외환은행", keb);
	         map.put("기타은행", etc);
	         
	         
	         //은행별 공급량을 정리하기위한 List 
	         detail_amount.add(map);
	        
	         
	         //주택공급현황 배열 출력을 위한  배열 생성자.
	         supplylist.add(new SupplyDto(year+"년", total_amount, detail_amount));
	
	      }
	     
	
		return supplylist;
	}
	@Override
	public List<MaxsupplyDto>  getMaxsupply() {
		// TODO Auto-generated method stub
		int Maxsupply=Integer.MIN_VALUE;
		int value=Integer.MIN_VALUE;
		String bank="";
		/* 전체 주택 공급량을 가져온다 */
		List<SupplyDto> supplylist=this.getTotalsupply();
		
		for(int i=0;i<supplylist.size();i++) {
			System.out.println(supplylist.get(i).toString());
		}
		List<MaxsupplyDto> maxsupplylist = new LinkedList<>();
		
		System.out.println(supplylist.size());
		
		
		for (SupplyDto supplydto : supplylist) {
			
			List<Map<String,Integer>> detail_amount = supplydto.getDetail_amount();
			
           			
			for(Map<String,Integer> map : detail_amount) {
		            
				for (String key : map.keySet()){
                    
					if(key.contains("주택도시기금"))
						continue;
					
			       value = Math.max(map.get(key), value);
			       
			       if(value != Maxsupply) {
			    	   Maxsupply =value;
			    	   bank =  key;
			       }
			    }
			}
			
			MaxsupplyDto maxsupplydto = new MaxsupplyDto(supplydto.getYear(),bank);
			maxsupplylist.add(maxsupplydto);
		}
		
		
		
		
		return maxsupplylist;
	}
	@Override
	public List<KebDto> getKebavg() {
		// TODO Auto-generated method stub
		/* 전체 주택 공급량을 가져온다 */
		List<SupplyDto> supplylist=this.getTotalsupply();
		List<KebDto> keblist = new LinkedList<>();
		double Maxamount=Integer.MIN_VALUE;
		double Minamount=Integer.MAX_VALUE;
		double max=Integer.MIN_VALUE;
		double min=Integer.MAX_VALUE;
		int maxyear=0;
		int minyear=0;
		for (SupplyDto supplydto : supplylist) {
			double kebavg=0;
			double kebamount=0;
			//평균 월을 세기위한 카운터
			int count=0;
			
			List<Map<String,Integer>> detail_amount = supplydto.getDetail_amount();
			for(Map<String,Integer> map : detail_amount) {
	            
				for (String key : map.keySet()){
                    
					if(key.contains("외환은행")) {
				          		count++;
				          		kebamount+=map.get(key);
						
					}else {
						continue;
					}
			    }
			}
			kebavg=kebamount/count;
			max=Math.max(Maxamount, kebavg);
			min=Math.min(Minamount, kebavg);
			
			if(max !=Maxamount) {
				Maxamount=max;
				String year=supplydto.getYear().replace("년", "");
				maxyear=Integer.parseInt(year);
			}else if(min !=Minamount) {
				Minamount=min;
				String year=supplydto.getYear().replace("년", "");
				minyear=Integer.parseInt(year);
				
			}
			keblist.add(new KebDto(maxyear,minyear,Math.round(Maxamount),Math.round(Minamount)));
			
			
		}
		
		for(KebDto k: keblist) {
			System.out.println(k.toString());
		}
		
		return keblist;
	}
	
	
	

}
