package com.nuri.s4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.nuri.s4.model.BoardVO;
import com.nuri.s4.service.BoardNoticeService;
import com.nuri.s4.util.Pager;

@RestController
public class JsonController {
	
	@Autowired
	private BoardNoticeService boardNoticeService;

	@GetMapping(value = "/getJson3")
	public List<BoardVO> getJson3(Pager pager)throws Exception {
		
		return boardNoticeService.boardList(pager);
	}
	
	
	
	@GetMapping(value = "/getJson2")
	@ResponseBody
	public BoardVO getJson2(BoardVO boardVO) throws Exception{
		boardVO = boardNoticeService.boardSelect(boardVO);
		
		return boardVO;
	}
	
	@GetMapping(value = "/getJson1")
	public ModelAndView getJson1() throws Exception {
		
		// name = iu, age = 27
		String jmsg = "{\"name\":\"iu\", \"age\"=27}";
		System.out.println(jmsg);
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", jmsg);
		mv.setViewName("common/common_ajaxResult");
		return mv;
	}
}
