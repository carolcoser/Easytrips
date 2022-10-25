package br.com.agencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agencia.entities.PacotesViagem;

public interface PacotesRepository extends JpaRepository<PacotesViagem, Long> {

}
