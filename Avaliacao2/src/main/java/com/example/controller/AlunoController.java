package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Aluno;
import com.example.service.AlunoService;

@RestController
@RequestMapping("/Aluno")
public class AlunoController {

	private final AlunoService AlunoService;

	@Autowired
	public AlunoController (AlunoService AlunoService) {
		this.AlunoService = AlunoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aluno> buscaAlunoControlId(@PathVariable Long id){
		Aluno Aluno = AlunoService.BuscaAlunoId(id);
		if (Aluno != null) {
			return ResponseEntity.ok(Aluno);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public ResponseEntity<List<Aluno>> buscaTodosAlunoCOntrol(){
		List<Aluno> Aluno = AlunoService.buscaTodosAluno();
		return ResponseEntity.ok(Aluno);
	}

	@PostMapping
	public ResponseEntity<Aluno> salvaAlunoControl (@RequestBody Aluno Aluno){
		Aluno salvaAluno = AlunoService.salvaAluno(Aluno);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaAluno);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Aluno> alterarAlunoControl(@PathVariable Long id, @RequestBody Aluno Aluno){
		Aluno alterarAluno = AlunoService.alterarAluno(id, Aluno);
		if(alterarAluno != null) {
			return ResponseEntity.ok(Aluno);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Aluno> apagaAlunoControl (@PathVariable Long id){
		boolean apagar = AlunoService.apagarAluno(id);
		if(apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
