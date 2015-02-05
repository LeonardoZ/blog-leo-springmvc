package com.leonardoz.blog.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.leonardoz.blog.dao.def.IAutorDAO;
import com.leonardoz.blog.entidade.Autor;
import com.leonardoz.blog.entidade.PasswordUtil;
import com.leonardoz.blog.entidade.UsuarioLogin;

@Controller
public class LoginController {

	@Autowired
	private IAutorDAO autorDAO;

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute UsuarioLogin usuario,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		
		Autor autor = autorDAO.porEmailESenha(usuario.getEmail(),
				PasswordUtil.encrypt(usuario.getSenha()));
		
		boolean autenticado = autor != null;
		if (autenticado) {
			HttpSession session = request.getSession();
			session.setAttribute(StringResources.AUTOR, autor);
			return "redirect:cp/post/posts";
		} else {
			return "redirect:login";
		}

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView doLogin() {
		return new ModelAndView("login", "command", new UsuarioLogin());
	}
	
	
	@RequestMapping(value="/logout.do")
	private ModelAndView logout(HttpServletRequest req) {
		req.getSession().removeAttribute(StringResources.AUTOR);
		return doLogin();
	}

}
