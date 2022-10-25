package br.com.agencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.agencia.entities.Cliente;
import br.com.agencia.entities.Destinos;
import br.com.agencia.repositories.ClienteRepository;
import br.com.agencia.repositories.DestinosRepository;

@Controller
@RequestMapping("/destinos")
public class DestinosController {
	@Autowired
	private DestinosRepository destinosRepo;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("destinos/listar");
		
		List<Destinos> destinos = destinosRepo.findAll();
		modelAndView.addObject("destinos", destinos);
		
		return modelAndView;
	}

	//Chama a view "cadastro" e gera um objeto vazio da classe "destinos"
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("destinos/cadastro");
		modelAndView.addObject("destinos", new Destinos());
		return modelAndView;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Destinos destino) {
		ModelAndView mv = new ModelAndView("redirect:/destinos");
		destinosRepo.save(destino);
		return mv;
	}
	
	@GetMapping("/{id_destino}/excluir")
	public ModelAndView excluir(@PathVariable Long id_destino) {
		ModelAndView modelAndView = new ModelAndView("redirect:/destinos");
		destinosRepo.deleteById(id_destino);
		return modelAndView;
	}
	
	@GetMapping("/{id_destino}/editar")
	public ModelAndView editar(@PathVariable Long id_destino) {
		ModelAndView modelAndView = new ModelAndView("destinos/edicao");
		Destinos destinos = destinosRepo.getOne(id_destino);
		modelAndView.addObject("destinos", destinos);
		return modelAndView;
	}
	
	@PostMapping("/{id_destino}/editar")
	public ModelAndView editar(Destinos destinos) {
		ModelAndView modelAndView = new ModelAndView("redirect:/destinos");
		destinosRepo.save(destinos);
		return modelAndView;
	}
}
