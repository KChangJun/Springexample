package com.changjun.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.changjun.board.entity.LikyEntity;
import com.changjun.board.entity.primaryKey.LikyPk;

@Repository
public interface LikyRepository extends JpaRepository<LikyEntity,LikyPk> {// 복합키는 기본형을 지정해줄수 없고 pk 에 대한 타입을 만들어주어야한다.
    
}
