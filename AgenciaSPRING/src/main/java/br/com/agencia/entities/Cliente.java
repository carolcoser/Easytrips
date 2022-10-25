package br.com.agencia.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "cliente")
public class Cliente implements UserDetails, Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cliente;

	@Column(nullable = false, unique = true, length = 70)
	private String emailCliente;

	@Column(nullable = false, length = 30)
	private String nomeCliente;

	@Column(nullable = false, length = 80)
	private String senhaCliente;

	@Column(nullable = false, length = 11)
	private String cpfCliente;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "login_id_fk", nullable = false)
	private Login login;

	public Cliente() {
	}

	public Cliente(Long id_cliente, String emailCliente, String nomeCliente, String senhaCliente, String cpfCliente,
			Login login) {
		super();
		this.id_cliente = id_cliente;
		this.emailCliente = emailCliente;
		this.nomeCliente = nomeCliente;
		this.senhaCliente = senhaCliente;
		this.cpfCliente = cpfCliente;
		this.login = login;
	}

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getSenhaCliente() {
		return senhaCliente;
	}

	public void setSenhaCliente(String senhaCliente) {
		this.senhaCliente = senhaCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cpfCliente, emailCliente, id_cliente, login, nomeCliente, senhaCliente);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpfCliente, other.cpfCliente) && Objects.equals(emailCliente, other.emailCliente)
				&& Objects.equals(id_cliente, other.id_cliente) && Objects.equals(login, other.login)
				&& Objects.equals(nomeCliente, other.nomeCliente) && Objects.equals(senhaCliente, other.senhaCliente);
	}

	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", emailCliente=" + emailCliente + ", nomeCliente=" + nomeCliente
				+ ", senhaCliente=" + senhaCliente + ", cpfCliente=" + cpfCliente + ", login=" + login + "]";
	}

	public Cliente orElseThrow(Cliente cliente) {
		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		return this.senhaCliente;
	}

	@Override
	public String getUsername() {
		return this.emailCliente;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
