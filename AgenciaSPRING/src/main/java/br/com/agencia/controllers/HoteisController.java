package br.com.agencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.agencia.entities.Hoteis;
import br.com.agencia.repositories.HoteisRepository;

@Controller
@RequestMapping("/hoteis")
public class HoteisController {
	@Autowired
	private HoteisRepository hoteisRepo;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("hoteis/listar");
		
		List<Hoteis> hoteis = hoteisRepo.findAll();
		modelAndView.addObject("hoteis", hoteis);
		
		return modelAndView;
	}

	//Chama a view "cadastro" e gera um objeto vazio da classe "hoteis"
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("hoteis/cadastro");
		modelAndView.addObject("hoteis", new Hoteis());
		return modelAndView;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Hoteis hotel) {
		ModelAndView mv = new ModelAndView("redirect:/hoteis");
		hoteisRepo.save(hotel);
		return mv;
	}
	
	@GetMapping("/{id_hotel}/excluir")
	public ModelAndView excluir(@PathVariable Long id_hotel) {
		ModelAndView modelAndView = new ModelAndView("redirect:/hoteis");
		hoteisRepo.deleteById(id_hotel);
		return modelAndView;
	}
	
	@GetMapping("/{id_hotel}/editar")
	public ModelAndView editar(@PathVariable Long id_hotel) {
		ModelAndView modelAndView = new ModelAndView("hoteis/edicao");
		Hoteis hoteis = hoteisRepo.getOne(id_hotel);
		modelAndView.addObject("hoteis", hoteis);
		return modelAndView;
	}
	
	@PostMapping("/{id_hotel}/editar")
	public ModelAndView editar(Hoteis hoteis) {
		ModelAndView modelAndView = new ModelAndView("redirect:/hoteis");
		hoteisRepo.save(hoteis);
		return modelAndView;
	}
}
