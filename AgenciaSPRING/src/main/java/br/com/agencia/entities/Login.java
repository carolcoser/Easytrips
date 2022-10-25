package br.com.agencia.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_login;
	
	@Column(nullable = false, length = 15)
	private String tipoLogin;

	public Login() {

	}

	public Login(Long id, String tipoLogin) {
		this.id_login = id;
		this.tipoLogin = tipoLogin;
	}

	public Long getId_login() {
		return id_login;
	}

	public void setId_login(Long id_login) {
		this.id_login = id_login;
	}

	public String getTipoLogin() {
		return tipoLogin;
	}

	public void setTipoLogin(String tipoLogin) {
		this.tipoLogin = tipoLogin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_login, tipoLogin);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		return Objects.equals(id_login, other.id_login) && Objects.equals(tipoLogin, other.tipoLogin);
	}

	@Override
	public String toString() {
		return "Login [id_login=" + id_login + ", tipoLogin=" + tipoLogin + "]";
	}

}
