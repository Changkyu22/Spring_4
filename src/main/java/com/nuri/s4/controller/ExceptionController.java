package com.nuri.s4.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView getNull() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("common/common_500_error");
		return mv;
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView getNumber() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("common/common_500_error");
		return mv;
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ModelAndView getClient() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/common_400_error");
		return mv;
	}
	
	
}