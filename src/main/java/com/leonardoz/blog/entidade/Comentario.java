package com.leonardoz.blog.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "comentario")
public class Comentario extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_post")
	private Post post;

	@NotEmpty
	@Size(min = 1, max = 50)
	@Column(length = 50, unique = true, nullable = false, name = "titulo")
	private String titulo;

	@NotEmpty
	@Size(min = 1, max = 200)
	@Column(length = 200, unique = true, nullable = false, name = "descricao")
	private String conteudo;

	@Column(length = 20, unique = true, nullable = false, name = "autor")
	private String autor;

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

}
