package com.changjun.board.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.stereotype.Service;

import com.changjun.board.dto.request.board.PatchBoardRequestDto;
import com.changjun.board.dto.request.board.PostBoardRequestDto;
import com.changjun.board.dto.response.ResponseDto;
import com.changjun.board.dto.response.board.GetBoardListResponseDto;
import com.changjun.board.dto.response.board.GetBoardResponseDto;
import com.changjun.board.entity.BoardEntity;
import com.changjun.board.repository.BoardRepository;
import com.changjun.board.repository.UserRepository;
import com.changjun.board.service.BoardService;
import com.mysql.cj.protocol.x.Ok;


@Service
public class BoardServiceImplement implements BoardService{
    private UserRepository userRepository;
    private BoardRepository boardRepository;
    @Autowired
    public BoardServiceImplement(UserRepository userRepository,BoardRepository boardRepository){
        this.userRepository = userRepository;
        this.boardRepository = boardRepository;
    }



    @Override
    public ResponseEntity<ResponseDto> postBoard(PostBoardRequestDto dto) {
        // TODO:게시물 작성
        String boardWriterEmail = dto.getBoardWriterEmail();
        ResponseDto body = null;
        try{//todo: 존재 하지 않는 유저 오류 반환 
            boolean existedUserEmail = userRepository.existsByEmail(boardWriterEmail);
            if(!existedUserEmail){
                ResponseDto errorBody = new ResponseDto("nu","NON-Existent User Email");

                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorBody);
            }
            BoardEntity boardEntity = new BoardEntity(dto);
            boardRepository.save(boardEntity);
            body = new ResponseDto("SU","Success");

        }catch (Exception exception){
            //TODO : 데이터베이스 오류 반환
            exception.printStackTrace();
            ResponseDto errorBody = new ResponseDto("DE", "Database Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorBody);
        }

        // TODO: 성공 반환
        return ResponseEntity.status(HttpStatus.OK).body(body);

    }

    @Override
    public ResponseEntity<? super GetBoardListResponseDto> getBoard(Integer BoardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoard'");
    }

    @Override
    public ResponseEntity<? super GetBoardListResponseDto> getBoardList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoardList'");
    }

    @Override
    public ResponseEntity<? super GetBoardListResponseDto> getBoardTop3() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoardTop3'");
    }

    @Override
    public ResponseEntity<ResponseDto> patchBoard(PatchBoardRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchBoard'");
    }

    @Override
    public ResponseEntity<ResponseDto> deleteBoard(String userEmail, Integer boardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBoard'");
    }

    @Override
    public ResponseEntity<ResponseDto> patchBoard() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchBoard'");
    }


}
