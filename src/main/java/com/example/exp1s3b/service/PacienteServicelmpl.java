package com.example.exp1s3b.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exp1s3b.model.Paciente;
import com.example.exp1s3b.repository.PacienteRepository;

@Service
public class PacienteServicelmpl implements PacienteService{
    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> getAllPaciente(){
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> getPacienteById(Long id){
        return pacienteRepository.findById(id);
    }

    @Override
    public Paciente createPaciente(Paciente usuario){         
        return pacienteRepository.save(usuario);
    }

    @Override
    public Paciente updatePaciente(Paciente paciente) {
    return pacienteRepository.save(paciente);
    }

    @Override
    public void deletePaciente(Long id){
        pacienteRepository.deleteById(id);
    } 
}
