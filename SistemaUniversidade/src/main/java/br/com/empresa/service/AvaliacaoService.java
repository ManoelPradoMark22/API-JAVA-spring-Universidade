package br.com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.entity.Avaliacao;
import br.com.empresa.repository.AvaliacaoRepo;

@Service
public class AvaliacaoService {

	@Autowired
	AvaliacaoRepo repo;
	
	public Avaliacao save(Avaliacao avaliacao) {
		return repo.save(avaliacao);
	}
	
	public List<Avaliacao> findAll() {
		return repo.findAll();
	}
	
}
