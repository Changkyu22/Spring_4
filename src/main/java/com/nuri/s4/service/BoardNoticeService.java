package com.nuri.s4.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nuri.s4.dao.BoardNoticeDAO;
import com.nuri.s4.dao.NoticeFilesDAO;
import com.nuri.s4.model.BoardVO;
import com.nuri.s4.model.NoticeFilesVO;
import com.nuri.s4.util.FileSaver;
import com.nuri.s4.util.Pager;

@Service
public class BoardNoticeService implements BoardService {

	@Inject
	private BoardNoticeDAO boardNoticeDAO;
	
	@Inject
	private FileSaver fs;
	
	@Inject
	private NoticeFilesDAO noticeFilesDAO;
	
	
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
	public int boardWrite(BoardVO boardVO, MultipartFile [] file, HttpSession session) throws Exception {
		// server HDD save
		// 1. realPath
		String realPath = session.getServletContext().getRealPath("resources/upload/notice");
		int result = boardNoticeDAO.boardWrite(boardVO);
		System.out.println(boardVO.getNum());
		NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
//		for(MultipartFile multipartFile : file) {
//			
//			String fileName = fs.save(realPath, multipartFile);
//			noticeFilesVO.setFname(fileName);
//			noticeFilesVO.setOname(multipartFile.getOriginalFilename());
//			noticeFilesDAO.fileWrite(noticeFilesVO);
//		}
		return result;
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
