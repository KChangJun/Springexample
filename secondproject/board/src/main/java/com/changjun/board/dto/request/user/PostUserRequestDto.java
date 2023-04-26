package com.changjun.board.dto.request.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor


public class PostUserRequestDto { // 제약조건은 어노테이션으로 설정함
    @NotBlank // null 공란 띄워쓰기만으로 구성 안됨
    @Email // email 형식만 받음
    private String userEmail;
    @NotBlank
    private String userPassword;
    @NotBlank
    private String userNickname;
    @NotBlank
    @Pattern(regexp="^\\d{2,3}-\\d{3,4}-\\d{4}$")
    private String userPhoneNumber; // email은 모든 국가 형태가 공유기 때문에 어노테이션 지원이 되지만 전화번호는 아니기 때문에 따로 해줘야함-pattern 정규식을 써야함
    @NotBlank
    private String userAddress;
    private String userProfileImageUrl;

}
