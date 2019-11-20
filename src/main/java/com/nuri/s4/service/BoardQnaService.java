package com.nuri.s4.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nuri.s4.dao.BoardQnaDAO;
import com.nuri.s4.dao.QnaFilesDAO;
import com.nuri.s4.model.BoardQnaVO;
import com.nuri.s4.model.BoardVO;
import com.nuri.s4.model.QnaFilesVO;
import com.nuri.s4.util.FileSaver;
import com.nuri.s4.util.Pager;

@Service
public class BoardQnaService implements BoardService {
	
	@Inject
	private BoardQnaDAO boardQnaDAO;
	
	@Inject
	private QnaFilesDAO qnaFilesDAO;
	
	@Inject
	private FileSaver fs;
	
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
		boardVO = boardQnaDAO.boardSelect(boardVO);
		BoardQnaVO boardQnaVO = (BoardQnaVO)boardVO;
		
		List<QnaFilesVO> ar = qnaFilesDAO.fileList(boardVO.getNum());
		
		boardQnaVO.setFiles(ar);
		return boardQnaVO;
	}

	@Override
	public int boardWrite(BoardVO boardVO, MultipartFile [] file, HttpSession session) throws Exception {
		String realPath = session.getServletContext().getRealPath("resources/upload/qna");
		QnaFilesVO qnaFilesVO = new QnaFilesVO();
		int result = boardQnaDAO.boardWrite(boardVO);
		
		for(MultipartFile multipartFile : file) {
			String fileName = fs.save2(realPath, multipartFile);
			qnaFilesVO.setFname(fileName);
			qnaFilesVO.setOname(multipartFile.getOriginalFilename());
			qnaFilesVO.setNum(boardVO.getNum());
			qnaFilesDAO.fileWrite(qnaFilesVO);
		}
		return result;
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
