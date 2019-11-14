package com.nuri.s4.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.nuri.s4.dao.BoardQnaDAO;
import com.nuri.s4.model.BoardQnaVO;
import com.nuri.s4.model.BoardVO;
import com.nuri.s4.util.Pager;

@Service
public class BoardQnaService implements BoardService {
	
	@Inject
	private BoardQnaDAO boardQnaDAO;
	
	public int boardReply(BoardVO boardVO) throws Exception{
		BoardQnaVO parent = (BoardQnaVO)boardQnaDAO.boardSelect(boardVO);
		int result = boardQnaDAO.boardReplyUpdate(parent);
		// 1번째 방법
//		BoardQnaVO child = new BoardQnaVO();
//		child.setTitle(boardVO.getTitle());
//		child.setWriter(boardVO.getWriter());
//		child.setContents(boardVO.getContents());
//		child.setRef(parent.getRef());
//		child.setStep(parent.getStep()+1);
//		child.setDepth(parent.getDepth()+1);
//		boardQnaDAO.boardReplyUpdate(child);
//		return boardQnaDAO.boardReply(child);
		
		// 2번째 방법
		parent.setTitle(boardVO.getTitle());
		parent.setWriter(boardVO.getWriter());
		parent.setContents(boardVO.getContents());
		parent.setStep(parent.getStep()+1);
		parent.setDepth(parent.getDepth()+1);
		
		return boardQnaDAO.boardReply(parent);
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
	public int boardWrite(BoardVO boardVO) throws Exception {
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
