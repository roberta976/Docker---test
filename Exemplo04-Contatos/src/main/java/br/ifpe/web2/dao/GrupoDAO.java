package br.ifpe.web2.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import br.ifpe.web2.model.Grupo;

public interface GrupoDAO extends JpaRepository<Grupo, Long>{
//	public List<Grupo> findGrupoByVisibilityPublic(Grupo grupo);
	List<Grupo> findByVisibilidade(String visibilidade);
}
