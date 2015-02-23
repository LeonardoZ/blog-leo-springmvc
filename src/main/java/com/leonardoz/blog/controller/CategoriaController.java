package com.leonardoz.blog.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.leonardoz.blog.entidade.Categoria;
import com.leonardoz.blog.service.def.ICategoriaService;

@Controller
@RequestMapping("/cp/categoria")
public class CategoriaController {

	@Autowired
	private ICategoriaService service;

	@RequestMapping(value = "/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView("categoria/form",
				"categoria", new Categoria());
		return modelAndView;
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView listarCategorias() {
		List<Categoria> cats = service.listar();
		ModelAndView mav = new ModelAndView("categoria/listar");
		mav.addObject("categorias", cats);
		return mav;
	}

	@RequestMapping(value = "/listar.do", method = RequestMethod.GET)
	public @ResponseBody List<Categoria> listarCategoriasJSON() {
		return service.listar();
	}

	@RequestMapping(value = "/listar/contendo", method = RequestMethod.GET)
	public @ResponseBody List<Categoria> listarCategoriasJSON(
			@RequestParam(value = "desc") String descricao) {
		return service.listar(descricao);
	}

	@RequestMapping(value = "/criar.do", method = RequestMethod.POST)
	public @ResponseBody Categoria criarCategoria(@NotEmpty String descricao) {
		List<Categoria> categorias = service.listar(descricao);
		if (categorias == null || categorias.isEmpty()) {
			Categoria categoria = new Categoria(descricao);
			service.salvar(categoria);
			return categoria;
		} else {
			return categorias.get(0);
		}
	}

	@RequestMapping(value = "/salvar.do", method = RequestMethod.POST)
	private ModelAndView salvar(@Valid Categoria categoria,
			BindingResult binding) {
		if (binding.hasErrors()) {
			ModelAndView mav = new ModelAndView("categoria/form", "categoria",
					categoria);
			mav.addObject(StringResources.TEM_ERROS, binding.hasErrors());
			return mav;
		}
		service.salvar(categoria);
		return new ModelAndView("redirect:listar");
	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public ModelAndView editar(@RequestParam(value = "id") Integer id) {
		Categoria categoria = service.porId(id);
		ModelAndView mav = new ModelAndView("categoria/form", "categoria",
				categoria);
		return mav;
	}

	@RequestMapping(value = "/deletar.do",method=RequestMethod.POST)
	public ModelAndView deletar(@RequestParam(value = "id") Integer id) {
		service.deletar(id);
		return new ModelAndView("redirect:listar");
	}

}
