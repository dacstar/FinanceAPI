package com.kakao.kakaoexam.repository;

import org.springframework.data.repository.CrudRepository;

import com.kakao.kakaoexam.entity.HousesupplyEntity;

//���ñ���.csv ������ ó���ϱ� ����  DAO Interface
public interface HousesupplyRespository extends CrudRepository<HousesupplyEntity,Long> {
	

}
