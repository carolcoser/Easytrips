package modelo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Compra {

	private int id_compra;
	private double valor_itens;
	private int qtd_itens;
	private LocalDate dataCompra;
	private double valorCompra;

	private PacotesViagem pacotes;
	private Cliente cliente;
	
	DateTimeFormatter formata = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Compra(int id_compra, PacotesViagem pacotes, Cliente cliente, double valor_itens, int qtd_itens, String dataCompra, double valorCompra) {
		super();
		this.id_compra = id_compra;
		this.valor_itens = valor_itens;
		this.qtd_itens = qtd_itens;
		this.dataCompra = LocalDate.parse(dataCompra, formata);
		this.valorCompra = valorCompra;
		this.pacotes = pacotes;
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Compra() {
	}

	public int getId_compra() {
		return id_compra;
	}

	public void setId_compra(int id_compra) {
		this.id_compra = id_compra;
	}

	public double getValor_itens() {
		return valor_itens;
	}

	public void setValor_itens(double valor_itens) {
		this.valor_itens = valor_itens;
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

	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public PacotesViagem getPacotes() {
		return pacotes;
	}

	public void setPacotes(PacotesViagem pacotes) {
		this.pacotes = pacotes;
	}

	private void calcularTotal(double valor_itens) {
	this.valorCompra = this.qtd_itens * valor_itens;
	}


}
