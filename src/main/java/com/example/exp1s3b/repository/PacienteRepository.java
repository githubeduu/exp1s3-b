package com.example.exp1s3b.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exp1s3b.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    
} 

