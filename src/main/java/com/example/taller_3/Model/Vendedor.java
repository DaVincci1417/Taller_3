package com.example.taller_3.Model;

public class Vendedor {
    private String rut;
    private String nombre;
    private String direccion;
    private String tituloProfesional;
    private String estadoCivil;

    public Vendedor(String rut, String nombre, String direccion, String tituloProfesional, String estadoCivil) {
        setRut(rut);
        setNombre(nombre);
        setDireccion(direccion);
        setTituloProfesional(tituloProfesional);
        setEstadoCivil(estadoCivil);
    }

    public String getRut() {
        return rut;
    }
    private void setRut(String rut) {
        this.rut = rut;
    }
    public String getNombre() {
        return nombre;
    }
    private  void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    private  void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTituloProfesional() {
        return tituloProfesional;
    }
    private  void setTituloProfesional(String tituloProfesional) {
        this.tituloProfesional = tituloProfesional;
    }
    public String getEstadoCivil() {
        return estadoCivil;
    }
    private  void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}
