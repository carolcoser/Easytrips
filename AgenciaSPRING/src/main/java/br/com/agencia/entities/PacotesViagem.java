package br.com.agencia.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pacotesViagem")
public class PacotesViagem implements Serializable {
	private static final long serialVersionUID = 1L; 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_pacote;
	
	@Column(nullable = false, length = 8)
	private double valor_pacote;
	
	@Column(nullable = false, length = 5)
	private String promo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "destino_id_fk", nullable = false)
	private Destinos destino;
	
	@OneToMany(mappedBy = "id_compra", fetch = FetchType.LAZY)
	private List<Compra> compras;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hotel_id_fk", nullable = false)
	private Hoteis hotel;
	

	public PacotesViagem(Long id_pacote, double valor_pacote, String promo, Hoteis hotel, Destinos destino) {
		super();
		this.id_pacote = id_pacote;
		this.destino = destino;
		this.hotel = hotel;
		this.promo = promo;
		this.valor_pacote = valor_pacote;
	}

	public PacotesViagem() {
	}

	public Destinos getDestino() {
		return destino;
	}

	public void setDestino(Destinos destino) {
		this.destino = destino;
	}

	public double getValor_pacote() {
		return valor_pacote;
	}
	public void setValor_pacote(double valor_pacote) {
		this.valor_pacote = valor_pacote;
	}
	public String getPromo() {
		return promo;
	}
	public void setPromo(String promo) {
		this.promo = promo;
	}
	public Long getId_pacote() {
		return id_pacote;
	}
	public void setId_pacote(Long id_pacote) {
		this.id_pacote = id_pacote;
	}
	

	public Hoteis getHotel() {
		return hotel;
	}

	public void setHotel(Hoteis hotel) {
		this.hotel = hotel;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	@Override
	public int hashCode() {
		return Objects.hash(destino, hotel, id_pacote, promo, valor_pacote);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PacotesViagem other = (PacotesViagem) obj;
		return Objects.equals(destino, other.destino) && Objects.equals(hotel, other.hotel)
				&& Objects.equals(id_pacote, other.id_pacote) && Objects.equals(promo, other.promo)
				&& Double.doubleToLongBits(valor_pacote) == Double.doubleToLongBits(other.valor_pacote);
	}

	@Override
	public String toString() {
		return "PacotesViagem [id_pacote=" + id_pacote + ", valor_pacote=" + valor_pacote + ", promo=" + promo
				+ ", destinos=" + destino + ", hotel=" + hotel + "]";
	}
	
	

}
