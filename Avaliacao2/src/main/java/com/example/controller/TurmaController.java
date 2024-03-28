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

import com.example.entities.Turma;
import com.example.service.TurmaService;

@RestController
@RequestMapping("/Turma")
public class TurmaController {

	private final TurmaService TurmaService;

	@Autowired
	public TurmaController (TurmaService TurmaService) {
		this.TurmaService = TurmaService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Turma> buscaTurmaControlId(@PathVariable Long id){
		Turma Turma = TurmaService.BuscaTurmaId(id);
		if (Turma != null) {
			return ResponseEntity.ok(Turma);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public ResponseEntity<List<Turma>> buscaTodosTurmaCOntrol(){
		List<Turma> Turma = TurmaService.buscaTodosTurma();
		return ResponseEntity.ok(Turma);
	}

	@PostMapping
	public ResponseEntity<Turma> salvaTurmaControl (@RequestBody Turma Turma){
		Turma salvaTurma = TurmaService.salvaTurma(Turma);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaTurma);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Turma> alterarTurmaControl(@PathVariable Long id, @RequestBody Turma Turma){
		Turma alterarTurma = TurmaService.alterarTurma(id, Turma);
		if(alterarTurma != null) {
			return ResponseEntity.ok(Turma);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Turma> apagaTurmaControl (@PathVariable Long id){
		boolean apagar = TurmaService.apagarTurma(id);
		if(apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
