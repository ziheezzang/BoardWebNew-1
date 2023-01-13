package com.ezen.biz.board;

import java.util.*;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.biz.dto.BoardVO;

public class BoardServiceClient {

	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨테이너로부터 BoardServiceImpl 객체를 Lookup한다.
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		// 3. 게시글 등록 기능 테스트
		for(int i=1; i<=10; i++) {		
			BoardVO board = new BoardVO();
			board.setTitle("게시글 제목 " + i);
			board.setWriter("작성자 " + i);
			board.setContent("스프링 예제 게시글입니다.");
			
			boardService.insertBoard(board);
		}
		
		// 4. 게시글 목록 검색 기능 테스트
		List<BoardVO> boardList = boardService.getBoardList();
		for(BoardVO vo : boardList) {
			System.out.println(vo);
		}	
		// 5. Spring 컨테이너 종료
		container.close();
	}
}
