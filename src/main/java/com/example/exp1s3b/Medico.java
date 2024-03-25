package com.example.exp1s3b;

public class Medico {
    private int id;
    private String nombre;
    private String rut;
    private String especialidad;

    public Medico(int id, String nombre, String rut, String especialidad){
        this.id = id;
        this.nombre = nombre;
        this.rut = rut;
        this.especialidad = especialidad;       
    }

    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public String getRut(){
        return rut;
    }

    public String getEspecialidad(){
        return especialidad;
    }
   
}
