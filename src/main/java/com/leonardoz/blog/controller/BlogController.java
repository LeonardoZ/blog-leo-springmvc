package com.leonardoz.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.leonardoz.blog.entidade.Comentario;
import com.leonardoz.blog.entidade.Post;
import com.leonardoz.blog.service.def.IComentarioService;
import com.leonardoz.blog.service.def.IPostService;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	private IPostService postService;

	@Autowired
	private IComentarioService comentarioService;

	@RequestMapping
	public ModelAndView ultimosPosts(@RequestParam(value = "p", defaultValue = "1", required = false) int pagina) {
		List<Post> posts = postService.buscarPaginado(pagina);
		posts.forEach(p -> System.out.println(p.getId()));
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("posts", posts);
		long round = Math.round(postService.contar() / 5.0);
		modelAndView.addObject("paginas", round);
		return modelAndView;
	}

	@RequestMapping("/post")
	public ModelAndView abrirPostCompleto(@RequestParam(value = "id") int id) {
		Post post = postService.porId(id);
		Comentario comentario = new Comentario();
		comentario.setPost(post);
		ModelAndView modelAndView = new ModelAndView("blog/post", "comentario", comentario);
		modelAndView.addObject("post", post);
		return modelAndView;

	}

	@RequestMapping(value = "/comentario/adicionar.do", method = RequestMethod.POST)
	public ModelAndView salvarComentario(@Valid Comentario comentario, BindingResult binding,
			HttpServletRequest request) {
		comentarioService.salvar(comentario);
		return new ModelAndView("redirect:/blog/post?id=" + comentario.getPost().getId().toString());
	}

}
