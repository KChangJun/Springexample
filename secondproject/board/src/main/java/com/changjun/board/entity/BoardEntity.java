package com.changjun.board.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.changjun.board.dto.request.board.PostBoardRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Board")
@Table(name="Board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//필드의 값을 자동으로 사용
    private int boardNumber;
    private String writerEmail;
    private String title;
    private String content;
    private String boardImageUrl;
    private String writeDatetime;
    private int viewcount;
    


public BoardEntity(PostBoardRequestDto dto){
    Date now = new Date(); // 시간 데이터 타입 변수 설정
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//시간 데이터 타입 형태 설정
    String writeDatetime = simpleDateFormat.format(now);//형태안에 데이터타입 변수 넣음
    this.writerEmail= dto.getBoardWriterEmail();
    this.title = dto.getBoardTitle();
    this.content = dto.getBoardContent();
    this.boardImageUrl = dto.getBoardImageUrl();
    this.writeDatetime = writeDatetime;
    this.viewcount = 0;
} 
}