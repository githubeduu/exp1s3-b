package com.example.exp1s3b.service;

import java.util.List;
import java.util.Optional;

import com.example.exp1s3b.model.Medico;

public interface MedicoService {
    List<Medico> getAllMedico();
    Optional<Medico> getMedicoById(Long id);
    Medico createMedico(Medico medico); 
    void deleteMedico(Long id);
}

