package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Compra {

	private PacotesViagem pacotes;
	private Cliente cliente;
	private int id_pacote;
	private int id_cliente;
	private int id_compra;
	private int qtd_itens;
	private LocalDate dataCompra;
	private double valorCompra;
	private double valor_itens;

	DateTimeFormatter formata = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	
	
	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public Compra() {
	}
	
	public Compra(int id_compra, PacotesViagem pacotes, Cliente cliente, int qtd_itens, String dataCompra) {
		super();
		this.id_compra = id_compra;
		this.qtd_itens = qtd_itens;
		this.dataCompra = LocalDate.parse(dataCompra, formata);
		this.pacotes = pacotes;
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getId_compra() {
		return id_compra;
	}

	public void setId_compra(int id_compra) {
		this.id_compra = id_compra;
	}

	public int getQtd_itens() {
		return qtd_itens;
	}

	public void setQtd_itens(int qtd_itens) {
		this.qtd_itens = qtd_itens;
	}

	public String getDataCompra() {
		return formata.format(dataCompra);
	}

	public void setDataCompra(String dataCompra) {
		this.dataCompra = LocalDate.parse(dataCompra, formata);
	}

	public double getValor_itens() {
		return valor_itens;
	}

	public void setValor_itens(double valor_itens) {
		this.valor_itens = valor_itens;
	}

	public PacotesViagem getPacotes() {
		return pacotes;
	}

	public void setPacotes(PacotesViagem pacotes) {
		this.pacotes = pacotes;
	}

	public double valorCompra() {
		return this.valorCompra = this.qtd_itens * pacotes.getValor_pacote();
	}
	
	public int id_cliente() {
		return id_cliente = cliente.getId_cliente();
	}

	public int id_pacote() {
		return id_pacote = pacotes.getId_pacote();
	}

}
