package br.ifpe.web2.model;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Grupo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeDoGrupo;
	private String visibilidade;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dataExpiracao;
	//COLOCAR UM ARRAYLIST DE CONTATOS? 
	
	//GET E SET
	

	public String getNomeDoGrupo() {
		return nomeDoGrupo;
	}
	public void setNomeDoGrupo(String nomeDoGrupo) {
		this.nomeDoGrupo = nomeDoGrupo;
	}

	public Date getDataExpiracao() {
		return dataExpiracao;
	}
	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVisibilidade() {
		return visibilidade;
	}
	public void setVisibilidade(String visibilidade) {
		this.visibilidade = visibilidade;
	}

	
}



