package com.leonardoz.blog.binders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.leonardoz.blog.entidade.Categoria;
import com.leonardoz.blog.service.def.ICategoriaService;

@Component
public class StringToCategoria implements Converter<String, Categoria> {

	@Autowired
	public ICategoriaService s;

	@Override
	public Categoria convert(String source) {
		return s.porId(Integer.valueOf(source));
	}
}