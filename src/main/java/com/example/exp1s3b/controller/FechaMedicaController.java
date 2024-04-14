package com.example.exp1s3b.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exp1s3b.DTO.CreacionMedicoDTO;
import com.example.exp1s3b.DTO.CreacionPacienteDTO;
import com.example.exp1s3b.model.FichaMedica;
import com.example.exp1s3b.model.Medico;
import com.example.exp1s3b.model.Paciente;
import com.example.exp1s3b.service.FichaMedicaService;
import com.example.exp1s3b.service.MedicoService;
import com.example.exp1s3b.service.PacienteService;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    @GetMapping("/paciente/{id}")
    public ResponseEntity<?> getPacienteById(@PathVariable Long id) {
        Optional<Paciente> paciente = pacienteService.getPacienteById(id);
        if (paciente.isPresent()) {
            return ResponseEntity.ok(paciente.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente no encontrado");
        } 
    }

    @GetMapping("/medico")
    public List<Medico> getMedico() {       
       return medicoService.getAllMedico();       
    }

    @GetMapping("/medico/{id}")
    public ResponseEntity<?> getMedicoyId(@PathVariable Long id) {
        Optional<Medico> medico = medicoService.getMedicoById(id);
        if (medico.isPresent()) {
            return ResponseEntity.ok(medico.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico no encontrado");
        } 
    }   

    @PostMapping("/paciente")
    public ResponseEntity<?> createPaciente(@Validated @RequestBody CreacionPacienteDTO pacienteDto) {
      try {    
             Paciente paciente = new Paciente();
             paciente.setId(pacienteDto.getId());
             paciente.setNombre(pacienteDto.getNombre());
             paciente.setRut(pacienteDto.getRut());
             paciente.setTelefono(pacienteDto.getTelefono());
             paciente.setCorreo(pacienteDto.getCorreo());
             paciente.setDireccion(pacienteDto.getDireccion());
          
             Paciente nuevoPaciente = pacienteService.createPaciente(paciente);


               return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPaciente);
        } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el paciente:          " + e);
             }
    }

    @PutMapping("/paciente/{id}")
public ResponseEntity<?> updatePaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
    try {        
        Optional<Paciente> pacienteExistente = pacienteService.getPacienteById(id);
        if (pacienteExistente.isPresent()) {
            Paciente pacienteActual = pacienteExistente.get();

            // Actualizar solo los campos que no son nulos
            if (paciente.getTelefono() != null) {
                pacienteActual.setTelefono(paciente.getTelefono());
            }
            if (paciente.getCorreo() != null) {
                pacienteActual.setCorreo(paciente.getCorreo());
            }
            if (paciente.getDireccion() != null) {
                pacienteActual.setDireccion(paciente.getDireccion());
            }

            // Guardar el paciente actualizado
            Paciente pacienteActualizado = pacienteService.updatePaciente(pacienteActual);
            return ResponseEntity.ok(pacienteActualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente no encontrado");
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el paciente: " + e);
    }
}

    @PostMapping("/medico")
    public ResponseEntity<?> createMedico(@Validated @RequestBody CreacionMedicoDTO medicoDto) {
      try {    
             Medico medico = new Medico();
             medico.setId(medicoDto.getId());
             medico.setNombre(medicoDto.getNombre());
             medico.setRut(medicoDto.getRut());
             medico.setEspecialidad(medicoDto.getEspecialidad());       
          
             Medico nuevoMedico = medicoService.createMedico(medico);


               return ResponseEntity.status(HttpStatus.CREATED).body(nuevoMedico);
        } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el medico:          " + e);
             }
    }

    @DeleteMapping("/paciente/{id}")
    public ResponseEntity<?> deletePaciente(@PathVariable Long id) {
    Optional<Paciente> paciente = pacienteService.getPacienteById(id);
        if (paciente.isPresent()) {
            pacienteService.deletePaciente(id);
            return ResponseEntity.ok("Paciente eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente no encontrado");
        }
}

    @DeleteMapping("/medico/{id}")
    public ResponseEntity<?> deleteMedico(@PathVariable Long id) {
    Optional<Medico> medico = medicoService.getMedicoById(id);
        if (medico.isPresent()) {
            medicoService.deleteMedico(id);
            return ResponseEntity.ok("Medico eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico no encontrado");
        }
}


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
