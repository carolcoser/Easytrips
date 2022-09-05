package modelo;

public class Cliente {

	private int id_cliente;
	private String emailCliente;
	private String nomeCliente;
	private String senhaCliente;
	private String cpfCliente;

	private Login login;

	public Cliente() {
}

	public Cliente(int id_cliente, String emailCliente, String nomeCliente, String senhaCliente, String cpfCliente,
			Login login) {
		super();
		this.id_cliente = id_cliente;
		this.emailCliente = emailCliente;
		this.nomeCliente = nomeCliente;
		this.senhaCliente = senhaCliente;
		this.cpfCliente = cpfCliente;
		this.login = login;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
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

}


