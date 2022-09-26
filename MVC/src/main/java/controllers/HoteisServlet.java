package controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HoteisDAO;
import model.Hoteis;



@WebServlet(urlPatterns = {"/hoteis", "/create-hotel", "/edit-hotel", "/update-hotel", "/delete-hotel"})
public class HoteisServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	HoteisDAO hoteisDao = new HoteisDAO();
	Hoteis hotel = new Hoteis();
	
	public HoteisServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch (action) {
		case "/hoteis":
			read(request, response);
			break;
		case "/create-hotel":
			create(request, response);
			break;
		case "/edit-hotel":
			edit(request, response);
			break;
		case "/update-hotel":
			update(request, response);
			break;
		case "/delete-hotel":
			delete(request, response);
			break;
			
			default:
				response.sendRedirect("index.html");
				break;
		}
	}
	
	//READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Hoteis> listaHoteis = hoteisDao.getHoteis();
		
		request.setAttribute("hoteis", listaHoteis);
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/Hoteis/index.jsp");
		rd.forward(request, response);
	}
	
	//CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		hotel.setCafeDaManha(request.getParameter("cafeDaManha"));
		hotel.setValor_diaria(Double.parseDouble(request.getParameter("valor_diaria")));
		hotel.setNome_hotel(request.getParameter("nome_hotel"));
		hoteisDao.save(hotel);
		response.sendRedirect("hoteis");
	}
	
	//EDIT
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_hotel = Integer.parseInt(request.getParameter("id_hotel"));
		hotel.setCafeDaManha(request.getParameter("cafeDaManha"));
		hotel.setValor_diaria(Double.parseDouble(request.getParameter("valor_diaria")));
		hotel.setNome_hotel(request.getParameter("nome_hotel"));
		
		hoteisDao.update(hotel);
		response.sendRedirect("hoteis");
	}
	
	//UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		int id_hotel = Integer.parseInt(request.getParameter("id_hotel"));
		hotel = hoteisDao.getHotelById(id_hotel);
		request.setAttribute("cafeDaManha", hotel.getCafeDaManha());
		request.setAttribute("valor_diaria", hotel.getValor_diaria());
		request.setAttribute("nome_hotel", hotel.getNome_hotel());
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/Hoteis/update.jsp");
	}
	
	//DELETE
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		hoteisDao.deleteById(id);
		response.sendRedirect("hoteis");
}
}
