package com.gl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyHelloWorld {
	
	@RequestMapping("/welcome" )
	public ModelAndView helloWorld(HttpServletRequest request,HttpServletResponse response) {
		String message="<div style='text-align:center border:5 solid background-color:green'>"+
						"<h2>Hello World from Spring MVC </h2></div>";
		return new ModelAndView("welcome","message",message);
	}
	
	@RequestMapping("/")
	public String main() 
	{
		return "index";
	}

}
