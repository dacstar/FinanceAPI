package com.kakao.kakaoexam.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kakao.kakaoexam.entity.MemberEntity;

//DAO interface CRUD 구현
public interface MemberRespository extends CrudRepository<MemberEntity,String> {
	
    MemberRespository findByid(String id);
}
