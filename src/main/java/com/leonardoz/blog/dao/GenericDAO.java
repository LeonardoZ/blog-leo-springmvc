package com.leonardoz.blog.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.leonardoz.blog.dao.def.IGenericDAO;

@Transactional("default")
public abstract class GenericDAO<T> implements IGenericDAO<T> {

	@SuppressWarnings({ "unchecked" })
	private Class<T> clazz = (Class<T>) ((java.lang.reflect.ParameterizedType) getClass()
			.getGenericSuperclass()).getActualTypeArguments()[0];

	@Autowired
	private SessionFactory factory;

	public SessionFactory getSessionFactory() {
		return factory;
	}

	public void setSessionFactory(SessionFactory sf) {
		factory = sf;
	}

	protected Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public void salvar(T t) {
		getSession().saveOrUpdate(t);
	}

	@Override
	public void deletar(int id) {
		getSession().delete(get(id));
	}

	@Override
	@SuppressWarnings("unchecked")
	public T get(int id) {
		return (T) getSession().get(clazz, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> listar() {
		Criteria criteria = getSession().createCriteria(clazz).addOrder(
				Order.asc("id"));
		return criteria.list();
	}

	@Override
	public int contar() {
		return ((Number) getSession().createCriteria(clazz)
				.setProjection(Projections.count("id")).uniqueResult())
				.intValue();
	}
	
	

}
