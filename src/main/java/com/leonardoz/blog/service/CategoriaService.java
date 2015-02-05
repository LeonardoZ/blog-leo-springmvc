package com.leonardoz.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leonardoz.blog.dao.def.ICategoriaDAO;
import com.leonardoz.blog.dao.def.IGenericDAO;
import com.leonardoz.blog.entidade.Categoria;
import com.leonardoz.blog.service.def.ICategoriaService;

@Service
public class CategoriaService extends GenericService<Categoria> implements
		ICategoriaService {

	@Autowired
	private ICategoriaDAO dao;

	@Transactional
	@Override
	public List<Categoria> listarPor(List<String> scategorias) {
		List<Categoria> encontradas = dao.buscarPor(scategorias);
		inicializar(encontradas);
		return encontradas;
	}

	@Override
	protected IGenericDAO<Categoria> getDao() {
		return dao;
	}

	@Override
	public List<Categoria> listar(String descricao) {
		return dao.buscarPorLike(descricao);
	}

}
