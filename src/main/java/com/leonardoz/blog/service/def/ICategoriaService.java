package com.leonardoz.blog.service.def;

import java.util.List;

import com.leonardoz.blog.entidade.Categoria;

public interface ICategoriaService extends IGenericService<Categoria>{

	List<Categoria> listarPor(List<String> scategorias);

	List<Categoria> listar(String descricao);

}
