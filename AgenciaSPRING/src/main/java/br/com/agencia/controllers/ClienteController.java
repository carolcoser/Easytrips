package br.com.agencia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.agencia.entities.Cliente;
import br.com.agencia.entities.Login;
import br.com.agencia.repositories.ClienteRepository;
import br.com.agencia.repositories.LoginRepository;
import br.com.agencia.security.WebConfigSecurity;
import br.com.agencia.utils.SenhaUtils;

@Controller
@RequestMapping(value = "/clientes")
public class ClienteController {
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private WebConfigSecurity passwordEncoder;
	
	//GET
	@GetMapping
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("clientes/listar");
		List<Cliente> clientes = clienteRepo.findAll();
		mv.addObject("clientes", clientes);
		return mv;
	}

	//Chama a view "cadastro" e gera um objeto vazio da classe "cliente"
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView("clientes/cadastro");
		mv.addObject("cliente", new Cliente());
		return mv;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Cliente cliente) {
		ModelAndView mv = new ModelAndView("redirect:/clientes");
		String senhaCliente = SenhaUtils.encode(cliente.getSenhaCliente());
		cliente.setSenhaCliente(senhaCliente);
		clienteRepo.save(cliente);
		return mv;
	}
	
	@GetMapping("/{id_cliente}/excluir")
	public ModelAndView excluir(@PathVariable Long id_cliente) {
		ModelAndView mv = new ModelAndView("redirect:/clientes");
		clienteRepo.deleteById(id_cliente);
		return mv;
	}
	
	@GetMapping("/{id_cliente}/editar")
	public ModelAndView editar(@PathVariable Long id_cliente) {
		ModelAndView mv = new ModelAndView("clientes/edicao");
		Cliente cliente = clienteRepo.getOne(id_cliente);
		mv.addObject("clientes", cliente);
		return mv;
	}
	
	@PostMapping("/{id_cliente}/editar")
	public ModelAndView editar(Cliente cliente) {
		ModelAndView mv = new ModelAndView("redirect:/clientes");
		String senhaCliente = SenhaUtils.encode(cliente.getSenhaCliente());
		cliente.setSenhaCliente(senhaCliente);
		clienteRepo.save(cliente);
		return mv;
	}
}