package br.com.empresa.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresa.entity.Turma;
import br.com.empresa.service.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaResource {
	
	@Autowired
	private TurmaService turmaService;
	
	    //@GetMapping    -> essa é uma forma q ela por se só ja basta, nao precisaria usar o RequestMapping como mostrado abaixo
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Turma>> listarTurmas() {
		List<Turma> turmas = turmaService.listarTodasTurmas();
		return ResponseEntity.ok().body(turmas);
	}
	
}
