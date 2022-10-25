package br.com.agencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.agencia.entities.Login;
import br.com.agencia.repositories.LoginRepository;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginRepository loginRepo;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("login/listar");
		
		List<Login> login = loginRepo.findAll();
		modelAndView.addObject("login", login);
		
		return modelAndView;
	}

	//Chama a view "cadastro" e gera um objeto vazio da classe "login"
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("login/cadastro");
		modelAndView.addObject("login", new Login());
		return modelAndView;
	}
	
	
	@GetMapping("/{id_login}/excluir")
	public ModelAndView excluir(@PathVariable Long id_login) {
		ModelAndView modelAndView = new ModelAndView("redirect:/login");
		loginRepo.deleteById(id_login);
		return modelAndView;
	}
	
	@GetMapping("/{id_login}/editar")
	public ModelAndView editar(@PathVariable Long id_login) {
		ModelAndView modelAndView = new ModelAndView("login/edicao");
		Login login = loginRepo.getOne(id_login);
		modelAndView.addObject("login", login);
		return modelAndView;
	}
	
	@PostMapping("/{id_login}/editar")
	public ModelAndView editar(Login login) {
		ModelAndView modelAndView = new ModelAndView("redirect:/login");
		loginRepo.save(login);
		return modelAndView;
	}
}

