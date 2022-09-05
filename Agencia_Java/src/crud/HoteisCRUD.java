package crud;

import java.util.Scanner;

import dao.HoteisDAO;
import modelo.Hoteis;

public class HoteisCRUD {
	public static void main(String[] args) {
		HoteisDAO hotelDAO = new HoteisDAO();

		Scanner in = new Scanner(System.in);
		int oP = 0;
		int posicao = 0;
		int id_hotel = 0;
		String nome_hotel = "";
		double diaria = 0;
		String cafe = "";


		do {
			System.out.println("=== CRUD Hoteis ===");
			System.out.println("1 - Cadastrar Hotel");
			System.out.println("2 - Consultar Hotel");
			System.out.println("3 - Atualizar informações de um Hotel");
			System.out.println("4 - Deletar Hotel");
			System.out.println("5 - Buscar por ID");
			System.out.println("0 - Sair");
			oP = in.nextInt();

			switch(oP) {
			case 1:
				//SAVE-CREATE
				System.out.println("Digite o nome do hotel: ");
				nome_hotel = in.next();
				System.out.println("Digite o valor da diária: R$ ");
				diaria = in.nextDouble();
				in.next();
				System.out.println("Café da manhã incluso?");
				cafe = in.next();

				Hoteis h1 = new Hoteis(id_hotel, nome_hotel, diaria, cafe);
				hotelDAO.save(h1);
				System.out.println("\n Cadastro realizado com sucesso! \n");
				break;

				//READ
			case 2:
				for (Hoteis h : hotelDAO.getHoteis()) {
					System.out.println("ID: " + h.getId_hotel() + "Nome: " + h.getNome_hotel() + "Valor da diária: " + h.getValor_diaria()
					+ "Café da manhã incluso?: " + h.getCafeDaManha());
				}
				System.out.println("Consulta finalizada!");
				break;

			case 3:
				//UPDATE
				System.out.println("Digite o ID do Hotel: ");
				posicao = in.nextInt();
				System.out.println("Digite o nome do Hotel: ");
				nome_hotel = in.next();
				System.out.println("Digite o valor da diária: R$");
				diaria = in.nextDouble();
				System.out.println("Café da manhã incluso?: ");
				cafe = in.next();

				Hoteis h2 = new Hoteis(id_hotel, nome_hotel, diaria, cafe);
				hotelDAO.update(h2);

				System.out.println("Informações atualizadas! " + h2.getNome_hotel());
				break;

			case 4:
				//DELETE
				System.out.println("Digite o ID do Hotel: ");
				posicao = in.nextInt();
				hotelDAO.deleteById(posicao);
				break;

			case 5:
				//BUSCA PELO ID
				System.out.println("Digite o ID do Hotel: ");
				posicao = in.nextInt();

				Hoteis h3 = hotelDAO.getHotelById(posicao);

				System.out.println("ID: " + h3.getId_hotel() + "Nome: " + h3.getNome_hotel()
				+ "Valor da diária: R$" + h3.getValor_diaria() + "Café da manhã incluso?: " + h3.getCafeDaManha());
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
