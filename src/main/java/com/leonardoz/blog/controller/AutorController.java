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
import org.springframework.web.servlet.ModelAndView;

import com.leonardoz.blog.entidade.Autor;
import com.leonardoz.blog.service.def.IAutorService;

@Controller
@RequestMapping(value = "/cp/autor")
public class AutorController {

	@Autowired
	private IAutorService service;

	@RequestMapping(value = "/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView("autor/form", "autor",
				new Autor());
		modelAndView.addObject("listar", Boolean.TRUE);
		return modelAndView;
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView listarAutores() {
		List<Autor> autores = service.listar();
		ModelAndView mav = new ModelAndView("autor/listar");
		mav.addObject("autores", autores);
		return mav;
	}

	@RequestMapping(value = "/perfil")
	public ModelAndView getPerfil(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("autor/perfil");
		Autor autor = (Autor) request.getSession().getAttribute(
				StringResources.AUTOR);
		modelAndView.addObject("autor", autor);
		return modelAndView;
	}

	@RequestMapping(value = "/salvar.do", method = RequestMethod.POST)
	private ModelAndView salvar(@Valid Autor autor, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("autor/form", "autor", autor);
			modelAndView.addObject(StringResources.TEM_ERROS, bindingResult.hasErrors());
			return modelAndView;
		}

		if (autor.getId() == null || autor.getId() == 0) {
			autor.setCadastrado(new Date());
		}
		service.salvar(autor);
		return new ModelAndView("redirect:listar");
	}

	@RequestMapping(value = "/editar.do", method = RequestMethod.GET)
	public ModelAndView editar(@RequestParam(value = "id") Integer id,
			HttpServletRequest req) {
		Autor autor = service.porId(id);
		Autor autorLogado = (Autor) req.getSession().getAttribute(
				StringResources.AUTOR);
		ModelAndView modelAndView = new ModelAndView("autor/form", "autor",
				autor);

		modelAndView.addObject("perfil", Boolean.TRUE);
		return autorLogado.equals(autor) ? modelAndView : getPerfil(req);
	}
	// @RequestMapping(value = "/deletar.do") public ModelAndView
	// deletar(@RequestParam(value = "id") Integer id) {
	// service.deletar(id); return listarAutors(); }

}
