package com.ezen.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO bDAO;
		
	@Override
	public void insertBoard(BoardVO board) {
		bDAO.insertBoard(board);
	}

	@Override
	public void updateBoard(BoardVO board) {
		bDAO.updateBoard(board);
	}

	@Override
	public void deleteBoard(BoardVO board) {
		bDAO.deleteBoard(board);
	}

	@Override
	public BoardVO getBoard(BoardVO board) {
		
		return bDAO.getBoard(board);
	}

	@Override
	public List<BoardVO> getBoardList() {
		
		return bDAO.getBoardList();
	}

}
