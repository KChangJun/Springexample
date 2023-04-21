package com.changjun.firstproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.changjun.firstproject.service.MainService;

@RestController
public class MainController {

    private final MainService mainService;
    @Autowired
    public MainController(MainService mainService){
        this.mainService=mainService; // 앞으로 나올것에 대해 미리 설정해놓는것. 아래에서 mainservice.hello 에서 보면
                                        // 따로 new 로 인스턴스를 생성하지 않앗음에도 바로 메인서비스의 헬로우가 사용 가능하다.
    }
    @GetMapping("/hello")
    public String hello(){
        return mainService.hello();
    }

}
