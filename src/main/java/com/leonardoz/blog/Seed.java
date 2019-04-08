package com.leonardoz.blog;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.leonardoz.blog.entidade.Autor;
import com.leonardoz.blog.service.def.IAutorService;

@Component
public class Seed {

	@Autowired
	private IAutorService autorService;

	@EventListener
	public void seed(ContextRefreshedEvent event) {
		seedAutor();
	}

	private void seedAutor() {
		if (autorService.contar() > 0) {
			return;
		}

		Autor autor = new Autor();
		autor.setNick("The admin");
		autor.setNomeCompleto("Admin");
		autor.setHashSenha("123456");
		autor.setCadastrado(new Date());
		autor.setEmail("admin@admin.com");
		autorService.salvar(autor);
	}

}
