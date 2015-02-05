package com.leonardoz.blog.dao.def;

import com.leonardoz.blog.entidade.Autor;

public interface IAutorDAO extends IGenericDAO<Autor>{

	Autor porEmailESenha(String loginEmail, String encrypted);

	public Autor getPorEmail(String email);
	
}