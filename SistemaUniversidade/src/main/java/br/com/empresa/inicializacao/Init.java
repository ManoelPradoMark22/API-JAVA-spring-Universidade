package br.com.empresa.inicializacao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.empresa.entity.Aluno;
import br.com.empresa.entity.Turma;
import br.com.empresa.repository.AlunoRepo;
import br.com.empresa.service.TurmaService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	TurmaService turmaService;
	
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
		
		
		Turma turmaJava = new Turma();
		turmaJava.setNome("Java");
		
		turmaService.salvar(turmaJava);
		
		Turma turmaAWS = new Turma();
		turmaAWS.setNome("AWS");
		
		turmaService.salvar(turmaAWS);
		
		aluno1.setTurma(turmaJava);
		aluno2.setTurma(turmaAWS);
		aluno3.setTurma(turmaJava);
		aluno4.setTurma(turmaAWS);
		
		alunoRepo.saveAll(Arrays.asList(aluno1, aluno2, aluno3, aluno4));
		
		
	}
	
}
