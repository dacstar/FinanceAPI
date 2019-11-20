package com.kakao.kakaoexam.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kakao.kakaoexam.entity.HousesupplyEntity;

//주택금융.csv 데이터 처리하기 위한  DAO Interface
public interface HousesupplyRespository extends CrudRepository<HousesupplyEntity,Long> {
	
	
	List<HousesupplyEntity> findByyear(long year);
	 
	
}
