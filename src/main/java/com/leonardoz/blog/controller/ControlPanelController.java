package com.leonardoz.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.leonardoz.blog.service.def.IPostService;

@Controller
@RequestMapping(value = "/cp")
public class ControlPanelController {

	@Autowired
	private IPostService postService;


	@RequestMapping
	public ModelAndView listarPosts() {
		ModelAndView modelAndView = new ModelAndView("principal");
		modelAndView.addObject("posts", postService.listar());
		return modelAndView;
	}
	

}
