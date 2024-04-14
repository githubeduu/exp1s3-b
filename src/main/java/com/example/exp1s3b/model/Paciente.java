package com.example.exp1s3b.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
        
    @Column()
    private String nombre;

    @Column()
    private String rut;

    @Column()
    private String telefono;

    @Column()
    private String correo;

    @Column()
    private String direccion;

    //getters
    public Long getId(){
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

    //setters
    public void setId(Long id){
        this.id = id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setRut(String rut){
        this.rut = rut;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

}