package com.example.exp1s3b.service;

import java.util.List;
import java.util.Optional;

import com.example.exp1s3b.model.Paciente;

public interface PacienteService {
    List<Paciente> getAllPaciente();
    Optional<Paciente> getPacienteById(Long id);
    Paciente createPaciente(Paciente paciente); 
    Paciente updatePaciente(Long id, Paciente paciente);
    void deletePaciente(Long id);
    
}
