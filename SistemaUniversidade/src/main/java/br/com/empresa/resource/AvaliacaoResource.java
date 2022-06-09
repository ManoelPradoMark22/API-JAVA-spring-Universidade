package br.com.empresa.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresa.entity.Avaliacao;
import br.com.empresa.service.AvaliacaoService;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoResource {
	
	@Autowired
	private AvaliacaoService avaliacaoService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Avaliacao>> listarAvaliacoes(){
		List<Avaliacao> avaliacoes = avaliacaoService.findAll();
		return ResponseEntity.ok().body(avaliacoes);
	}
	
}
