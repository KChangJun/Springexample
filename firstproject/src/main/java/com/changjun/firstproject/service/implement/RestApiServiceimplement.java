package com.changjun.firstproject.service.implement;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.changjun.firstproject.service.RestApiService;


@Service
public class RestApiServiceimplement implements RestApiService {  //구현체라고함

    @Override
    public String getMethod() {
        return "Return to Service Layer";
    
}
}
