package com.leonardoz.blog.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leonardoz.blog.dao.def.IAutorDAO;
import com.leonardoz.blog.entidade.Autor;

@Repository
@Transactional("default")
public class AutorDAO extends GenericDAO<Autor> implements IAutorDAO {

	public Autor porEmailESenha(String loginEmail, String encrypted) {
		Criteria criteria = getSession().createCriteria(Autor.class);
		criteria.add(Restrictions.eq("email", loginEmail)).
		add(Restrictions.eq("hashSenha", encrypted));
		return (Autor) criteria.uniqueResult();
	
	}

	@Override
	public Autor getPorEmail(String email) {
		return (Autor) getSession().createCriteria(Autor.class).add(Restrictions.eq("email", email)).uniqueResult();
	}

}
