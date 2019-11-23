package com.kakao.kakaoexam.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private static final String[] EXCLUDE_PATHS = {
    
        "/test/**"
    };
 
    @Autowired
    private JwtInterceptor jwtInterceptor;
 
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                        .addPathPatterns("/**")
                        .excludePathPatterns(EXCLUDE_PATHS);
    }
}