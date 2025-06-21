package com.hd.sample_jpa_mysql_0605.controller;

import com.hd.sample_jpa_mysql_0605.dto.BoardResDto;
import com.hd.sample_jpa_mysql_0605.dto.BoardWriteDto;
import com.hd.sample_jpa_mysql_0605.dto.PageResDto;
import com.hd.sample_jpa_mysql_0605.entity.Board;
import com.hd.sample_jpa_mysql_0605.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j  //Log 메시지 출력을 위한 어노테이션
@RestController  //ResAPI (GET, POST, DELETE, PUT), JSON역직렬화 해줌
@RequiredArgsConstructor //생성자를 통한 의존성 주입을 받기 위해 생성자를 자동 생성
@CrossOrigin(origins = "http://localhost:5173") //
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    //게시글 등록: 입력(boardWriteDto) 반환(boolean)
    @PostMapping("/new")
    public ResponseEntity<Boolean> boardNew(@RequestBody BoardWriteDto boardWriteDto){
        return ResponseEntity.ok(boardService.addBoard(boardWriteDto));
    }
    @PutMapping("/update/{id}")
    //게시글 수정: 입력(boardId,boardWriteDto),반환(boolean)
    public ResponseEntity<Boolean> boardModify(@PathVariable("id") Long boardId, @RequestBody BoardWriteDto boardWriteDto){
        return ResponseEntity.ok(boardService.modifyBoard(boardId, boardWriteDto));
    }
    @DeleteMapping("/delete/{id}")
    //게시글 삭제: 입력(id),반환(boolean)
    public ResponseEntity<Boolean> boardDelete(@PathVariable("id") Long boardId){
        return ResponseEntity.ok(boardService.deleteBoard(boardId));
    }
    //게시글 검색:입력(제목에 포함된 문자열) 반환(List<BesDtd)
    @GetMapping("/search")
    public ResponseEntity<List<BoardResDto>> boardSearch(@RequestParam String title){
        List<BoardResDto> boardResDto =boardService.searchBoard(title);
        return ResponseEntity.ok(boardResDto);
    }
    //게시글 전체조회:입력(없음),반환(List<boardResDtd)
    @GetMapping("/list")
    public ResponseEntity<List<BoardResDto>> boardList(){
        return ResponseEntity.ok(boardService.getBoardList());
    }
    //게시글 단건조회:(id), 반환(BoardResDto)
    @GetMapping("/id/{boardId}")
    public ResponseEntity<BoardResDto> boardId(@PathVariable Long boardId){
        BoardResDto boardResDto = boardService.getBoardId(boardId);
        return ResponseEntity.ok(boardResDto);
    }
    //게시글 페이징(페이지 번호, 페이지 사이즈)
    @GetMapping("/page")
    public ResponseEntity<PageResDto<BoardResDto>> boardPage(@RequestParam Integer page, @RequestParam Integer pageSize){
        PageResDto<BoardResDto> boardPage = boardService.getBoardPageList(page, pageSize);
        return ResponseEntity.ok(boardPage);
    }


}
