package modelo;

public class PacotesViagem {

	private double valor_pacote;
	private int id_pacote;
	private Destinos destino;
	private Hoteis hotel;
	private String promo;

	public PacotesViagem(int id_pacote, double valor_pacote, String promo, Hoteis hotel, Destinos destino) {
		super();
		this.id_pacote = id_pacote;
		this.destino = destino;
		this.hotel = hotel;
		this.promo = promo;
		this.valor_pacote = valor_pacote;
	}

	public PacotesViagem() {
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
	public int getId_pacote() {
		return id_pacote;
	}
	public void setId_pacote(int id_pacote) {
		this.id_pacote = id_pacote;
	}
	public Hoteis getHotel() {
		return hotel;
	}
	public void setHotel(Hoteis hotel) {
		this.hotel = hotel;
	}
	public Destinos getDestino() {
		return destino;
	}
	public void setDestino(Destinos destino) {
		this.destino = destino;
	}



}
