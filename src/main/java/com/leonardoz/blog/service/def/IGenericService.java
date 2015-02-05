package com.leonardoz.blog.service.def;

import java.util.List;

interface IGenericService<T> {
	
	List<T> listar();

	T porId(Integer id);

	void deletar(Integer id);

	void salvar(T t);

	void inicializar(T t);

	void inicializar(List<T> ts);
	
	int contar();

}
