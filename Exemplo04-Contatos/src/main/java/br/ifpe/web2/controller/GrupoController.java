package br.ifpe.web2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.web2.model.Contato;
import br.ifpe.web2.model.Grupo;
import br.ifpe.web2.service.ContatoService;
import br.ifpe.web2.service.GrupoService;

@Controller
public class GrupoController {
	@Autowired
	GrupoService grupoService;
	
//	private List<Contato> contatos = new ArrayList<>();

	@GetMapping("/exibirGrupo")
	public String exibirGrupo(Grupo grupo) {
		return "grupo-form";
		
	}
	@PostMapping("/salvarGrupo")
	public String salvarGrupo(Grupo grupo) {
		grupoService.addGrupo(grupo);
		System.out.println(grupo);
		return "redirect:/listarGrupos";
	}
	@GetMapping("/listarGrupos")
	public String listarGrupos(Model model) {
		//lista que vem do banco
		model.addAttribute("listaGrupos", grupoService.listarTodosGrupos());
		return "grupo-list";
	}
	@GetMapping("/removerGrupo")
	public String removerGrupo(Long id) {
		grupoService.delGrupo(id);
		return "redirect:/listarGrupos";
//	
	}
	
	@GetMapping("/editarGrupo")
	public String editarGrupo(Long id, Model model) {
		
		Grupo grupoAtualizado = grupoService.acharGrupoPorId(id);
//		Contato contatoParaEditar = null;
//		for(Contato cont : this.contatos) {
//			if(cont.getEmail().equals(email)) {
//				contatoParaEditar = cont;
//			}
//		}
		grupoService.atualizarGrupo(id);
		model.addAttribute("grupo", grupoAtualizado);
		return "grupo-form";
	}
}
