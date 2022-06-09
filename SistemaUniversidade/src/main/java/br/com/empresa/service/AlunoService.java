package br.com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.entity.Aluno;
import br.com.empresa.repository.AlunoRepo;

@Service
public class AlunoService {
	
		//preciso do AlunoRepository para acessar a base de dados e fazer requisicao
		//o Autowired ja faz a instanciação automatica. ai vc nao precisa ficar instanciando sempre a AlunoRepository
		@Autowired
		private AlunoRepo alunoRepo;
		
		//tipagem: vai ter um retorno List<Aluno> (uma lista de alunos)
		public List<Aluno> listaTodosAlunos() {
			return alunoRepo.findAll(); //seria como 'select * from Aluno'
		}
		
		public Aluno buscaPorId(Integer id) throws ObjectNotFoundException{
			Optional<Aluno> aluno = alunoRepo.findById(id);
			return aluno.orElseThrow(() -> new ObjectNotFoundException(null, "Objeto não encontrado!"));
		}
		
		public Aluno salvar(Aluno aluno) {
			return alunoRepo.save(aluno);
		}
		
		public void excluir(Integer id) {
			alunoRepo.deleteById(id);
		}
		
		public Aluno alterar(Aluno objAluno) {
			Aluno aluno = buscaPorId(objAluno.getId());
			aluno.setNome(objAluno.getNome());
			aluno.setTurma(objAluno.getTurma());
			aluno.setDisciplinas(objAluno.getDisciplinas());
			return salvar(aluno); 
			//se ja existir o aluno, ele altera. se nao existe, ele cria.
		}
	
}
