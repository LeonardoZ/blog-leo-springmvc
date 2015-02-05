package com.leonardoz.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardoz.blog.dao.def.IComentarioDAO;
import com.leonardoz.blog.dao.def.IGenericDAO;
import com.leonardoz.blog.entidade.Comentario;
import com.leonardoz.blog.service.def.IComentarioService;

@Service
public class ComentarioService extends GenericService<Comentario> implements
		IComentarioService {

	@Autowired
	private IComentarioDAO dao;
	
	@Override
	protected IGenericDAO<Comentario> getDao() {
		return dao;
	}


}
