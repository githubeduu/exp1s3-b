package com.example.exp1s3b.service;

import java.util.List;
import java.util.Optional;

import com.example.exp1s3b.model.FichaMedica;

public interface FichaMedicaService {
    List<FichaMedica> getAllFicha();
    Optional<FichaMedica> getFichaMedicaById(Long id);
    FichaMedica createFichaMedica(FichaMedica fichaMedica); 
}
