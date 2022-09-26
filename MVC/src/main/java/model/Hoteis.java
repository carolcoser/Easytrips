package model;

public class Hoteis {

	private int id_hotel;
	private String cafeDaManha;
	private double valor_diaria;
	private String nome_hotel;


	public Hoteis(int id_hotel, String cafeDaManha, double valor_diaria, String nome_hotel) {
		super();
		this.id_hotel = id_hotel;
		this.cafeDaManha = cafeDaManha;
		this.valor_diaria = valor_diaria;
		this.nome_hotel = nome_hotel;
	}

	public Hoteis() {
	}

	public int getId_hotel() {
		return id_hotel;
	}

	public void setId_hotel(int id_hotel) {
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
}
