package controllers;

import java.io.IOException;
import java.util.List;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import dao.CompraDAO;
import dao.PacotesDAO;
import model.Cliente;
import model.Compra;
import model.PacotesViagem;


@WebServlet(urlPatterns = {"/compra", "/create-compra", "/edit-compra", "/update-compra", "/delete-compra"})
public class CompraServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	CompraDAO compraDao = new CompraDAO();
	Compra compra = new Compra();
	Cliente cliente = new Cliente();
	ClienteDAO cliDao = new ClienteDAO();
	PacotesViagem pacote = new PacotesViagem();
	PacotesDAO pctdao = new PacotesDAO();
	
	public CompraServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch (action) {
		case "/compra":
			read(request, response);
			break;
		case "/create-compra":
			create(request, response);
			break;
		case "/edit-compra":
			edit(request, response);
			break;
		case "/update-compra":
			update(request, response);
			break;
		case "/delete-compra":
			delete(request, response);
			break;
			
			default:
				response.sendRedirect("index.html");
				break;
		}
	}
	
	//READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Compra> listaCompras = compraDao.getCompra();
		
		request.setAttribute("compra", listaCompras);
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/Compras/index.jsp");
		rd.forward(request, response);
	}
	
	//CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		compra.setQtd_itens(Integer.parseInt(request.getParameter("qtd_itens")));
		compra.setDataCompra(request.getParameter("dataCompra"));
		pacote = pctdao.getPacoteById(Integer.parseInt(request.getParameter("id_pacote")));
		cliente.setId_cliente(Integer.parseInt(request.getParameter("id_cliente")));
		compra.setCliente(cliente);
		compra.setPacotes(pacote);
		compraDao.save(compra);
		response.sendRedirect("compra");
	}
	
	
	//EDIT
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		cliente.setId_cliente(Integer.parseInt(request.getParameter("id_cliente")));
		compra.setCliente(cliente);
		compra.setDataCompra(request.getParameter("dataCompra"));
		compra.setId_compra(Integer.parseInt(request.getParameter("id_compra")));
		pacote = pctdao.getPacoteById(Integer.parseInt(request.getParameter("id_pacote")));
		compra.setPacotes(pacote);
		compra.setQtd_itens(Integer.parseInt(request.getParameter("qtd_itens")));
		compraDao.update(compra);
		response.sendRedirect("compra");
	}
	
	//UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		int id_compra = Integer.parseInt(request.getParameter("id_compra"));
		compra = compraDao.getCompraById(id_compra);
		request.setAttribute("id_compra", compra.getId_compra());
		request.setAttribute("id_cliente", compra.id_cliente());
		request.setAttribute("dataCompra", compra.getDataCompra());
		request.setAttribute("id_pacote", compra.id_pacote());
		request.setAttribute("qtd_itens", compra.getQtd_itens());
		RequestDispatcher rd = request.getRequestDispatcher("./views/Compras/update.jsp");
		rd.forward(request, response);
	}
	
	//DELETE
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_compra = Integer.parseInt(request.getParameter("id_compra"));
		compraDao.deleteById(id_compra);
		response.sendRedirect("compra");
}
}
