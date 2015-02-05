package com.leonardoz.blog.dao.def;

import java.util.List;

import com.leonardoz.blog.entidade.Post;

public interface IPostDAO extends IGenericDAO<Post>{
	
	public List<Post> buscarPaginado(int pagina);
	
	
}
