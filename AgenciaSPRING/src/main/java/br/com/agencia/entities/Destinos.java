package br.com.agencia.entities;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
@Table(name = "destinos")
public class Destinos implements Serializable {
	private static final long serialVersionUID = 1L; 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_destino;
	
	@Column(nullable = false, length = 10)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate data_volta;
	
	@Column(nullable = false, length = 10)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate data_ida;
	
	@Column(nullable = false, length = 20)
	private String pais;
	
	@Column(nullable = false, length = 30)
	private String cidade_origem;
	
	@Column(nullable = false, length = 30)
	private String nomeDestino;
	
	@OneToMany(mappedBy = "id_destino", fetch = FetchType.LAZY)
	private List<Destinos> destinos;


	public Destinos(Long id_destino, String pais, String cidade_origem, LocalDate data_ida, LocalDate data_volta, String nomeDestino) {
		super();
		this.data_volta = data_volta;
		this.data_ida = data_ida;
		this.id_destino = id_destino;
		this.pais = pais;
		this.cidade_origem = cidade_origem;
		this.nomeDestino = nomeDestino;
	}

	public Destinos() {
	}


	public LocalDate getData_volta() {
		return data_volta;
	}

	public void setData_volta(LocalDate data_volta) {
		this.data_volta = data_volta;
	}

	public LocalDate getData_ida() {
		return data_ida;
	}

	public void setData_ida(LocalDate data_ida) {
		this.data_ida = data_ida;
	}

	public Long getId_destino() {
		return id_destino;
	}

	public void setId_destino(Long id_destino) {
		this.id_destino = id_destino;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCidade_origem() {
		return cidade_origem;
	}

	public void setCidade_origem(String cidade_origem) {
		this.cidade_origem = cidade_origem;
	}

	public String getNomeDestino() {
		return nomeDestino;
	}

	public void setNomeDestino(String nomeDestino) {
		this.nomeDestino = nomeDestino;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cidade_origem, data_ida, data_volta, id_destino, nomeDestino, pais);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Destinos other = (Destinos) obj;
		return Objects.equals(cidade_origem, other.cidade_origem) && Objects.equals(data_ida, other.data_ida)
				&& Objects.equals(data_volta, other.data_volta) && Objects.equals(id_destino, other.id_destino)
				&& Objects.equals(nomeDestino, other.nomeDestino) && Objects.equals(pais, other.pais);
	}

	@Override
	public String toString() {
		return "Destinos [id_destino=" + id_destino + ", data_volta=" + data_volta + ", data_ida=" + data_ida
				+ ", pais=" + pais + ", cidade_origem=" + cidade_origem + ", nomeDestino=" + nomeDestino + "]";
	}

}
