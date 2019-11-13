package com.nuri.s4.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.nuri.s4.dao.BoardQnaDAO;
import com.nuri.s4.model.BoardVO;
import com.nuri.s4.util.Pager;

@Service
public class BoardQnaService implements BoardService {
	
	@Inject
	private BoardQnaDAO boardQnaDAO;
	
	@Override
	public List<BoardVO> boardList(Pager pager)throws Exception{
		pager.makeRow();
		pager.makePage(boardQnaDAO.boardCount(pager));
		return boardQnaDAO.boardList(pager);
	}
	
}
