package br.com.agencia.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agencia.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	Optional<Cliente> findByemailCliente(String emailCliente);
}
