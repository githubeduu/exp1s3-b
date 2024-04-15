package com.example.exp1s3b.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exp1s3b.model.FichaMedica;

public interface FichaMedicaRepository extends JpaRepository<FichaMedica, Long> {
    
}
