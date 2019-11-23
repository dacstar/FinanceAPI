package com.kakao.kakaoexam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    @Autowired
    IMemberService iMemberService; 

    @PostMapping(value="/singup/{id}/{password}")
    public void singup( @PathVariable String id,
    @PathVariable String password) {

        iMemberService.singup(id,password);

        String token = jwtService.create("member", id, "user");

        System.out.println(token);
       
    }

    @PostMapping(value="/singin/{id}/{password}")
    public void singin(@PathVariable String id,
    @PathVariable String password,HttpServletResponse response) {

       String token= iMemberService.signin(id,password);
       response.setHeader("Authorization", token);
       
    }
}