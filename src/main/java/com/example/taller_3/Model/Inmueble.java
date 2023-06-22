package com.example.taller_3.Model;

public class Inmueble {
    private String tipoConstruccion;
    private String ubicacionGeografica;
    private int precio;

    public Inmueble( String tipoConstruccion, String ubicacionGeografica, int precio) {
        setTipoConstruccion(tipoConstruccion);
        setUbicacionGeografica(ubicacionGeografica);
        setPrecio(precio);
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
