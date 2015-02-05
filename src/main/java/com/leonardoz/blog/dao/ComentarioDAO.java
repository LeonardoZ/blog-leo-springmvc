package com.leonardoz.blog.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leonardoz.blog.dao.def.IComentarioDAO;
import com.leonardoz.blog.entidade.Comentario;

@Repository
@Transactional("default")
public class ComentarioDAO extends GenericDAO<Comentario> implements IComentarioDAO {

}
