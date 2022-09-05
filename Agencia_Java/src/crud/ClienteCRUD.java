package crud;

import java.util.Scanner;

import modelo.Login;
import dao.LoginDAO;
import modelo.Cliente;
import dao.ClienteDAO;

public class ClienteCRUD {

	public static void main(String[] args) {

		ClienteDAO clienteDAO = new ClienteDAO();
		LoginDAO logdao = new LoginDAO();
		
		Scanner in = new Scanner(System.in);
		int oP = 0;
		int posicao = 0;

		int id_cliente = 0;
		int id_login = 0;
		String tipoLogin = "";
		String emailCliente = "";
		String senhaCliente = "";
		String cpfCliente = "";
		String nomeCliente = "";

		do {
			System.out.println("=== Clientes CRUD ===");
			System.out.println("1 - Cadastrar novo cliente");
			System.out.println("2 - Consultar clientes cadastrados");
			System.out.println("3 - Atualizar dados cliente");
			System.out.println("4 - Deletar cliente");
			System.out.println("5 - Buscar por ID");
			System.out.println("0 - Sair");
			oP = in.nextInt();

			switch (oP) {
			case 1:
				System.out.println("Informe o ID do Login: ");
				id_login = in.nextInt();
				System.out.println("Digite o nome do cliente: ");
				nomeCliente = in.next();
				in.nextLine();
				System.out.println("Informe o CPF: ");
				cpfCliente = in.nextLine();
				System.out.println("Digite o email do cliente: ");
				emailCliente = in.nextLine();
				System.out.println("Digite a senha: ");
				senhaCliente = in.nextLine();

				Login login1 = new Login(id_login, tipoLogin);
				Cliente cliente1 = new Cliente(id_cliente, emailCliente, nomeCliente, senhaCliente, cpfCliente, login1);
				clienteDAO.save(cliente1);
				
				System.out.println("\n Cadastro realizado com sucesso! \n");
				break;

			case 2:
				for (Cliente c : clienteDAO.getCliente()) {
					System.out.println("ID Cliente: " + c.getId_cliente() + " Nome: " + c.getNomeCliente() + " ID Login: "
							+ c.getLogin() + " Email cadastrado: " + c.getEmailCliente() + " CPF: "
							+ c.getCpfCliente() + " Senha de acesso: " + c.getSenhaCliente());
				}
				System.out.println("Consulta finalizada!");
				break;

			case 3:
				System.out.println("Informe o ID do Cliente para atualizar: ");
				id_cliente = in.nextInt();
				System.out.println("Digite o ID Login: ");
				id_login = in.nextInt();
				in.nextLine();
				Login login2 = logdao.getLoginById(id_login);
				System.out.println("Digite o nome do cliente: ");
				nomeCliente = in.next();
				in.nextLine();
				System.out.println("Informe o CPF: ");
				cpfCliente = in.next();
				in.nextLine();
				System.out.println("Digite o email do cliente: ");
				emailCliente = in.next();
				in.nextLine();
				System.out.println("Digite a senha: ");
				senhaCliente = in.nextLine();
				
			
				Cliente cliente2 = new Cliente(id_cliente, emailCliente, nomeCliente, senhaCliente, cpfCliente, login2);
				clienteDAO.update(cliente2);
				System.out.println("Informações atualizadas!");
				break;

			case 4:
				System.out.println("Digite o ID do cliente: ");
				posicao = in.nextInt();
				clienteDAO.deleteById(posicao);
				break;

			case 5:
				System.out.println("Digite o ID do cliente: ");
				posicao = in.nextInt();
				
				Cliente cliente3 = clienteDAO.getClienteById(posicao);

				System.out.println("ID: " + cliente3.getId_cliente() + "Nome: " + cliente3.getNomeCliente() + "Tipo de cadastro: "
						+ cliente3.getLogin().getTipoLogin() + "Email cadastrado: " + cliente3.getEmailCliente() + "CPF: "
						+ cliente3.getCpfCliente() + "Senha de acesso: " + cliente3.getSenhaCliente());
				break;

			default:
				System.out.println(oP != 0 ? "Opção inválida, digite novamente." : "");
				break;
			}
		} while (oP != 0);

		System.out.println("Finalizado.");
		in.close();
	}

}
