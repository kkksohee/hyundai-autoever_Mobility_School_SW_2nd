package com.hd.sample_jpa_mysql_0605.controller;

import com.hd.sample_jpa_mysql_0605.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@Slf4j  //Log 메시지 출력을 위한 어노테이션
@RestController  //ResAPI (GET, POST, DELETE, PUT), JSON역직렬화 해줌
@RequiredArgsConstructor //생성자를 통한 의존성 주입을 받기 위해 생성자를 자동 생성
@CrossOrigin(origins = "http://localohst:5173") //
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    //게시글 등록: 입력(boardWriteDto) 반환(boolean)

    //게시글 수정: 입력(boardId,boardWriteDto),반환(boolean)

    //게시글 삭제: 입력(id),반환(boolean)

    //게시글 검색:입력(제목에 포함된 문자열) 반환(List<BesDtd)

    //게시글 전체조회:입력(없음),반환(List<boardResDtd)

    //게시글 단건조회:(id), 반환(BoardResDto)

    //게시글 페이징(페이지 번호, 페이지 사이즈)


}
