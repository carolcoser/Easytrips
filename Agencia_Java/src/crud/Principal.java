package crud;

import dao.DestinosDAO;
import dao.ClienteDAO;
import dao.LoginDAO;
import dao.HoteisDAO;
import dao.PacotesDAO;
import dao.CompraDAO;

import modelo.Destinos;
import modelo.Cliente;
import modelo.Login;
import modelo.Compra;
import modelo.Hoteis;
import modelo.PacotesViagem;

public class Principal {

	public static void main(String[] args) {
		//DestinosDAO destDAO = new DestinosDAO();
		//Destinos dest1 = new Destinos (0, "Brasil", "São Paulo", "03/09/2022", "06/09/2022", "Belo Horizonte");
		//Destinos dest2 = new Destinos (0, "Brasil", "São Paulo", "10/09/2022", "20/09/2022", "Londres");
		//Destinos dest3 = new Destinos (0, "Brasil", "Curitiba", "12/10/2022", "20/10/2022", "São Paulo");
		//destDAO.save(dest3);
		// SAVE, DELETE E LISTAR - OK
		
		LoginDAO logDAO = new LoginDAO();
		Login log1 = new Login (0, "Administrador");
		//Login log2 = new Login (0, "Usuário");
		//Login log4 = new Login (2, "Usuário");
		logDAO.update(log1);
		//SAVE, LISTAR E DELETE OK
		
		//logDAO.save(log1);
		
		//ClienteDAO clienteDAO = new ClienteDAO(); 
		//Cliente cliente1 = new Cliente(0, "carol@admin.com", "Caroline Coser", "123admin", "458732-1", log1);
		//Cliente cliente2 = new Cliente(5, "thiago@user.com", "Thiago Silva", "12345", "4525632-1", log4);
		//Cliente cliente6 = new Cliente(2, "valter@user.com", "Valter Silva", "12345", "4525632-1", log4);
		//clienteDAO.update(cliente2);
		
		//HoteisDAO hotelDAO = new HoteisDAO();   
		//Hoteis hotel1 = new Hoteis(0, "Sim", 120, "Pousada1");
		//Hoteis hotel2 = new Hoteis(0, "Sim", 150, "Pousada2");
		//Hoteis hotel3 = new Hoteis(0, "Sim", 220, "Pousada3");
		//hotelDAO.save(hotel3);
		
				
		//PacotesDAO pacoteDAO = new PacotesDAO();
		//PacotesViagem pacote1 = new PacotesViagem(0, 600, true, hotel1, dest1);
		//pacoteDAO.save(pacote1);

	}

}
