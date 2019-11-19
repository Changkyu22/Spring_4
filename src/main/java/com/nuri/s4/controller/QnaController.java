package com.nuri.s4.controller;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nuri.s4.model.BoardVO;
import com.nuri.s4.service.BoardQnaService;
import com.nuri.s4.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Inject
	private BoardQnaService boardQnaService;
	
	@RequestMapping(value = "qnaReply", method = RequestMethod.GET)
	public ModelAndView boardReply(BoardVO boardVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", boardVO);
		mv.setViewName("board/boardReply");
		return mv;
	}
	
	@RequestMapping(value = "qnaReply", method = RequestMethod.POST)
	public ModelAndView boardReply2(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = boardQnaService.boardReply(boardVO);
		if(result>0) {
			mv.setViewName("redirect:./qnaList");
		}else {
			mv.addObject("msg", "Fail");
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/common_result");
		}
		return mv;
	}
	
	@RequestMapping(value = "qnaDelete", method = RequestMethod.GET)
	public ModelAndView boardDelete(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = boardQnaService.boardDelete(boardVO);
		if(result>0) {
			mv.setViewName("redirect:./qnaList");
		}else {
			mv.addObject("msg", "Delete Fail");
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/common_result");
		}
		return mv;
	}
	
	@RequestMapping(value = "qnaUpdate", method = RequestMethod.GET)
	public ModelAndView boardUpdate(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardVO = boardQnaService.boardSelect(boardVO);
		mv.addObject("dto", boardVO);
		mv.addObject("PageName", "QnA Board");
		mv.addObject("board", "qna");
		mv.setViewName("board/boardWrite");
		return mv;
	}
	@RequestMapping(value = "qnaUpdate", method = RequestMethod.POST)
	public ModelAndView boardUpdate2(BoardVO boardVO)throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = boardQnaService.boardUpdate(boardVO);
		if(result>0) {
			mv.setViewName("redirect:./boardList");
		}else {
			mv.addObject("msg", "Write Fail");
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/common_result");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "qnaSelect", method = RequestMethod.GET)
	public ModelAndView boardSelect(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardVO = boardQnaService.boardSelect(boardVO);
		mv.addObject("PageName", "QnA Board");
		mv.addObject("board", "qna");
		mv.addObject("dto", boardVO);
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	@RequestMapping(value = "qnaList", method = RequestMethod.GET)
	public ModelAndView boardList(Pager pager)throws Exception{
		List<BoardVO> ar = boardQnaService.boardList(pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.addObject("PageName", "QnA Board");
		mv.addObject("board", "qna");
		mv.setViewName("board/boardList");
		return mv;
	}
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.GET)
	public ModelAndView boardWrite()throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("PageName","QnA Board");
		mv.addObject("board", "qna");
		mv.setViewName("board/boardWrite");
		return mv;
	}
	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public ModelAndView boardWrite(BoardVO boardVO, HttpSession session)throws Exception{
		int result = boardQnaService.boardWrite(boardVO, session);
		ModelAndView mv = new ModelAndView();
		if(result>0) {
			mv.setViewName("redirect:./qnaList");
		}else{
			mv.addObject("msg", "QnA Write Fail");
			mv.addObject("path", "qnaList");
			mv.setViewName("common/common_result");
		}
		return mv;
	}
	
	
	
}