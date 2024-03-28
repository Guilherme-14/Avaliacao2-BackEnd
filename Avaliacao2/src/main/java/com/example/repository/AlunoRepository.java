package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Aluno;

public interface AlunoRepository extends JpaRepository <Aluno , Long>{

}
