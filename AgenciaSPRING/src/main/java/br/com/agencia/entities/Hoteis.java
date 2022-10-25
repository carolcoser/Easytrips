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
@Table(name = "hoteis")
public class Hoteis implements Serializable {
	private static final long serialVersionUID = 1L; 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_hotel;
	
	@Column(nullable = false, length = 5)
	private String cafeDaManha;
	
	@Column(nullable = false, length = 8)
	private double valor_diaria;
	
	@Column(nullable = false, unique = true, length = 30)
	private String nome_hotel;


	public Hoteis(Long id_hotel, String cafeDaManha, double valor_diaria, String nome_hotel) {
		super();
		this.id_hotel = id_hotel;
		this.cafeDaManha = cafeDaManha;
		this.valor_diaria = valor_diaria;
		this.nome_hotel = nome_hotel;
	}

	public Hoteis() {
	}

	public Long getId_hotel() {
		return id_hotel;
	}

	public void setId_hotel(Long id_hotel) {
		this.id_hotel = id_hotel;
	}

	public String getCafeDaManha() {
		return cafeDaManha;
	}

	public void setCafeDaManha(String cafeDaManha) {
		this.cafeDaManha = cafeDaManha;
	}

	public double getValor_diaria() {
		return valor_diaria;
	}

	public void setValor_diaria(double valor_diaria) {
		this.valor_diaria = valor_diaria;
	}

	public String getNome_hotel() {
		return nome_hotel;
	}

	public void setNome_hotel(String nome_hotel) {
		this.nome_hotel = nome_hotel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cafeDaManha, id_hotel, nome_hotel, valor_diaria);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hoteis other = (Hoteis) obj;
		return Objects.equals(cafeDaManha, other.cafeDaManha) && Objects.equals(id_hotel, other.id_hotel)
				&& Objects.equals(nome_hotel, other.nome_hotel)
				&& Double.doubleToLongBits(valor_diaria) == Double.doubleToLongBits(other.valor_diaria);
	}

	@Override
	public String toString() {
		return "Hoteis [id_hotel=" + id_hotel + ", cafeDaManha=" + cafeDaManha + ", valor_diaria=" + valor_diaria
				+ ", nome_hotel=" + nome_hotel + "]";
	}
	
	
}
