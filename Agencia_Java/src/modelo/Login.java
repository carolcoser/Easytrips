package modelo;

public class Login {

private int id_login;
private String tipoLogin;

public Login() {

}

public Login(int id, String tipoLogin) {
	this.id_login = id;
	this.tipoLogin = tipoLogin;
}

public int getId_login() {
	return id_login;
}

public void setId_login(int id_login) {
	this.id_login = id_login;
}

public String getTipoLogin() {
	return tipoLogin;
}

public void setTipoLogin(String tipoLogin) {
	this.tipoLogin = tipoLogin;
}


public String mostrarLogin() {
	return "ID: " + this.id_login + "| Tipo: " + this.tipoLogin;
}

}
