package com.leonardoz.blog.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leonardoz.blog.dao.def.IPostDAO;
import com.leonardoz.blog.entidade.Post;

@Repository
@Transactional("default")
public class PostDAO extends GenericDAO<Post> implements IPostDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> buscarPaginado(int pagina) {
		Paginacao pag = new Paginacao();
		int valorFinal = pag.paginar(5, 5, pagina);
		int valorInicial = valorFinal - 5;
		Criteria criteria = getSession().createCriteria(Post.class);
		criteria.setFirstResult(valorInicial).setMaxResults(5).addOrder(Order.desc("data"));
		return criteria.list();
	}

}
