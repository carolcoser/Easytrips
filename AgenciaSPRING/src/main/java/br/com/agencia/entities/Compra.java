package br.com.agencia.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
@Table(name = "compras")
public class Compra implements Serializable {
	private static final long serialVersionUID = 1L; 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_compra;
	
	@Column(nullable = false, length = 3)
	private int qtd_itens;
	
	@Column(nullable = false, length = 10)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataCompra;
	
	@Column(nullable = false, length = 5)
	private double valorCompra;
	
	@Column(nullable = false, length = 5)
	private double valor_itens;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id_fk", nullable = false)
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pacote_id_fk", nullable = false)
	private PacotesViagem pacote;

	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public Compra() {
	}
	
	public Compra(Long id_compra, PacotesViagem pacote, Cliente cliente, LocalDate dataCompra, int qtd_itens, double valor_itens) {
		super();
		this.id_compra = id_compra;
		this.qtd_itens = qtd_itens;
		this.dataCompra = dataCompra;
		this.pacote = pacote;
		this.cliente = cliente;
		this.valor_itens = valor_itens;
	}
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId_compra() {
		return id_compra;
	}

	public void setId_compra(Long id_compra) {
		this.id_compra = id_compra;
	}

	public int getQtd_itens() {
		return qtd_itens;
	}

	public void setQtd_itens(int qtd_itens) {
		this.qtd_itens = qtd_itens;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	public double getValor_itens() {
		return valor_itens;
	}

	public void setValor_itens(double valor_itens) {
		this.valor_itens = valor_itens;
	}

	public PacotesViagem getPacotes() {
		return pacote;
	}

	public void setPacotes(PacotesViagem pacote) {
		this.pacote = pacote;
	}

	public double valorCompra(PacotesViagem pacotes) {
		return this.valorCompra = this.qtd_itens * pacotes.getValor_pacote();
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, dataCompra, id_compra, pacote, qtd_itens, valorCompra, valor_itens);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(dataCompra, other.dataCompra)
				&& Objects.equals(id_compra, other.id_compra) && Objects.equals(pacote, other.pacote)
				&& qtd_itens == other.qtd_itens
				&& Double.doubleToLongBits(valorCompra) == Double.doubleToLongBits(other.valorCompra)
				&& Double.doubleToLongBits(valor_itens) == Double.doubleToLongBits(other.valor_itens);
	}

	@Override
	public String toString() {
		return "Compra [id_compra=" + id_compra + ", qtd_itens=" + qtd_itens + ", dataCompra=" + dataCompra
				+ ", valorCompra=" + valorCompra + ", valor_itens=" + valor_itens + ", cliente=" + cliente
				+ ", pacotes=" + pacote + "]";
	}

}
