package br.com.agencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agencia.entities.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

}
