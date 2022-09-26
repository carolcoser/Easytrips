package controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinosDAO;
import model.Destinos;



@WebServlet(urlPatterns = {"/destinos", "/create-destino", "/edit-destino", "/update-destino", "/delete-destino"})
public class DestinosServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	DestinosDAO destinosDao = new DestinosDAO();
	Destinos destino = new Destinos();
	
	public DestinosServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch (action) {
		case "/destinos":
			read(request, response);
			break;
		case "/create-destino":
			create(request, response);
			break;
		case "/edit-destino":
			edit(request, response);
			break;
		case "/update-destino":
			update(request, response);
			break;
		case "/delete-destino":
			delete(request, response);
			break;
			
			default:
				response.sendRedirect("index.html");
				break;
		}
	}
	
	//READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Destinos> listaDestinos = destinosDao.getDestinos();
		
		request.setAttribute("destinos", listaDestinos);
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/Destinos/index.jsp");
		rd.forward(request, response);
	}
	
	//CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		destino.setData_volta(request.getParameter("data_volta"));
		destino.setData_ida(request.getParameter("data_ida"));
		destino.setPais(request.getParameter("pais"));
		destino.setCidade_origem(request.getParameter("cidade_origem"));
		destino.setNomeDestino(request.getParameter("nomeDestino"));
		destinosDao.save(destino);
		response.sendRedirect("destinos");
	}
	
	//EDIT
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_destino = Integer.parseInt(request.getParameter("id_destino"));
		destino.setId_destino(id_destino);
		destino.setData_volta(request.getParameter("data_volta"));
		destino.setData_ida(request.getParameter("data_ida"));
		destino.setPais(request.getParameter("pais"));
		destino.setCidade_origem(request.getParameter("cidade_origem"));
		destino.setNomeDestino(request.getParameter("nomeDestino"));
		
		destinosDao.update(destino);
		response.sendRedirect("destinos");
	}
	
	//UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		int id_destino = Integer.parseInt(request.getParameter("id_destino"));
		destino = destinosDao.getDestinoById(id_destino);
		request.setAttribute("id_destino", destino.getId_destino());
		request.setAttribute("data_volta", destino.getData_volta());
		request.setAttribute("data_ida", destino.getData_ida());
		request.setAttribute("pais", destino.getPais());
		request.setAttribute("cidade_origem", destino.getCidade_origem());
		request.setAttribute("nomeDestino", destino.getNomeDestino());
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/Destinos/update.jsp");
		rd.forward(request, response);
	}
	
	//DELETE
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		destinosDao.deleteById(id);
		response.sendRedirect("destinos");
}
}
