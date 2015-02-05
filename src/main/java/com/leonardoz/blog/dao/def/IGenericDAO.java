package com.leonardoz.blog.dao.def;

import java.util.List;

public interface IGenericDAO<T> {

	public abstract void salvar(T t);

	public abstract void deletar(int id);

	public abstract T get(int id);

	public abstract List<T> listar();
	
	public abstract int contar();
	

}