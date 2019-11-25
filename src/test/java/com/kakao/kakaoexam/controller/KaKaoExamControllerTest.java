package com.kakao.kakaoexam.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.kakao.kakaoexam.entity.HousesupplyEntity;
import com.kakao.kakaoexam.repository.HousesupplyRespository;
import com.kakao.kakaoexam.service.IFinanceService;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class KaKaoExamControllerTest{

    @Autowired
    private IFinanceService iFinanceService;
    @Autowired
    private HousesupplyRespository housesupplyRespository;

    private static boolean checkInit = false;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void init() {
        boolean check =iFinanceService.putDate();
        if(!checkInit){
            return ;
        }
        Iterable<HousesupplyEntity> Houseit = housesupplyRespository.findAll();
        List<HousesupplyEntity> Houselsit = StreamSupport.stream(Houseit.spliterator(), false).collect(Collectors.toList());
        assertThat(Houselsit, is(false));

        log.info("init");
        checkInit = true;


        return ;
    }



    @Test
    public void exam() throws Exception {
        mockMvc.perform(get("/test"))
        .andDo(print())
        .andExpect(status().isOk());
    }

    @Test
    public void exam2() throws Exception {
        mockMvc.perform(get("/test2"))
        .andDo(print())
        .andExpect(status().isOk());
       
    }

    @Test
    public void exam3() throws Exception {
        mockMvc.perform(get("/test3"))
        .andDo(print())
        .andExpect(status().isOk());
       
    }

    @Test
    public void exam4() throws Exception {
        mockMvc.perform(get("/test4/국민은행/2"))
        .andDo(print())
        .andExpect(status().isOk());
      
    }



}