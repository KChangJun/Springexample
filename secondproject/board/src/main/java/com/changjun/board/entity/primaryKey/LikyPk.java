package com.changjun.board.entity.primaryKey;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.Data;

@Data
//복합키에서 쓸 pk를 만든다. Serializable 을 구현한다.
public class LikyPk implements Serializable{
    
    @Column(name="board_number")
    private int boardNumber;

    @Column(name="user_email")
    private String userEmail;

}
