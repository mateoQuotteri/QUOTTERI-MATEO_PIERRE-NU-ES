package com.backend.entity;

public class Odontologo {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer numeroDeMatricula;

    public Odontologo(Integer id, String nombre, String apellido, Integer numeroDeMatricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDeMatricula = numeroDeMatricula;
    }

    public Odontologo(String nombre, String apellido, Integer numeroDeMatricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDeMatricula = numeroDeMatricula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getNumeroDeMatricula() {
        return numeroDeMatricula;
    }

    public void setNumeroDeMatricula(Integer numeroDeMatricula) {
        this.numeroDeMatricula = numeroDeMatricula;
    }

    @Override
    public String toString() {
        return "\nId: " + id + " - Apellido " + apellido + " - Nombre: " + nombre + " - Numero de matricula: " + numeroDeMatricula;
    }

}
