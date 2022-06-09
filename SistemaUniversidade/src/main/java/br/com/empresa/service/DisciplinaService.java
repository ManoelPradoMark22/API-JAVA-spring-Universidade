package br.com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.entity.Disciplina;
import br.com.empresa.repository.DisciplinaRepo;



@Service
public class DisciplinaService {
	
	@Autowired
	DisciplinaRepo repo;
	
	public List<Disciplina> listarTodasDisciplinas() {
		return repo.findAll();
	}
	
	public Disciplina salvar(Disciplina disciplina) {
		return repo.save(disciplina);
	}
	
	public Disciplina buscaPorID(Integer id) throws ObjectNotFoundException {
		Optional<Disciplina> disciplina = repo.findById(id);
		return disciplina.orElseThrow(() -> new ObjectNotFoundException(null, "Disciplina não encontrada"));
	}
	
	public Disciplina alterar(Disciplina objDisciplina) {
		Disciplina disciplinaDoBD = buscaPorID(objDisciplina.getId());
		disciplinaDoBD.setNome(objDisciplina.getNome());
		return salvar(disciplinaDoBD);
	}
	
	public void excluir(Integer id) {
		repo.deleteById(id);
	}

}
