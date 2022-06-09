package br.com.empresa.inicializacao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.empresa.entity.Aluno;
import br.com.empresa.entity.Disciplina;
import br.com.empresa.entity.Turma;
import br.com.empresa.repository.AlunoRepo;
import br.com.empresa.service.DisciplinaService;
import br.com.empresa.service.TurmaService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	TurmaService turmaService;
	
	@Autowired
	DisciplinaService disciplinaService;
	
	@Autowired
	AlunoRepo alunoRepo;
	
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
		
		alunoRepo.saveAll(Arrays.asList(aluno1, aluno2, aluno3, aluno4));
		
		
	}
	
}
