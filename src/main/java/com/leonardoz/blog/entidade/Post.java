package com.leonardoz.blog.entidade;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "post")
public class Post extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_autor")
	private Autor autor;

	@NotEmpty
	@Size(min = 1, max = 140)
	@Column(length = 140, nullable = false, name = "titulo")
	private String titulo;

	@NotEmpty
	@Size(min = 1)
	@Column(columnDefinition = "text", nullable = false, name = "conteudo")
	private String conteudo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data")
	private Date data;

	@NotEmpty
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinTable(name = "post_categoria", joinColumns = @JoinColumn(name = "id_post"), inverseJoinColumns = @JoinColumn(name = "id_categoria"))
	private List<Categoria> categorias;

	@OneToMany(mappedBy = "post")
	private List<Comentario> comentarios;

	public Post() {

	}

	public Post(Autor autor, String titulo, String conteudo, Date data,
			List<Categoria> categorias) {
		super();
		this.autor = autor;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.data = data;
		this.categorias = categorias;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
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
	
	public String getParagrafosDoConteudo(){
		return conteudo.subSequence(0, 350).toString();
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public int numeroDeComentarios() {
		return comentarios.size();
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return getId() + " Post [autor=" + autor + ", titulo=" + titulo
				+ ", conteudo=" + conteudo + ", data=" + data + ", categorias="
				+ categorias + ", comentarios=" + comentarios + "]";
	}

}
