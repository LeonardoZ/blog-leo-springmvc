package com.leonardoz.blog.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leonardoz.blog.dao.def.IGenericDAO;
import com.leonardoz.blog.entidade.AbstractEntity;

@Service
public abstract class GenericService<T extends AbstractEntity> implements
		IGenericService<T> {
	@Transactional
	@Override
	public List<T> listar() {
		List<T> lista = getDao().listar();
		inicializar(lista);
		return lista;
	}

	@Override
	@Transactional
	public T porId(Integer id) {
		T entidade = getDao().get(id);
		inicializar(entidade);
		return entidade;
	}

	public void deletar(Integer id) {
		getDao().deletar(id);
	}

	@Transactional
	public void salvar(T t) {
		getDao().salvar(t);
	}

	public void inicializar(T t) {
		Hibernate.initialize(t);
	}

	public void inicializar(List<T> ts) {
		for (T entidade : ts) {
			inicializar(entidade);
		}
	}

	public int contar(){
		return getDao().contar();
	}
	
	protected abstract IGenericDAO<T> getDao();
	
	

}
