package crud;

import java.util.Scanner;

import dao.DestinosDAO;
import dao.HoteisDAO;
import dao.PacotesDAO;
import modelo.Destinos;
import modelo.Hoteis;
import modelo.PacotesViagem;

public class PacotesCRUD {
	public static void main(String[] args) {

		PacotesDAO pacoteDAO = new PacotesDAO();
		HoteisDAO hotelDAO = new HoteisDAO();
		DestinosDAO destinoDAO = new DestinosDAO();

		Scanner in = new Scanner(System.in);
		int oP = 0;
		int posicao = 0;

		int id_pacote = 0;
		int id_destino = 0;
		int id_hotel = 0;
		String promo = "";
		double valorPacote = 0;

		do {
			System.out.println("=== EasyTrips CRUD ===");
			System.out.println("1 - Cadastrar novo Pacote de Viagem");
			System.out.println("2 - Consultar pacotes cadastrados");
			System.out.println("3 - Atualizar um pacote");
			System.out.println("4 - Deletar pacotes");
			System.out.println("5 - Buscar por ID");
			System.out.println("0 - Sair");
			oP = in.nextInt();

			switch (oP) {
			case 1:
				System.out.println("Qual o ID do destino?: ");
				id_destino = in.nextInt();
				System.out.println("Digite o ID do hotel: ");
				id_hotel = in.nextInt();
				System.out.println("Pacote promocional? ");
				promo = in.next();
				in.nextLine();
				System.out.println("Qual o valor?: ");
				valorPacote = in.nextDouble();

				Hoteis hotel1 = hotelDAO.getHotelById(id_hotel);
				Destinos destino1 = destinoDAO.getDestinoById(id_destino);
				PacotesViagem pct01 = new PacotesViagem(id_pacote, valorPacote, promo, hotel1, destino1);
				pacoteDAO.save(pct01);

				System.out.println("\n Cadastro realizado com sucesso! \n");
				break;

			case 2:
				for (PacotesViagem pct : pacoteDAO.getPacotes()) {
					System.out.println("ID: " + pct.getId_pacote() + "Destino: " + pct.getDestino().getNomeDestino()
							+ "Valor: " + pct.getValor_pacote() + "Saindo de: " + pct.getDestino().getCidade_origem()
							+ "Hospedagem no hotel: " + pct.getHotel().getNome_hotel());
				}
				System.out.println("Consulta finalizada!");
				break;

			case 3:
				System.out.println("Digite o ID do destino: ");
				id_destino = in.nextInt();
				System.out.println("Digite o ID do hotel: ");
				id_hotel = in.nextInt();
				System.out.println("Pacote promocional?: ");
				promo = in.nextLine();
				System.out.println("Digite o valor: ");
				valorPacote = in.nextDouble();

				Hoteis hotel01 = hotelDAO.getHotelById(id_hotel);
				Destinos destino01 = destinoDAO.getDestinoById(id_destino);

				PacotesViagem pct2 = new PacotesViagem(id_pacote, valorPacote, promo, hotel01, destino01);
				pacoteDAO.update(pct2);
				System.out.println("Informações atualizadas! " + pct2.getDestino());
				break;

			case 4:
				System.out.println("Digite o ID do pacote: ");
				posicao = in.nextInt();
				pacoteDAO.deleteById(posicao);
				break;

			case 5:
				System.out.println("Digite o ID do pacote: ");
				posicao = in.nextInt();

				PacotesViagem pct3 = pacoteDAO.getPacoteById(posicao);

				System.out.println("ID: " + pct3.getId_pacote() + "Destino: " + pct3.getDestino().getNomeDestino()
						+ "Valor: " + pct3.getValor_pacote() + "Saindo de: " + pct3.getDestino().getCidade_origem()
						+ "Hospedagem no hotel: " + pct3.getHotel().getNome_hotel());
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
