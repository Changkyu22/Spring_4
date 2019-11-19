package com.nuri.s4.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nuri.s4.model.BoardNoticeVO;
import com.nuri.s4.model.BoardQnaVO;
import com.nuri.s4.model.BoardVO;
import com.nuri.s4.service.BoardNoticeService;
import com.nuri.s4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Inject
	private BoardNoticeService boardNoticeService;
	
	@RequestMapping(value = "noticeDelete", method = RequestMethod.GET)
	public ModelAndView boardDelete(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = boardNoticeService.boardDelete(boardVO);
		if(result>0) {
			mv.setViewName("redirect:./noticeList");
		}else {
			mv.setViewName("common/common_result");
			mv.addObject("msg", "Delete Fail");
			mv.addObject("path", "./noticeList");
		}
		return mv;
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.GET)
	public ModelAndView boardUpdate(BoardVO boardVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardVO = boardNoticeService.boardSelect(boardVO);
		mv.addObject("PageName","Notice Board");
		mv.addObject("board", "notice");
		mv.addObject("dto", boardVO);
		mv.setViewName("board/boardUpdate");
		return mv;
	}
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public ModelAndView boardUpdate2(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = boardNoticeService.boardUpdate(boardVO);
		if(result>0) {
			mv.setViewName("redirect:./noticeList");
		}else {
			mv.addObject("path", "./noticeList");
			mv.addObject("msg", "Update Fail");
			mv.setViewName("common/common_result");
		}
		return mv;
		
	}
	
	@RequestMapping(value = "noticeSelect", method = RequestMethod.GET)
	public ModelAndView boardSelect(BoardVO boardVO) throws Exception{
		boardVO = boardNoticeService.boardSelect(boardVO);
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", boardVO);
		mv.addObject("PageName","Notice Board");
		mv.addObject("board", "notice");
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	@RequestMapping(value = "noticeList", method = RequestMethod.GET)
	public ModelAndView boardList(Pager pager)throws Exception{
		List<BoardVO> ar = boardNoticeService.boardList(pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.addObject("PageName","Notice Board");
		mv.addObject("board", "notice");
//		BoardVO boardVO = new BoardQnaVO();
//		BoardQnaVO boardQnaVO = (BoardQnaVO)boardVO;
		mv.setViewName("board/boardList");
		return mv;
	}
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public ModelAndView boardWrite()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("PageName","Notice Board");
		mv.addObject("board", "notice");
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public ModelAndView boardWrite(BoardVO boardVO, HttpSession session)throws Exception{
		int result = boardNoticeService.boardWrite(boardVO, session);
		ModelAndView mv = new ModelAndView();
		if(result>0) {
			mv.setViewName("redirect:./noticeList");
		}else {
			mv.addObject("msg", "Write Fail");
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/common_result");
		}
		return mv;
		
	}
	
	
}
