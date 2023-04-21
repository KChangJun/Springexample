package com.changjun.firstproject.service.implement;

import java.io.Console;

import org.springframework.stereotype.Component;

import com.changjun.firstproject.service.MainService;

import lombok.extern.apachecommons.CommonsLog;


@Component
public class MainServiceImplement implements MainService{

    @Override
    public String hello() {
        return "hello 1234";
        
    }
    
}
