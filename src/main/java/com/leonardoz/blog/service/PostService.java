package com.leonardoz.blog.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leonardoz.blog.dao.def.ICategoriaDAO;
import com.leonardoz.blog.dao.def.IGenericDAO;
import com.leonardoz.blog.dao.def.IPostDAO;
import com.leonardoz.blog.entidade.Autor;
import com.leonardoz.blog.entidade.Categoria;
import com.leonardoz.blog.entidade.Post;
import com.leonardoz.blog.service.def.IPostService;

@Service
public class PostService extends GenericService<Post> implements IPostService {

	@Autowired
	private IPostDAO postDAO;

	@Autowired
	private ICategoriaDAO categoriaDAO;

	@Transactional(value = "default")
	@Override
	public List<Post> listar() {
		List<Post> lista = postDAO.listar();
		inicializar(lista);
		return lista;
	}

	@Transactional(value = "default")
	@Override
	public Post porId(Integer id) {
		Post post = postDAO.get(id);
		post.getCategorias().size();
		post.getComentarios().size();
		return post;
	}

	@Transactional(value = "default")
	public void salvar(Integer id,Autor autor, String titulo, String conteudo,
			List<String> scategorias) {
		List<Categoria> cats = categoriaDAO.buscarPor(scategorias);
		Post post = new Post(autor, titulo, conteudo, new Date(), cats);
		postDAO.salvar(post);
	}


	@Override
	protected IGenericDAO<Post> getDao() {
		return postDAO;
	}

	@Override
	public List<Post> buscarPaginado(int pagina) {
		return postDAO.buscarPaginado(pagina);
	}

	


}
