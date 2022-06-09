package br.com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.empresa.entity.AlunoDisciplina;
import br.com.empresa.entity.Avaliacao;

@Repository
public interface AvaliacaoRepo extends JpaRepository<Avaliacao, AlunoDisciplina> {

}
