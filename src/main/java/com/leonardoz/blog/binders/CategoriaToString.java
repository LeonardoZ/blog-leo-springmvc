package com.leonardoz.blog.binders;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.leonardoz.blog.entidade.Categoria;

@Component
public class CategoriaToString implements Converter<Categoria, String> {

	@Override
	public String convert(Categoria source) {
		return source.getId().toString();
	}

}
