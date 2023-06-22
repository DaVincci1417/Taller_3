package com.example.taller_3.Model;

public class Inmueble {
    private int codInmueble;
    private String tipoConstruccion;
    private String ubicacionGeografica;
    private int precio;

    public Inmueble(int codInmueble, String tipoConstruccion, String ubicacionGeografica, int precio) {
        setCodInmueble(codInmueble);
        setTipoConstruccion(tipoConstruccion);
        setUbicacionGeografica(ubicacionGeografica);
        setPrecio(precio);
    }

    public int getCodInmueble() {
        return codInmueble;
    }
    private void setCodInmueble(int codInmueble) {
        this.codInmueble = codInmueble;
    }
    public String getTipoConstruccion() {
        return tipoConstruccion;
    }
    private void setTipoConstruccion(String tipoConstruccion) {
        this.tipoConstruccion = tipoConstruccion;
    }
    public String getUbicacionGeografica() {
        return ubicacionGeografica;
    }
    private  void setUbicacionGeografica(String ubicacionGeografica) {
        this.ubicacionGeografica = ubicacionGeografica;
    }
    public int getPrecio() {
        return precio;
    }
    private  void setPrecio(int precio) {
        this.precio = precio;
    }
}
