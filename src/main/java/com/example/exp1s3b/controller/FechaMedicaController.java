package com.example.exp1s3b.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exp1s3b.model.FichaMedica;
import com.example.exp1s3b.model.Medico;
import com.example.exp1s3b.model.Paciente;
import com.example.exp1s3b.service.FichaMedicaService;
import com.example.exp1s3b.service.MedicoService;
import com.example.exp1s3b.service.PacienteService;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;


@RestController
@RequestMapping("/atencionMedica")
@Slf4j
public class FechaMedicaController {
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private MedicoService medicoService;
   //  @Autowired
   //  private FichaMedicaService fichaMedicaService;


    @GetMapping("/paciente")
    public List<Paciente> getPaciente() {       
       return pacienteService.getAllPaciente();       
    }

    @GetMapping("/medico")
    public List<Medico> getMedico() {       
       return medicoService.getAllMedico();       
    }


    // @GetMapping("/medicos")
    // public ResponseEntity<?> getMedicos() {
    //     List<Medico> medicos = new ArrayList<>();
    //     for (FichaMedica ficha : fichaMedica){
    //         medicos.add(ficha.getMedico());
    //     }
    //     if(medicos.isEmpty()){
    //         return ResponseEntity.badRequest().body("Lista de medicos no encontrada");
    //     }else{
    //         return ResponseEntity.ok(medicos);
    //     }
    // }

    // @GetMapping("/fichaMedica/paciente/{rut}")
    // public ResponseEntity<?> getFichaMedicaPorRut(@PathVariable String rut) {
    //     List<FichaMedica> fichasPorRut  = new ArrayList<>();
    //     for (FichaMedica ficha : fichaMedica){
    //         if(ficha.getPaciente().getRut().equals(rut))
    //         {
    //             fichasPorRut.add(ficha);
    //         }           
    //     }
    //     if(fichasPorRut.isEmpty()){
    //         return ResponseEntity.badRequest().body("Paciente no encontrado");
    //     }else{
    //         return ResponseEntity.ok(fichasPorRut);
    //     }
       
    // }

    // @GetMapping("/fichaMedica/fechaInicio/{fechaInicio}/fechaFin/{fechaFin}")
    // public ResponseEntity<?> getFichaPorFechas(@PathVariable String fechaInicio, @PathVariable String fechaFin) {
    //     SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
    //     List<FichaMedica> fichasPorFecha = new ArrayList<>();
    //     try {
    //         Date dateInicio = sdf.parse(fechaInicio);
    //         Date dateFin = sdf.parse(fechaFin);

    //     if (dateInicio.after(dateFin)) {
    //         return ResponseEntity.badRequest().body("La fecha de inicio no puede ser mayor a la fecha fin");
    //     } else {
    //         for (FichaMedica ficha : fichaMedica) {
    //             if (!ficha.getFecha().before(dateInicio) && !ficha.getFecha().after(dateFin)) {
    //                 fichasPorFecha.add(ficha);
    //                 }
    //             }
    //         return ResponseEntity.ok(fichasPorFecha);
    //         }
    //     } catch (ParseException e) {
    //          e.printStackTrace();
    //         return ResponseEntity.badRequest().body("Formato de fecha incorrecto. Utiliza el formato dd/MM/yyyy");
    //     }
    // }


}
