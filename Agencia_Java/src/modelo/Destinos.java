package modelo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Destinos {

	private LocalDate data_volta;
	private LocalDate data_ida;
	private int id_destino;
	private String pais;
	private String cidade_origem;
	private String nomeDestino;

	//Classe para formatar a data
	DateTimeFormatter formata = DateTimeFormatter.ofPattern("d/MM/yyyy");

	public Destinos(int id_destino, String pais, String cidade_origem, String data_ida, String data_volta, String nomeDestino) {
		super();
		this.data_volta = LocalDate.parse(data_volta, formata);
		this.data_ida = LocalDate.parse(data_ida, formata);
		this.id_destino = id_destino;
		this.pais = pais;
		this.cidade_origem = cidade_origem;
		this.nomeDestino = nomeDestino;
	}

	public Destinos() {
	}


	public String getData_volta() {
		return formata.format(data_volta);
	}

	public void setData_volta(String data_volta) {
		this.data_volta = LocalDate.parse(data_volta, formata);
	}

	public String getData_ida() {
		return formata.format(data_ida);
	}

	public void setData_ida(String data_ida) {
		this.data_ida = LocalDate.parse(data_ida, formata);
	}

	public int getId_destino() {
		return id_destino;
	}

	public void setId_destino(int id_destino) {
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

}


