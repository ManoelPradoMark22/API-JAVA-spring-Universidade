package br.com.empresa.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresa.entity.Disciplina;
import br.com.empresa.service.DisciplinaService;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaResource {
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Disciplina>> listarDisciplinas() {
		List<Disciplina> disciplinas = disciplinaService.listarTodasDisciplinas();
		return ResponseEntity.ok().body(disciplinas);
	}

}
