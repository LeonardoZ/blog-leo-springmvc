package com.leonardoz.blog.service;

import java.util.List;

import com.leonardoz.blog.entidade.AbstractEntity;

public interface IGenericService<T extends AbstractEntity> {

	public abstract List<T> listar();

	public abstract T porId(Integer id);

	public abstract void deletar(Integer i);

	public abstract void salvar(T p);

	public abstract void inicializar(T t);

	public abstract void inicializar(List<T> ts);

}