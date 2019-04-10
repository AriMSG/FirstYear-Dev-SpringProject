package org.naver.com.controller;



import org.naver.com.service.BoardSerivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	@Autowired
	private BoardSerivce boardSerivce; 	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/board.do", method = RequestMethod.GET)
	public ModelAndView home() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("board");
		
		

		

		return mav;
	}
	
}
