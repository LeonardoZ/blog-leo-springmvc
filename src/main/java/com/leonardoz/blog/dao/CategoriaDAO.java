package com.leonardoz.blog.dao;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leonardoz.blog.dao.def.ICategoriaDAO;
import com.leonardoz.blog.entidade.Categoria;

@Repository
@Transactional("default")
public class CategoriaDAO extends GenericDAO<Categoria> implements
		ICategoriaDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> buscarPor(List<String> scategorias) {
		return (List<Categoria>) getSession().createCriteria(Categoria.class)
				.add(Restrictions.in("descricao", scategorias)).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Categoria> buscarPorLike(String descricao) {
		return getSession()
				.createCriteria(Categoria.class)
				.add(Restrictions
						.like("descricao", descricao, MatchMode.ANYWHERE)).list();
	}

}
