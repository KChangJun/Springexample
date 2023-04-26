package com.changjun.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.changjun.board.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> { // JpaRepository를 확장해야함 , 어떤 entity 쓰는지, 그리고
                                                                            // pk 의 타입
    public boolean existsByEmail(String email);
    public boolean existsByNickname(String nickname);
    public boolean existsByPhoneNumber(String phoneNumber);
}
