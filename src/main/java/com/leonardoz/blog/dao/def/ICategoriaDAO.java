package com.leonardoz.blog.dao.def;

import java.util.List;

import com.leonardoz.blog.entidade.Categoria;

public interface ICategoriaDAO extends IGenericDAO<Categoria>{

	List<Categoria> buscarPor(List<String> scategorias);

	List<Categoria> buscarPorLike(String descricao);

}