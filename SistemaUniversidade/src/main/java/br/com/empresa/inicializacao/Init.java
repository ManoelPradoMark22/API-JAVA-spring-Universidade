package br.com.empresa.inicializacao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.empresa.entity.Aluno;
import br.com.empresa.entity.AlunoDisciplina;
import br.com.empresa.entity.Avaliacao;
import br.com.empresa.entity.Disciplina;
import br.com.empresa.entity.Turma;
import br.com.empresa.repository.AlunoRepo;
import br.com.empresa.service.AvaliacaoService;
import br.com.empresa.service.DisciplinaService;
import br.com.empresa.service.TurmaService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	AlunoRepo alunoRepo;
	
	@Autowired
	TurmaService turmaService;
	
	@Autowired
	DisciplinaService disciplinaService;
	
	@Autowired
	AvaliacaoService avaliacaoService;
	
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Manoel");
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Paulo");
		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("Anna");
		
		Aluno aluno4 = new Aluno();
		aluno4.setNome("Pedro");
		
		
		Disciplina disciplina1 = new Disciplina();
		disciplina1.setNome("Java");
		
		disciplinaService.salvar(disciplina1);
		
		Disciplina disciplina2 = new Disciplina();
		disciplina2.setNome("JavaScript");
		
		disciplinaService.salvar(disciplina2);
		
		Disciplina disciplina3 = new Disciplina();
		disciplina3.setNome("NodeJs");
		
		disciplinaService.salvar(disciplina3);
		
		Disciplina disciplina4 = new Disciplina();
		disciplina4.setNome("Amazon EC2");
		
		disciplinaService.salvar(disciplina4);
		
		Disciplina disciplina5 = new Disciplina();
		disciplina5.setNome("Amazon S3");
		
		disciplinaService.salvar(disciplina5);
		
		
		Turma turma1 = new Turma();
		turma1.setNome("Backend");
		
		turmaService.salvar(turma1);
		
		Turma turma2 = new Turma();
		turma2.setNome("AWS");
		
		turmaService.salvar(turma2);
		
		aluno1.setTurma(turma1);
		aluno2.setTurma(turma2);
		aluno3.setTurma(turma1);
		aluno4.setTurma(turma2);
		
		aluno1.setDisciplinas(Arrays.asList(disciplina1, disciplina2, disciplina3));
		aluno2.setDisciplinas(Arrays.asList(disciplina1, disciplina3));
		aluno3.setDisciplinas(Arrays.asList(disciplina4, disciplina5));
		aluno4.setDisciplinas(Arrays.asList(disciplina5));
		
		alunoRepo.saveAll(Arrays.asList(aluno1, aluno2, aluno3, aluno4));
		
		
		Avaliacao avaliacaoAluno1 = new Avaliacao();
		
		AlunoDisciplina alunoDisciplina1 = new AlunoDisciplina();
		alunoDisciplina1.setAluno(aluno1);
		alunoDisciplina1.setDisciplina(disciplina1);
		
		avaliacaoAluno1.setAlunoDisciplina(alunoDisciplina1);
		avaliacaoAluno1.setConceito("A");
		avaliacaoService.save(avaliacaoAluno1);
		
		
		Avaliacao avaliacaoAluno2 = new Avaliacao();
		
		AlunoDisciplina alunoDisciplina2 = new AlunoDisciplina();
		alunoDisciplina2.setAluno(aluno2);
		alunoDisciplina2.setDisciplina(disciplina2);
		
		avaliacaoAluno2.setAlunoDisciplina(alunoDisciplina2);
		avaliacaoAluno2.setConceito("C");
		avaliacaoService.save(avaliacaoAluno2);
		
		
		Avaliacao avaliacaoAluno3 = new Avaliacao();
		
		AlunoDisciplina alunoDisciplina3 = new AlunoDisciplina();
		alunoDisciplina3.setAluno(aluno3);
		alunoDisciplina3.setDisciplina(disciplina1);
		
		avaliacaoAluno3.setAlunoDisciplina(alunoDisciplina3);
		avaliacaoAluno3.setConceito("A");
		avaliacaoService.save(avaliacaoAluno3);
		
	}
	
}
