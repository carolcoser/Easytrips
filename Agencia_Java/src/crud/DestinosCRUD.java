package crud;

import java.util.Scanner;

import dao.DestinosDAO;
import modelo.Destinos;

public class DestinosCRUD {
	public static void main(String[] args) {
		DestinosDAO destinoDAO = new DestinosDAO();

		Scanner in = new Scanner(System.in);
		int oP = 0;
		int posicao = 0;

		String data_volta;
		String data_ida;
		int id_destino = 0;
		String pais = "";
		String cidadeOrigem = "";
		String nomeDestino = "";

		do {
			System.out.println("=== CRUD Destinos ===");
			System.out.println("1- Cadastrar Destino");
			System.out.println("2- Consultar Destino");
			System.out.println("3- Atualizar Destino");
			System.out.println("4- Deletar Destino");
			System.out.println("5- Buscar por ID");
			System.out.println("0- Sair");
			oP = in.nextInt();

			switch (oP) {
			case 1:
				System.out.println("Digite o nome da cidade de destino: ");
				nomeDestino = in.next();
				System.out.println("Digite o país de destino: ");
				pais = in.nextLine();
				in.next();
				System.out.println("Digite a cidade de origem: ");
				cidadeOrigem = in.next();
				System.out.println("Digite a data de ida: ");
				data_ida = in.next();
				in.next();
				System.out.println("Digite a data da volta: ");
				data_volta = in.next();
				
				Destinos d1 = new Destinos(id_destino, pais, cidadeOrigem, data_ida, data_volta, nomeDestino);
				destinoDAO.save(d1);
				System.out.println("\n Cadastro realizado com sucesso! \n");
				break;

			case 2:
				for (Destinos d : destinoDAO.getDestinos()) {
					System.out.println("ID: " + d.getId_destino() + "\n Cidade: " + d.getNomeDestino() + "\n País: " + d.getPais()
					+ "\n Origem: " + d.getCidade_origem() + "\n Data de partida: " + d.getData_ida() + "\n Data de retorno: " + d.getData_volta());
					System.out.println("\n Consulta finalizada! \n");
				}
					break;

			case 3:
				System.out.println("Digite o ID do destino: ");
				id_destino = in.nextInt();
				System.out.println("Digite o nome do destino: ");
				nomeDestino = in.next();
				System.out.println("Digite o país de destino: ");
				pais = in.next();
				System.out.println("Digite a cidade de origem: ");
				cidadeOrigem = in.next();
				System.out.println("Digite a data de ida: ");
				data_ida = in.next();
				System.out.println("Digite a data da volta: ");
				data_volta = in.next();

				Destinos d2 = new Destinos(id_destino, pais, cidadeOrigem, data_ida, data_volta, nomeDestino);
				destinoDAO.update(d2);
				System.out.println("\n Informações atualizadas!\n " + d2.getNomeDestino());
				break;

			case 4:
				System.out.println("Digite o ID do destino: ");
				posicao = in.nextInt();
				destinoDAO.deleteById(posicao);
				break;

			case 5:
				System.out.println("Digite o ID do destino: ");
				posicao = in.nextInt();

				Destinos d3 = destinoDAO.getDestinoById(posicao);
				System.out.println("  ID: " + d3.getId_destino() + "\n Cidade: " + d3.getNomeDestino() + "\\nPaís: " + d3.getPais()
				+ "\\nOrigem: " + d3.getCidade_origem() + "\\nData de partida: " + d3.getData_ida() + "\\nData de retorno: " + d3.getData_volta());
				break;

				default:
					System.out.println(oP != 0 ?  "Opção inválida, digite novamente." : "");
					break;
				}

		} while (oP != 0);

		System.out.println("Finalizado.");
		in.close();

	}
}
