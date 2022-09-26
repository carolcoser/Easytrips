package controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import model.Cliente;
import dao.LoginDAO;
import model.Login;

@WebServlet(urlPatterns = { "/clientes", "/create-cliente", "/edit-cliente", "/update-cliente", "/delete-cliente" })
public class ClienteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ClienteDAO clienteDao = new ClienteDAO();
	Cliente cliente = new Cliente();
	LoginDAO logdao = new LoginDAO();

	public ClienteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/clientes":
			read(request, response);
			break;
		case "/create-cliente":
			create(request, response);
			break;
		case "/edit-cliente":
			edit(request, response);
			break;
		case "/update-cliente":
			update(request, response);
			break;
		case "/delete-cliente":
			delete(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cliente> listaClientes = clienteDao.getCliente();

		request.setAttribute("clientes", listaClientes);

		RequestDispatcher rd = request.getRequestDispatcher("./views/Clientes/index.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		cliente.setNomeCliente(request.getParameter("nome"));
		cliente.setEmailCliente(request.getParameter("email"));
		cliente.setSenhaCliente(request.getParameter("senha"));
		cliente.setCpfCliente(request.getParameter("cpf"));
		cliente.setLogin(logdao.getLoginById(Integer.parseInt(request.getParameter("id_login")))); // id 2 = somente
																								// usuários
		clienteDao.save(cliente);
		response.sendRedirect("clientes");
	}

	// EDIT
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		cliente.setId_cliente(Integer.parseInt(request.getParameter("id_cliente")));
		cliente.setNomeCliente(request.getParameter("nome"));
		cliente.setEmailCliente(request.getParameter("email"));
		cliente.setSenhaCliente(request.getParameter("senha"));
		cliente.setCpfCliente(request.getParameter("cpf"));
		cliente.setLogin(logdao.getLoginById(Integer.parseInt(request.getParameter("id_login"))));

		clienteDao.update(cliente);
		response.sendRedirect("clientes");
	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id_cliente"));

		cliente = clienteDao.getClienteById(id);

		request.setAttribute("id", cliente.getId_cliente());
		request.setAttribute("nome", cliente.getNomeCliente());
		request.setAttribute("email", cliente.getEmailCliente());
		request.setAttribute("senha", cliente.getSenhaCliente());
		request.setAttribute("cpf", cliente.getCpfCliente());
		request.setAttribute("id_login", cliente.getLogin());

		RequestDispatcher rd = request.getRequestDispatcher("./views/Clientes/update.jsp");
		rd.forward(request, response);

	}

	// DELETE
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
		clienteDao.deleteById(id_cliente);
		response.sendRedirect("clientes");
	}
}
