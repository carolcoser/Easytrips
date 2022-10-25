package br.com.agencia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.agencia.entities.Cliente;
import br.com.agencia.entities.UserDetailsImpl;
import br.com.agencia.repositories.ClienteRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private ClienteRepository clienteRepo;

	@Override
	public UserDetails loadUserByUsername(String emailCliente) throws UsernameNotFoundException {
		Cliente cliente = clienteRepo.findByemailCliente(emailCliente)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
		return cliente;
	}

}
