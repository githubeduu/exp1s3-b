package com.example.exp1s3b;

import java.text.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;


@RestController
public class FechaMedicaController {
    private List<FichaMedica> fichaMedica = new ArrayList<>();

    public FechaMedicaController(){
        fichaMedica.add(new FichaMedica(1, "15-03-2024", 0, "Gripe común",
            new Paciente(1, "Juan Perez", "178765439", "981765481", "juan.perez@gmail.com", "Monjita 245"), 
            new Medico(1, "Francisco Larrain", "83556128", "Medico General")));

        fichaMedica.add(new FichaMedica(2, "16-03-2024", 0, "Dolor de cabeza",
            new Paciente(2, "María González", "158765440", "981765482", "maria.gonzalez@gmail.com", "Calle Principal 123"), 
            new Medico(2, "Ana López", "83556129", "Neuróloga")));

        fichaMedica.add(new FichaMedica(3, "17-03-2024", 10, "Lesión en el brazo",
            new Paciente(3, "Luis Martínez", "178765441", "981765483", "luis.martinez@gmail.com", "Avenida Central 567"), 
            new Medico(3, "Pedro Ramírez", "83556130", "Ortopedista")));

        fichaMedica.add(new FichaMedica(2, "18-03-2024", 4, "Problemas gastrointestinales",
            new Paciente(4, "María González", "54439397", "981765484", "ana.rodriguez@gmail.com", "Plaza Mayor 789"), 
            new Medico(4, "Sofía García", "83556131", "Gastroenteróloga")));

        fichaMedica.add(new FichaMedica(5, "19-03-2024", 0, "Infección respiratoria",
            new Paciente(5, "Carlos Sánchez", "178765443", "981765485", "carlos.sanchez@gmail.com", "Calle Secundaria 1011"), 
            new Medico(5, "Alejandro Fernández", "83556132", "Neumólogo")));

        fichaMedica.add(new FichaMedica(6, "20-03-2024", 5, "Conjuntivitis",
            new Paciente(6, "Laura Gómez", "178765444", "981765486", "laura.gomez@gmail.com", "Avenida Norte 1213"), 
            new Medico(6, "Lucía Torres", "83556133", "Oftalmóloga")));

        fichaMedica.add(new FichaMedica(1, "21-03-2023", 0, "Alergia",
            new Paciente(7, "Javier hernandez", "180265208", "981765487", "javier.hernandez@gmail.com", "Calle Sur 1415"), 
            new Medico(7, "Martín Vargas", "83556134", "Alergólogo")));

        fichaMedica.add(new FichaMedica(1, "22-03-2022", 7, "Dolor de espalda",
            new Paciente(8, "Elena Diaz", "198544371", "981765488", "elena.diaz@gmail.com", "Avenida Este 1617"), 
            new Medico(8, "Carmen Ruiz", "83556135", "Fisioterapeuta")));
    }

    @GetMapping("/pacientes")
    public ResponseEntity<?> getPaciente() {
        List<Paciente> pacientes = new ArrayList<>();
        for (FichaMedica ficha : fichaMedica){
            pacientes.add(ficha.getPaciente());
        }
        if(pacientes.isEmpty()){
            return ResponseEntity.badRequest().body("Lista de pacientes no encontrada");
        }else{
            return ResponseEntity.ok(pacientes);
        }
    }

    @GetMapping("/medicos")
    public ResponseEntity<?> getMedicos() {
        List<Medico> medicos = new ArrayList<>();
        for (FichaMedica ficha : fichaMedica){
            medicos.add(ficha.getMedico());
        }
        if(medicos.isEmpty()){
            return ResponseEntity.badRequest().body("Lista de medicos no encontrada");
        }else{
            return ResponseEntity.ok(medicos);
        }
    }

    @GetMapping("/fichaMedica/paciente/{rut}")
    public ResponseEntity<?> getFichaMedicaPorRut(@PathVariable String rut) {
        List<FichaMedica> fichasPorRut  = new ArrayList<>();
        for (FichaMedica ficha : fichaMedica){
            if(ficha.getPaciente().getRut().equals(rut))
            {
                fichasPorRut.add(ficha);
            }           
        }
        if(fichasPorRut.isEmpty()){
            return ResponseEntity.badRequest().body("Paciente no encontrado");
        }else{
            return ResponseEntity.ok(fichasPorRut);
        }
       
    }

    @GetMapping("/fichaMedica/fechaInicio/{fechaInicio}/fechaFin/{fechaFin}")
    public ResponseEntity<?> getFichaPorFechas(@PathVariable String fechaInicio, @PathVariable String fechaFin) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
        List<FichaMedica> fichasPorFecha = new ArrayList<>();
        try {
            Date dateInicio = sdf.parse(fechaInicio);
            Date dateFin = sdf.parse(fechaFin);

        if (dateInicio.after(dateFin)) {
            return ResponseEntity.badRequest().body("La fecha de inicio no puede ser mayor a la fecha fin");
        } else {
            for (FichaMedica ficha : fichaMedica) {
                if (!ficha.getFecha().before(dateInicio) && !ficha.getFecha().after(dateFin)) {
                    fichasPorFecha.add(ficha);
                    }
                }
            return ResponseEntity.ok(fichasPorFecha);
            }
        } catch (ParseException e) {
             e.printStackTrace();
            return ResponseEntity.badRequest().body("Formato de fecha incorrecto. Utiliza el formato dd/MM/yyyy");
        }
    }


}
