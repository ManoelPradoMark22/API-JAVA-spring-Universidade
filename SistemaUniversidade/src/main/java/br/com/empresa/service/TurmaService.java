package br.com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.entity.Turma;
import br.com.empresa.repository.TurmaRepo;

@Service
public class TurmaService {
	
	@Autowired
	TurmaRepo repo;
	
	public List<Turma> listarTodasTurmas() {
		return repo.findAll();
	}
	
	public Turma salvar(Turma turma) {
		return repo.save(turma);
	}
	
	public Turma buscaPorID(Integer id) throws ObjectNotFoundException {
		Optional<Turma> turma = repo.findById(id);
		return turma.orElseThrow(() -> new ObjectNotFoundException(null, "Turma não encontrada"));
	}
	
	public Turma alterar(Turma objTurma) {
		Turma turmaDoBD = buscaPorID(objTurma.getId());
		turmaDoBD.setNome(objTurma.getNome());
		return salvar(turmaDoBD);
	}
	
	public void excluir(Integer id) {
		repo.deleteById(id);
	}
	
}
