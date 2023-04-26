package com.changjun.board.service.implement;

import org.hibernate.validator.cfg.defs.pl.REGONDef;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.changjun.board.dto.request.user.PostUserRequestDto;
import com.changjun.board.dto.response.ResponseDto;
import com.changjun.board.entity.UserEntity;
import com.changjun.board.repository.UserRepository;
import com.changjun.board.service.UserService;

@Service
public class UserServiceImplement implements UserService{
    private UserRepository userRepository;
    public UserServiceImplement(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    
    @Override
    public ResponseEntity<ResponseDto> postUser(PostUserRequestDto dto){
        ResponseDto responseBody = null;
        String email = dto.getUserEmail();
        String nickname=dto.getUserNickname();
        String phoneNumber=dto.getUserPhoneNumber();
        try{ 
            // TODO: 이메일 중복 반환
            boolean hasEmail = userRepository.existsByEmail(email);
            if(hasEmail){
                responseBody=new ResponseDto("EU", "Existent User Email");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody); // 이 구조가 중요함 리턴시에 ResponseEntity에 status까지 포함시켜줘야함. 그리고 바디.

            }
            // TODO: 닉네임 중복 반환
            boolean hasNickname = userRepository.existsByNickname(nickname);
            if(hasNickname){
                responseBody=new ResponseDto("EN", "Existent User Nickname");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody); // 이 구조가 중요함 리턴시에 ResponseEntity에 status까지 포함시켜줘야함. 그리고 바디.

            }

            // TODO: 휴대전화 중복 반환
            boolean hasPhoneNumber = userRepository.existsByPhoneNumber(phoneNumber);
            if(hasPhoneNumber){
                responseBody=new ResponseDto("EP", "Existent User Phone Number");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
            }
            // 유저 레코드 삽입 
            UserEntity userEntity = new UserEntity(dto);//성공했을 경우 dto 를 유저 엔티티에 넣어서 저장을해준다.
            userRepository.save(userEntity);
            responseBody = new ResponseDto("SU", "Success");
            


        } catch(Exception exception){
             // TODO: 데이터베이스 오류
            exception.printStackTrace();
            responseBody = new ResponseDto("DE","Database Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
        }


        //*  성공 반환
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);

    }
}
