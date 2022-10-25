package br.com.agencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agencia.entities.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {

}
