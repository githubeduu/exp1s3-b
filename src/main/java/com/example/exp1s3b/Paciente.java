package com.example.exp1s3b;

public class Paciente{
    private int id;
    private String nombre;
    private String rut;
    private String telefono;
    private String correo;
    private String direccion;

    public Paciente(int id, String nombre, String rut, String telefono, String correo, String direccion ){
        this.id = id;
        this.nombre = nombre;
        this.rut = rut;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
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

    public String getTelefono(){
        return telefono;
    }

    public String getCorreo(){
        return correo;
    }

    public String getDireccion(){
        return direccion;
    }
}