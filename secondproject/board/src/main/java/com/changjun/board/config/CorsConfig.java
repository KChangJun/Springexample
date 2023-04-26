package com.changjun.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
// 다른 출처와 자원을 공유하려고 할 때의 정책 
    public void addCorsMappings(CorsRegistry registry) { //mapping 에 대한 규약 설정 어떤 접근에 대해 받아줄것인가. 
        registry.addMapping("/**").allowedMethods("*").allowedOrigins("*"); //메서드 오리진 패턴에 대해 다 받음.
    
    }

}
