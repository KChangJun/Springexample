package com.changjun.board.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.changjun.board.dto.request.user.PostUserRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "User")//어노테이션 설정해주고 해당 테이블을 jpa 내에서 어떤 방식으로 부를 지 결정
@Table(name = "User")
public class UserEntity {
    @Id
    private String email;
    private String password;
    private String nickname;
    private String phoneNumber;
    private String address;
    private Boolean consentPersonalInformation;
    private String profileImageUrl;

    public UserEntity(PostUserRequestDto dto){
        this.email=dto.getUserEmail();
        this.password=dto.getUserPassword();
        this.nickname=dto.getUserNickname();
        this.phoneNumber=dto.getUserPhoneNumber();
        this.address=dto.getUserAddress();
        this.consentPersonalInformation=true;
        this.profileImageUrl=dto.getUserProfileImageUrl();
    }
}
