package controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDAO;
import model.Login;


@WebServlet(urlPatterns = {"/login", "/create-login", "/edit-login", "/update-login", "/delete-login"})
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	LoginDAO loginDao = new LoginDAO();
	Login login = new Login();
	
	public LoginServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch (action) {
		case "/login":
			read(request, response);
			break;
		case "/create-login":
			create(request, response);
			break;
		case "/edit-login":
			edit(request, response);
			break;
		case "/update-login":
			update(request, response);
			break;
		case "/delete-login":
			delete(request, response);
			break;
			
			default:
				response.sendRedirect("index.html");
				break;
		}
	}
	
	//READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Login> lista = loginDao.getLogin();
		
		request.setAttribute("login", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/Login/index.jsp");
		rd.forward(request, response);
	}
	
	//CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login.setTipoLogin(request.getParameter("tipoLogin"));
		loginDao.save(login);
		response.sendRedirect("login");
	}
	
	//EDIT
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	login.setId_login(Integer.parseInt(request.getParameter("id_login")));
	login.setTipoLogin(request.getParameter("tipoLogin"));
	loginDao.update(login);
	response.sendRedirect("login");
	}
	
	//UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		int id_login = Integer.parseInt(request.getParameter("id_login"));
		login = loginDao.getLoginById(id_login);
		request.setAttribute("id_login", login.getId_login());
		request.setAttribute("tipoLogin", login.getTipoLogin());
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/Login/update.jsp");
		rd.forward(request, response);
	}
	
	//DELETE
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_login = Integer.parseInt(request.getParameter("id_login"));
		loginDao.deleteById(id_login);
		response.sendRedirect("login");
}
}
