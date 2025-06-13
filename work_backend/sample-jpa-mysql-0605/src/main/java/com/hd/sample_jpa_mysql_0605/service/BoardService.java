package com.hd.sample_jpa_mysql_0605.service;

import com.hd.sample_jpa_mysql_0605.dto.BoardResDto;
import com.hd.sample_jpa_mysql_0605.dto.BoardWriteDto;
import com.hd.sample_jpa_mysql_0605.dto.PageResDto;
import com.hd.sample_jpa_mysql_0605.entity.Board;
import com.hd.sample_jpa_mysql_0605.entity.Member;
import com.hd.sample_jpa_mysql_0605.repository.BoardRepository;
import com.hd.sample_jpa_mysql_0605.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    //게시글 등록: 반환값 Boolean
    public boolean addBoard(BoardWriteDto boardWriteDto){
        try{
            Board board = convertDtoToEntity(boardWriteDto);
            boardRepository.save(board);
            return true;
        } catch (Exception e) {
            log.error("게시글 등록 실패!: {}",e.getMessage());
            return false;
        }
    }

    //게시글 전체 조회: 반환값 List<Board>
    public List<BoardResDto> getBoardList(){
        List<Board> boards = boardRepository.findAll();
        List<BoardResDto> boardResDto = new ArrayList<>();
        for(Board board : boards){
            boardResDto.add(convertEntityToDto(board));
        }return boardResDto;
    }

    //게시글 단건 조회: 입력은 게시글 ID,반환값 Board
    public BoardResDto getBoardId(Long boardId){
        Board board = boardRepository.findById(boardId)
                .orElseThrow(()-> new RuntimeException("해당 게시글이 없습니다."));
        BoardResDto boardResDto = convertEntityToDto(board);
        return boardResDto;


    }
    //게시글 수정: 반환값 Boolean
    public boolean modifyBoard(Long boardId, BoardWriteDto boardWriteDto){
        try{
            Board board = boardRepository.findById(boardId)
                    .orElseThrow(()-> new RuntimeException("해당 게시글이 없습니다."));
            Member member = memberRepository.findByEmail(boardWriteDto.getEmail())
                    .orElseThrow(()-> new RuntimeException("해당 회원이 존재하지 않습니다."));
            board.setTitle(boardWriteDto.getTitle());
            board.setContent(board.getContent());
            board.setImage(boardWriteDto.getImage());
            board.setMember(member); // 왜 하지?
            boardRepository.save(board);
            return true;
        } catch (Exception e) {
            log.error("게시글 수정 실패: {}",e.getMessage());
            return false;
        }

    }

    //게시글 삭제: 반환값 Boolean
    public boolean deleteBoard(Long boardId){
        try{
            Board board = boardRepository.findById(boardId)
                    .orElseThrow(()-> new RuntimeException("해당 게시글이 없습니다."));
            boardRepository.delete(board);
            return true;
        } catch (Exception e) {
            log.error("게시글 삭제에 실패했습니다.: {}",e.getMessage());
        }return false;

    }

    //게시글 검색: 반환값 List<Board>
    public List<BoardResDto> searchBoard(String title){
        List<Board> boards = boardRepository.findByTitleContaining(title);
        List<BoardResDto> boardResDto = new ArrayList<>();
        for(Board board : boards){
            boardResDto.add(convertEntityToDto(board));
        }return boardResDto;
    }

    //게시글 페이징 처리
    private PageResDto<BoardResDto> getBoardPageList(Integer page, Integer pageSize){
        Page
    }

    //Entity -> DTO
    private BoardResDto convertEntityToDto(Board board){
        BoardResDto boardResDto = new BoardResDto();
        boardResDto.setBoardId(board.getId());
        boardResDto.setTitle(board.getTitle());
        boardResDto.setContent(board.getContent());
        boardResDto.setImage(board.getImage());
        boardResDto.setCreateTime(board.getCreateTime());
        boardResDto.setEmail(board.getMember().getEmail()); //연관관계 매핑으로 가져옴
        return boardResDto;
    }

    //DTO -> Entity
    private Board convertDtoToEntity(BoardWriteDto boardWriteDto){
        //이메일로 멤버 확인
        Member member = memberRepository.findByEmail(boardWriteDto.getEmail())
                .orElseThrow(()-> new RuntimeException("해당 회원이 존재하지 않습니다."));
        Board board = new Board();//빈 entity를 만듬
        board.setTitle(boardWriteDto.getTitle());
        board.setContent(boardWriteDto.getContent());
        board.setImage(boardWriteDto.getImage());
        board.setMember(member);
        return board;
    }
}
