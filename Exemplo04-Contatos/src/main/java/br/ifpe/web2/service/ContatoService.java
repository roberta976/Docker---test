package br.ifpe.web2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.web2.dao.ContatoDAO;
import br.ifpe.web2.model.Contato;

@Service
public class ContatoService {
	
	@Autowired
	ContatoDAO contatoDAO;
	
	
	//Listar todos os contatos
	public ArrayList<Contato> listarTodosContatos(){
		return (ArrayList<Contato>) contatoDAO.findAll();
	}
	public void addContato(Contato contato) {
		contatoDAO.save(contato);
		System.out.println("Contato com id: " + contato.getId() + " adicionado");
	}
	public void delContato(Long id) {
		Contato contatoParaDeletar = contatoDAO.getById(id);
		contatoDAO.delete(contatoParaDeletar);
		System.out.println("Contato com id: " + id + " deletado");
		
	}
	public void atualizarContato(Long id) {
		Contato contatoParaAtualizar = contatoDAO.getById(id);
	
		System.out.println("Contato com id: " + id + " atualizado");
		System.out.println(contatoParaAtualizar);
		
	}
	public Contato acharContatoPorId(Long id) {
		Contato contato = contatoDAO.getById(id);
		return contato;
		
	}
}
