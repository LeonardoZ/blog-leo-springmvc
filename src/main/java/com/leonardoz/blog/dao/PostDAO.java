package com.leonardoz.blog.dao;

import java.util.List;

import org.hibernate.Query;
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
		Query query = getSession().createQuery("select p from Post p left join fetch p.comentarios order by p.data desc")
				.setFirstResult(valorInicial)
				.setMaxResults(5);
		
		List<Post> list = query.list();
		return list;
	}

}
