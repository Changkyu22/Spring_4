package com.nuri.s4.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nuri.s4.dao.BoardQnaDAO;
import com.nuri.s4.model.BoardQnaVO;
import com.nuri.s4.model.BoardVO;
import com.nuri.s4.util.Pager;

@Service
public class BoardQnaService implements BoardService {
	
	@Inject
	private BoardQnaDAO boardQnaDAO;
	
	public int boardReply(BoardVO boardVO) throws Exception{
		boardQnaDAO.boardReplyUpdate(boardVO);
		return boardQnaDAO.boardReply(boardVO);
	}
	
	@Override
	public List<BoardVO> boardList(Pager pager)throws Exception{
		pager.makeRow();
		pager.makePage(boardQnaDAO.boardCount(pager));
		return boardQnaDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		return boardQnaDAO.boardSelect(boardVO);
	}

	@Override
	public int boardWrite(BoardVO boardVO, MultipartFile file) throws Exception {
		return boardQnaDAO.boardWrite(boardVO);
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		return boardQnaDAO.boardUpdate(boardVO);
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		return boardQnaDAO.boardDelete(boardVO);
	}

}
