package crud;

import java.util.Scanner;
import dao.LoginDAO;
import modelo.Login;

public class LoginCRUD {

	public static void main(String[] args) {

		LoginDAO logdao = new LoginDAO();

		Scanner in = new Scanner(System.in);
		int oP = 0;
		int posicao = 0;

		int id_login = 0;
		String tipoLogin = "";

		do {
			System.out.println("=== Login CRUD ===");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Consultar");
			System.out.println("3 - Atualizar");
			System.out.println("4 - Deletar");
			System.out.println("5 - Buscar por ID");
			System.out.println("0 - Sair");
			oP = in.nextInt();

			switch (oP) {
			case 1:
				System.out.println("Digite o tipo do Acesso/Login: ");
				tipoLogin = in.next();

				Login login1 = new Login(id_login, tipoLogin);
				logdao.save(login1);

				System.out.println("\n Cadastro realizado com sucesso! \n");
				break;

			case 2:
				for (Login log : logdao.getLogin()) {
					System.out.println("ID: " + log.getId_login() + "Tipo de Acesso/Login: " + log.getTipoLogin());
				}
				System.out.println("Consulta finalizada!");
				break;

			case 3:
				System.out.println("Digite o ID Login que deseja atualizar: ");
				posicao = in.nextInt();
				System.out.println("Digite o novo tipo de acesso: ");
				tipoLogin = in.next();
				
				Login log2 = new Login(id_login, tipoLogin);
				logdao.update(log2);

				System.out.println("Informações atualizadas! " + log2.getTipoLogin());
				break;

			case 4:
				System.out.println("Digite o ID de Login: ");
				posicao = in.nextInt();

				logdao.deleteById(posicao);
				break;

			case 5:
				System.out.println("Digite o ID de Login: ");
				posicao = in.nextInt();

				Login log3 = logdao.getLoginById(posicao);
				System.out.println("ID: " + log3.getId_login() + "Tipo de Acesso/Login: " + log3.getTipoLogin());
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