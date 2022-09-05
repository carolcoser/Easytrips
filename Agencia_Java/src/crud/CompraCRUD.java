package crud;

import java.util.Scanner;

import dao.PacotesDAO;
import modelo.PacotesViagem;
import modelo.Compra;
import dao.CompraDAO;
import dao.ClienteDAO;
import modelo.Cliente;

public class CompraCRUD {
	public static void main(String[] args) {

		PacotesDAO pacoteDAO = new PacotesDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		CompraDAO compraDAO = new CompraDAO();

		Scanner in = new Scanner(System.in);
		int oP = 0;
		int posicao = 0;

		int id_pacote = 0;
		int id_cliente = 0;
		int id_compra = 0;
		double valor_itens = 0;
		int qtd_itens = 0;
		double valorCompra = 0;
		String dataCompra = "";

		do {
			System.out.println("=== Compra CRUD ===");
			System.out.println("1 - Cadastrar nova compra");
			System.out.println("2 - Consultar compras");
			System.out.println("3 - Atualizar compra");
			System.out.println("4 - Deletar compra");
			System.out.println("5 - Buscar por ID");
			System.out.println("0 - Sair");
			oP = in.nextInt();

			switch (oP) {
			case 1:
				System.out.println("Digite o ID do pacote: ");
				id_pacote = in.nextInt();
				System.out.println("Digite o ID do cliente: ");
				id_cliente = in.nextInt();
				System.out.println("Digite a data da compra: ");
				dataCompra = in.next();
				System.out.println("Digite a quantidade do item: ");
				qtd_itens = in.nextInt();
				System.out.println("Digite o valor do item: ");
				valor_itens = in.nextDouble();
				System.out.println("Digite o valor da compra:R$ ");
				valorCompra = in.nextDouble();

				PacotesViagem pacote1 = pacoteDAO.getPacoteById(id_pacote);
				Cliente cliente1 = clienteDAO.getClienteById(id_cliente);
				Compra compra1 = new Compra(id_compra, pacote1, cliente1, valor_itens, qtd_itens, dataCompra, valorCompra);
				compraDAO.save(compra1);

				System.out.println("\n Cadastro realizado com sucesso! \n");
				break;

			case 2:
				for (Compra comp : compraDAO.getCompra()) {
					System.out.println("ID: " + comp.getId_compra() + "Pacote: " + comp.getPacotes().getId_pacote()
							+ "ID Cliente: " + comp.getCliente().getId_cliente() + "Valor do item: " + comp.getValor_itens()
							+ "Quantidade de itens: " + comp.getQtd_itens() + "Data da compra: " + comp.getDataCompra()
							+ "Valor total: " + comp.getValorCompra());
				}
				System.out.println("Consulta finalizada!");
				break;

			case 3:
				System.out.println("Digite o ID do pacote: ");
				id_pacote = in.nextInt();
				System.out.println("Digite o ID do cliente: ");
				id_cliente = in.nextInt();
				System.out.println("Digite a data da compra: ");
				dataCompra = in.next();
				System.out.println("Digite a quantidade do item: ");
				qtd_itens = in.nextInt();
				System.out.println("Digite o valor do item: ");
				valor_itens = in.nextDouble();
				System.out.println("Digite o valor da compra:R$ ");
				valorCompra = in.nextDouble();

				PacotesViagem pacote2 = pacoteDAO.getPacoteById(id_pacote);
				Cliente cliente2 = clienteDAO.getClienteById(id_cliente);

				Compra comp2 = new Compra(id_compra, pacote2, cliente2, valor_itens, qtd_itens, dataCompra, valorCompra);
				compraDAO.update(comp2);
				System.out.println("Informações atualizadas!");
				break;

			case 4:
				System.out.println("Digite o ID da compra: ");
				posicao = in.nextInt();
				compraDAO.deleteById(posicao);
				break;

			case 5:
				System.out.println("Digite o ID da compra: ");
				posicao = in.nextInt();

				Compra comp3 = compraDAO.getCompraById(posicao);

				System.out.println("ID: " + comp3.getId_compra() + "Pacote: " + comp3.getPacotes().getId_pacote()
						+ "ID Cliente: " + comp3.getCliente().getId_cliente() + "Valor do item: " + comp3.getValor_itens()
						+ "Quantidade de itens: " + comp3.getQtd_itens() + "Data da compra: " + comp3.getDataCompra()
						+ "Valor total: " + comp3.getValorCompra());
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
