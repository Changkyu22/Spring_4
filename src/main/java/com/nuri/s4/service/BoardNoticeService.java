package com.nuri.s4.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nuri.s4.dao.BoardNoticeDAO;
import com.nuri.s4.model.BoardVO;
import com.nuri.s4.util.Pager;
import com.nuri.s4.util.fileSaver;

@Service
public class BoardNoticeService implements BoardService {

	@Inject
	private BoardNoticeDAO boardNoticeDAO;
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePage(boardNoticeDAO.boardCount(pager));
		return boardNoticeDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		return boardNoticeDAO.boardSelect(boardVO);
	}

	@Override
	public int boardWrite(BoardVO boardVO, HttpSession session) throws Exception {
		// server HDD save
		// 1. realPath
		String realPath = session.getServletContext().getRealPath("resources/upload/notice");
		System.out.println(realPath);
		
		fileSaver fs = new fileSaver();
		String fileName = fs.save(realPath, boardVO.getFile());
		boardVO.setFileName(fileName);
		boardVO.setOriginalName(boardVO.getFile().getOriginalFilename());
		System.out.println(fileName);
		return boardNoticeDAO.boardWrite(boardVO);
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		return boardNoticeDAO.boardUpdate(boardVO);
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		return boardNoticeDAO.boardDelete(boardVO);
	}

}
