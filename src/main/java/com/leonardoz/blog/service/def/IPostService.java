package com.leonardoz.blog.service.def;

import java.util.List;

import com.leonardoz.blog.entidade.Autor;
import com.leonardoz.blog.entidade.Post;

public interface IPostService extends IGenericService<Post> {

	void salvar(Integer id, Autor autor, String titulo, String conteudo,
			List<String> scategorias);

	Post porId(Integer id);
	
	List<Post> buscarPaginado(int pagina);

}
