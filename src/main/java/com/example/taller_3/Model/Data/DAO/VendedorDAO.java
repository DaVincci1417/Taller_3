package com.example.taller_3.Model.Data.DAO;

import com.example.taller_3.Model.Vendedor;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class VendedorDAO {
    public static void agregarVendedor(DSLContext query, Vendedor vendedor){
        Table tablaVendedor = table(name("Vendedor"));
        Field[] columnas = tablaVendedor.fields("rut","nombre","direccion","titulo_profesional","estado_civil");
        query.insertInto(tablaVendedor, columnas[0], columnas[1], columnas[2], columnas[3], columnas[4])
                .values(vendedor.getRut(), vendedor.getNombre(), vendedor.getDireccion(), vendedor.getTituloProfesional(), vendedor.getEstadoCivil())
                .execute();
    }
    public static List obtenerVendedor(DSLContext query, String columnaTabla, String dato){
        Result resultados = query.select().from(DSL.table("Vendedor")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaVendedores(resultados);
    }
    public static List obtenerVendedores(DSLContext query){
        Result resultados = query.select().from(DSL.table("Vendedor")).fetch();
        return obtenerListaVendedores(resultados);
    }
    private static List obtenerListaVendedores(Result resultados){
        List<Vendedor> vendedores = new ArrayList<>();
        for(int fila=0; fila < resultados.size() ; fila++){
            String rut = (String) resultados.getValue(fila,"rut");
            String nombre = (String) resultados.getValue(fila,"nombre");
            String direccion = (String) resultados.getValue(fila,"direccion");
            String tituloProfesional = (String) resultados.getValue(fila,"titulo_profesional");
            String estadoCivil = (String) resultados.getValue(fila,"estado_civil");

            vendedores.add(new Vendedor(rut, nombre, direccion, tituloProfesional, estadoCivil));
        }
        return vendedores;
    }
}
