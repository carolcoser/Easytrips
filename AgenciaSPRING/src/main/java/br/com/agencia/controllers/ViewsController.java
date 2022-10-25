package br.com.agencia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewsController {
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

	@GetMapping("/contato")
	public String contato() {
		return "contato";
	}

	@GetMapping("/destino")
	public String destino() {
		return "destino";
	}

	@GetMapping("/formCadastro")
	public String formCadastro() {
		return "formCadastro";
	}

	@GetMapping("/acesso")
	public String acesso() {
		return "acesso";
	}

	@GetMapping("/promoint")
	public String promoint() {
		return "promoint";
	}

	@GetMapping("/promonacional")
	public String promonacional() {
		return "promonacional";
	}

}
