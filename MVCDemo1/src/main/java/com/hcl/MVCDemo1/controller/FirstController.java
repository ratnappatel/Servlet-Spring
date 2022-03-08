package com.hcl.MVCDemo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController {
	
	@RequestMapping(value="/")
	public String greet()
	{
		return "greet";
	}
	
	@RequestMapping(value="/thank")
	public ModelAndView respond()
	{
		String arr[]= {"ONE","TWO","THREE"};
		ModelAndView mv=new ModelAndView();
		mv.addObject("nos", arr);
		mv.setViewName("list");
		return mv;
	}

}
