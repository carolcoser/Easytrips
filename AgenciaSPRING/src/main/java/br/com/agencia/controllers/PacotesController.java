package br.com.agencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.agencia.entities.PacotesViagem;
import br.com.agencia.repositories.PacotesRepository;

@Controller
@RequestMapping("/pacotes")
public class PacotesController {
	@Autowired
	private PacotesRepository pacotesRepo;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("pacotes/listar");
		
		List<PacotesViagem> pacotes = pacotesRepo.findAll();
		modelAndView.addObject("pacotes", pacotes);
		
		return modelAndView;
	}

	//Chama a view "cadastro" e gera um objeto vazio da classe "pacotes"
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("pacotes/cadastro");
		modelAndView.addObject("pacotes", new PacotesViagem());
		return modelAndView;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(PacotesViagem pacote) {
		ModelAndView mv = new ModelAndView("redirect:/pacotes");
		pacotesRepo.save(pacote);
		return mv;
	}
	
	@GetMapping("/{id_pacote}/excluir")
	public ModelAndView excluir(@PathVariable Long id_pacote) {
		ModelAndView modelAndView = new ModelAndView("redirect:/pacotes");
		pacotesRepo.deleteById(id_pacote);
		return modelAndView;
	}
	
	@GetMapping("/{id_pacote}/editar")
	public ModelAndView editar(@PathVariable Long id_pacote) {
		ModelAndView modelAndView = new ModelAndView("pacotes/edicao");
		PacotesViagem pacotes = pacotesRepo.getOne(id_pacote);
		modelAndView.addObject("pacotes", pacotes);
		return modelAndView;
	}
	
	@PostMapping("/{id_pacote}/editar")
	public ModelAndView editar(PacotesViagem pacotes) {
		ModelAndView modelAndView = new ModelAndView("redirect:/pacotes");
		pacotesRepo.save(pacotes);
		return modelAndView;
	}
}
