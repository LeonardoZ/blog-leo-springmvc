package com.leonardoz.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardoz.blog.dao.def.IAutorDAO;
import com.leonardoz.blog.dao.def.IGenericDAO;
import com.leonardoz.blog.entidade.Autor;
import com.leonardoz.blog.service.def.IAutorService;

@Service
public class AutorService extends GenericService<Autor> implements IAutorService{

	@Autowired
	private IAutorDAO autorDao;
	
	@Override
	protected IGenericDAO<Autor> getDao() {
		return autorDao;
	}

}
