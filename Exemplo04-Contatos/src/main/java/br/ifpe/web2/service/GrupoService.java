package br.ifpe.web2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.web2.dao.GrupoDAO;
import br.ifpe.web2.model.Contato;
import br.ifpe.web2.model.Grupo;

@Service
public class GrupoService {
	@Autowired
	GrupoDAO grupoDAO;
	
	//Listar todos os Grupos
		public List<Grupo> getGruposdeVisibilityPublic(){
			
				return grupoDAO.findByVisibilidade("publico");
//				if (grupo.getVisibilidade() == "publico") {
//					return grupoDAO.findGrupoByVisibilityPublic(grupo);
//				}
//				return null;
	
			
			
		}
		public ArrayList<Grupo> listarTodosGrupos(){
			return (ArrayList<Grupo>) grupoDAO.findAll();
		}
		public void addGrupo(Grupo grupo) {
			grupoDAO.save(grupo);
			System.out.println("grupo com id: " + grupo.getId() + " adicionado");
		}
		public void delGrupo(Long id) {
			Grupo grupoParaDeletar = grupoDAO.getById(id);
			grupoDAO.delete(grupoParaDeletar);
			System.out.println("grupo com id: " + id + " deletado");
			
		}
		public void atualizarGrupo(Long id) {
			Grupo grupoParaAtualizar = grupoDAO.getById(id);
		
			System.out.println("Grupo com id: " + id + " atualizado");
			System.out.println(grupoParaAtualizar);
			
		}
		public Grupo acharGrupoPorId(Long id) {
			Grupo grupo = grupoDAO.getById(id);
			try {
				return grupo;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return grupo;
			
		}
}
