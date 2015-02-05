package com.leonardoz.blog.binders;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Component;

import com.leonardoz.blog.entidade.Categoria;

public class ConvertersDefinition implements FormatterRegistrar {

	@Override
	public void registerFormatters(FormatterRegistry registry) {
		DateFormatter df = new DateFormatter();
		df.setPattern("dd/MM/yyyy");
		registry.addFormatter(df);
		registry.addConverter(new CatToS());
		registry.addConverter(new SToCat());
	}

	public class CatToS implements Converter<Categoria, String> {

		@Override
		public String convert(Categoria source) {
			return source.getId().toString();
		}

	}

	@Component
	public class SToCat implements Converter<String, Categoria> {
		
		private StringToCategoria data = new StringToCategoria();

		@Override
		public Categoria convert(String source) {
			System.out.println("i1m called?");
			return data.s.porId(Integer.valueOf(source));
		}

	}

}
