package com.leonardoz.blog.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "autor")
public class Autor extends AbstractEntity implements Comparable<Autor> {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Size(max = 12)
	@Column(length = 12, nullable = false, unique = true, name = "nick")
	private String nick;

	@NotEmpty
	@Size(max = 40)
	@Column(length = 40, nullable = false, name = "nome_completo")
	private String nomeCompleto;

	@NotEmpty
	@Email
	@Column(length = 35, nullable = false, unique = true, name = "email")
	private String email;

	@NotEmpty
	@Size(min = 3, max = 64)
	@Column(length = 64, nullable = false, name = "hash_senha")
	private String hashSenha;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false, name = "cadastrado")
	private Date cadastrado;

	public Autor() {
	}

	public Autor(String nick, String nomeCompleto, String email,
			String hashSenha, Date cadastrado) {
		super();
		this.nick = nick;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.hashSenha = hashSenha;
		this.cadastrado = cadastrado;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHashSenha() {
		return hashSenha;
	}

	public void setHashSenha(String senha) {
		this.hashSenha = PasswordUtil.encrypt(senha);
	}

	public void setCadastrado(Date cadastrado) {
		this.cadastrado = cadastrado;
	}

	public Date getCadastrado() {
		return cadastrado;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(email).append(nick).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return new EqualsBuilder().append(email, other.email)
				.append(nick, other.nick).isEquals();
	}

	@Override
	public int compareTo(Autor arg0) {
		return 0;
	}

}
