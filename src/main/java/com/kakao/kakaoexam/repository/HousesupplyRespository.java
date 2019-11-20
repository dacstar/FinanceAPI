package com.kakao.kakaoexam.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kakao.kakaoexam.entity.HousesupplyEntity;

//���ñ���.csv ������ ó���ϱ� ����  DAO Interface
public interface HousesupplyRespository extends CrudRepository<HousesupplyEntity,Long> {
	
	
	List<HousesupplyEntity> findByyear(long year);
	 
	
}
