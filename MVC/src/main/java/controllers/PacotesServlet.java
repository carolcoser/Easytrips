package controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PacotesDAO;
import model.PacotesViagem;
import dao.DestinosDAO;
import model.Destinos;
import dao.HoteisDAO;
import model.Hoteis;

@WebServlet(urlPatterns = { "/pacotes", "/create-pacote", "/edit-pacote", "/update-pacote", "/delete-pacote" })
public class PacotesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	PacotesDAO pacoteDao = new PacotesDAO();
	PacotesViagem pacote = new PacotesViagem();
	DestinosDAO destinoDao = new DestinosDAO();
	Destinos destino = new Destinos();
	HoteisDAO hoteisDao = new HoteisDAO();
	Hoteis hotel = new Hoteis();

	public PacotesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/pacotes":
			read(request, response);
			break;
		case "/create-pacote":
			create(request, response);
			break;
		case "/edit-pacote":
			edit(request, response);
			break;
		case "/update-pacote":
			update(request, response);
			break;
		case "/delete-pacote":
			delete(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PacotesViagem> listaPacotes = pacoteDao.getPacotes();

		request.setAttribute("pacotes", listaPacotes);

		RequestDispatcher rd = request.getRequestDispatcher("./views/Pacotes/index.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		pacote.setValor_pacote(Double.parseDouble(request.getParameter("valor_pacote")));
		pacote.setDestino(destinoDao.getDestinoById(Integer.parseInt("id_destino")));
		pacote.setHotel(hoteisDao.getHotelById(Integer.parseInt("hotel")));
		pacote.setPromo(request.getParameter("promo"));

		pacoteDao.save(pacote);
		response.sendRedirect("pacotes");
	}

	// EDIT
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pacote.setValor_pacote(Double.parseDouble(request.getParameter("valor_pacote")));
		pacote.setDestino(destinoDao.getDestinoById(Integer.parseInt("id_destino")));
		pacote.setHotel(hoteisDao.getHotelById(Integer.parseInt("hotel")));
		pacote.setPromo(request.getParameter("promo"));

		pacoteDao.update(pacote);
		response.sendRedirect("pacotes");
	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id_pacote"));

		pacote = pacoteDao.getPacoteById(id);

		request.setAttribute("valor_pacote", pacote.getValor_pacote());
		request.setAttribute("id_destino", pacote.getDestino().getId_destino());
		request.setAttribute("hotel", pacote.getHotel().getId_hotel());
		request.setAttribute("promo", pacote.getPromo());

		RequestDispatcher rd = request.getRequestDispatcher("./views/Pacotes/update.jsp");
		rd.forward(request, response);
	}

	// DELETE
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		pacoteDao.deleteById(id);
		response.sendRedirect("pacotes");
	}
}
