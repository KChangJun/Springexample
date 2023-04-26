package com.changjun.board.service;

import org.springframework.http.ResponseEntity;

import com.changjun.board.dto.request.user.PostUserRequestDto;
import com.changjun.board.dto.response.ResponseDto;

public interface UserService {

    public ResponseEntity<ResponseDto> postUser(PostUserRequestDto dto);
    
}
