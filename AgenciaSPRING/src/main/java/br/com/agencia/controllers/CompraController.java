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
import br.com.agencia.entities.Compra;
import br.com.agencia.repositories.ClienteRepository;
import br.com.agencia.repositories.CompraRepository;
import br.com.agencia.utils.SenhaUtils;

@Controller
@RequestMapping("/compras")
public class CompraController {
	@Autowired
	private CompraRepository compraRepo;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("compras/listar");
		
		List<Compra> compras = compraRepo.findAll();
		modelAndView.addObject("compras", compras);
		
		return modelAndView;
	}

	//Chama a view "cadastro" e gera um objeto vazio da classe "compra"
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("compras/cadastro");
		modelAndView.addObject("compras", new Compra());
		return modelAndView;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Compra compra) {
		ModelAndView mv = new ModelAndView("redirect:/compras");
		compraRepo.save(compra);
		return mv;
	}
	
	@GetMapping("/{id_compra}/excluir")
	public ModelAndView excluir(@PathVariable Long id_compra) {
		ModelAndView modelAndView = new ModelAndView("redirect:/compras");
		compraRepo.deleteById(id_compra);
		return modelAndView;
	}
	
	@GetMapping("/{id_compra}/editar")
	public ModelAndView editar(@PathVariable Long id_compra) {
		ModelAndView modelAndView = new ModelAndView("compras/edicao");
		Compra compra = compraRepo.getOne(id_compra);
		modelAndView.addObject("compras", compra);
		return modelAndView;
	}
	
	@PostMapping("/{id_compra}/editar")
	public ModelAndView editar(Compra compra) {
		ModelAndView modelAndView = new ModelAndView("redirect:/compras");
		compraRepo.save(compra);
		return modelAndView;
	}
}