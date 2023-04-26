package com.changjun.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.changjun.board.dto.request.user.PostUserRequestDto;
import com.changjun.board.dto.response.ResponseDto;
import com.changjun.board.service.UserService;

@RestController
@RequestMapping("/api/v1/user") //api에 v1에 user폴더
public class UserController {
    private UserService userService;
    
    @Autowired
    public UserController(UserService userService){
        this.userService=userService;

    }

    @PostMapping("")
    public ResponseEntity<ResponseDto> postUser(
        @Valid @RequestBody PostUserRequestDto requestBody){//성공 실패 여부를 ReponseDto의 형식으로 받음 
                                                        //requestbody로 body 받음 타입은 PostuserRequestDto 로 받고 이름을 requestbody로 설정함   
        
        ResponseEntity<ResponseDto> response = userService.postUser(requestBody);
        return response;
    }
    
}
