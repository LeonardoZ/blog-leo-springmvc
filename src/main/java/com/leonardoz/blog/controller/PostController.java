package com.leonardoz.blog.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.leonardoz.blog.entidade.Autor;
import com.leonardoz.blog.entidade.Categoria;
import com.leonardoz.blog.entidade.Post;
import com.leonardoz.blog.service.def.ICategoriaService;
import com.leonardoz.blog.service.def.IPostService;

@Controller
@RequestMapping(value = "/cp/post")
public class PostController {

	@Autowired
	private IPostService postService;

	@Autowired
	private ICategoriaService categoriaService;

	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novoPost() {
		ModelAndView mv = new ModelAndView("post/form", "post", new Post());
		mv.addObject("categorias", categoriaService.listar());
		return mv;
	}

	@RequestMapping(value = "/salvar.do", method = RequestMethod.POST)
	public ModelAndView salvarPost(@Valid Post p, BindingResult binding,
			HttpServletRequest request) {
		if (binding.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("post/form", "post", p);
			modelAndView.addObject(StringResources.TEM_ERROS,
					binding.hasErrors());
			modelAndView.addObject("categorias", categoriaService.listar());
			return modelAndView;
		}
		Autor autor = (Autor) request.getSession().getAttribute(
				StringResources.AUTOR);

		if (p.getId() == null || p.getId() == 0) {
			p.setAutor(autor);
			p.setData(new Date());
		}
		postService.salvar(p);
		return new ModelAndView("redirect:posts");
	}

	@RequestMapping("/posts")
	public ModelAndView listarPosts() {
		ModelAndView modelAndView = new ModelAndView("principal");
		modelAndView.addObject("posts", postService.listar());
		return modelAndView;
	}
	
	@RequestMapping(value="/categorias")
	public @ResponseBody List<Categoria> listarCategoriasDoPost(@RequestParam(required=true,value="id") Integer id){
		Post post = postService.porId(id);
		return post.getCategorias();
	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public ModelAndView editar(@RequestParam(value = "id") Integer id) {
		Post post = postService.porId(id);
		ModelAndView mav = new ModelAndView("post/form", "post", post);
		mav.addObject("categorias", categoriaService.listar());
		return mav;
	}

	@RequestMapping(value = "/deletar.do",method=RequestMethod.POST)
	public ModelAndView deletar(@RequestParam(value = "id") Integer id) {
		postService.deletar(id);
		return listarPosts();
	}

}
