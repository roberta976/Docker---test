package br.ifpe.web2.controller;

import java.util.ArrayList;
import java.util.List;

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
public class ContatoController {
	@Autowired
	ContatoService contatoService;
	
	@Autowired
	GrupoService grupoService;
	
//	private List<Contato> contatos = new ArrayList<>();

	@GetMapping("/exibirContato")
	public String exibirForm(Contato contato, Grupo grupo, Model model) {
		List<Grupo> listaDeGrupos = grupoService.getGruposdeVisibilityPublic();
		model.addAttribute("lista", listaDeGrupos);
		return "contatos-form";
		
	}
	
	@PostMapping("/salvarContato")
	public String salvarContato(Contato contato) {
		contatoService.addContato(contato);
		System.out.println(contato);
		return "redirect:/listarContatos";
	}
	
	@GetMapping("/listarContatos")
	public String listarContatos(Model model) {
		//lista que vem do banco
		model.addAttribute("listaContatos", contatoService.listarTodosContatos());
		return "contatos-list";
	}
	
	@GetMapping("/removerContato")
	public String removerContato(Long id) {
		contatoService.delContato(id);
		return "redirect:/listarContatos";
//	
	}
	
	@GetMapping("/editarContato")
	public String editarContato(Long id, Model model) {
		
		Contato contatoAtualizado = contatoService.acharContatoPorId(id);
//		Contato contatoParaEditar = null;
//		for(Contato cont : this.contatos) {
//			if(cont.getEmail().equals(email)) {
//				contatoParaEditar = cont;
//			}
//		}
		contatoService.atualizarContato(id);
		model.addAttribute("contato", contatoAtualizado);
		return "contatos-form";
	}
}
