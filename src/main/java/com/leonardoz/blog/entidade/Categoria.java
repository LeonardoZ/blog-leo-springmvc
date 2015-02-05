package com.leonardoz.blog.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotEmpty;

@Entity @Table(name="categoria")
public class Categoria extends AbstractEntity implements 	Comparable<Categoria> {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	@Size(min = 1, max = 20)
	@Column(length = 20, unique = true, nullable = false,name="descricao")
	private String descricao;
	
	public Categoria() {

	}
	
	public Categoria(String descricao) {
		super();
		this.descricao = descricao;
	}


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(descricao).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return new EqualsBuilder().append(descricao, other.descricao)
				.isEquals();
	}

	@Override
	public int compareTo(Categoria cat) {
		return cat.getDescricao().compareTo(descricao);
	}
	
	@Override
	public String toString() {
		return descricao;
	}

}
