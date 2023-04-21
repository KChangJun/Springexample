package com.changjun.firstproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**").allowedMethods(null).allowedOrigins("*");
        //어떠한 path 에 대해 허용을 해 줄것인지 "/**는 모든 path에 대해 허용", 
        //allowedmethods는 어떤 메소드에 대해 허용 해줄것인지 "*"는 모든 메서드
        //allowedOrigins 는 어떤 오리진에 대해 허용할것인지 Origin이란 프로토콜, 호스트, 포트 번호
    }

}
