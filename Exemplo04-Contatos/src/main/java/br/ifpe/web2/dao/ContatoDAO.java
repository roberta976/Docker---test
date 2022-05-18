package br.ifpe.web2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.web2.model.Contato;

public interface ContatoDAO extends JpaRepository<Contato, Long> {
	
//	Contato findById(Long id);
}
