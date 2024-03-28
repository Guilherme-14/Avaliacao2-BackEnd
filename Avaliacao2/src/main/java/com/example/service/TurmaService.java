package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Turma;
import com.example.repository.TurmaRepository;

@Service
public class TurmaService {
	

	private final TurmaRepository TurmaRepository;

	@Autowired
	public TurmaService(TurmaRepository TurmaRepository) {
		this.TurmaRepository = TurmaRepository;
	}

	public List<Turma> buscaTodosTurma(){
		return TurmaRepository.findAll();
	}

	public Turma BuscaTurmaId(Long id) {
		Optional <Turma> Turma = TurmaRepository.findById(id);
		return Turma.orElse(null);
	}

	public Turma salvaTurma(Turma Turma) {
		return TurmaRepository.save(Turma);	
	}

	public Turma alterarTurma (Long id, Turma alterarC) {
		Optional <Turma> existeTurma = TurmaRepository.findById(id);
		if (existeTurma.isPresent()) {
			alterarC.setId(id);
			return TurmaRepository.save(alterarC);
		}
		return null;
	}

	public boolean apagarTurma(Long id) {
		Optional <Turma> existeTurma = TurmaRepository.findById(id);
		if (existeTurma.isPresent()) {
			TurmaRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
