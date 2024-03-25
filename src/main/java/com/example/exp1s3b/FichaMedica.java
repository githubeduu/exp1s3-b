package com.example.exp1s3b;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FichaMedica {
    private int id;
    private Date fecha;
    private int diasLicencia;
    private String diagnostico;
    private Paciente paciente;
    private Medico medico;

    public FichaMedica(int id, String fechaStr, int diasLicencia, String diagnostico, Paciente paciente, Medico medico){
        this.id = id;  
        this.diasLicencia = diasLicencia;
        this.diagnostico = diagnostico;
        this.paciente = paciente;
        this.medico = medico;
        SimpleDateFormat fechaFormat = new SimpleDateFormat("dd-MM-yyyy");
        try{
            this.fecha = fechaFormat.parse(fechaStr);
        }catch(ParseException e){
             e.printStackTrace();
        }
    }
    
    public int getId(){
        return id;
    }

    public Date getFecha(){        
        return fecha;
    }

    public int getDiasLicencia(){
        return diasLicencia;
    }

    public String getDiagnostico(){
        return diagnostico;
    }

    public Paciente getPaciente(){
        return paciente;
    }

    public Medico getMedico(){
        return medico;
    }
}
