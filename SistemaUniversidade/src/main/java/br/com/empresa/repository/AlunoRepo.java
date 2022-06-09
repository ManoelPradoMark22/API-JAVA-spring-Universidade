package br.com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.empresa.entity.Aluno;

@Repository
public interface AlunoRepo extends JpaRepository<Aluno, Integer>{

}
