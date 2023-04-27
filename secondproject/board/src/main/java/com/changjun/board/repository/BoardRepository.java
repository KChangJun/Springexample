package com.changjun.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.changjun.board.entity.BoardEntity;
@Repository
public interface BoardRepository extends JpaRepository<BoardEntity,Integer>{
    
}
