package com.example.taller_3.Model.Data.DAO;

import com.example.taller_3.Model.Inmueble;
import com.example.taller_3.Model.Vendedor;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;
import org.jooq.impl.QOM;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class InmuebleDAO {
    public static void agregarInmueble(DSLContext query, Inmueble inmueble){
        Table tablaVendedor = table(name("Inmueble"));
        Field[] columnas = tablaVendedor.fields("tipo_construccion","ubicacion_geografica","precio");
        query.insertInto(tablaVendedor, columnas[0], columnas[1], columnas[2])
                .values(inmueble.getTipoConstruccion(), inmueble.getUbicacionGeografica(), inmueble.getPrecio())
                .execute();
    }
    public static List obtenerInmueble(DSLContext query, String columnaTabla, String dato){
        Result resultados = query.select().from(DSL.table("Inmueble")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaInmuebles(resultados);
    }
    public static List obtenerInmuebles(DSLContext query){
        Result resultados = query.select().from(DSL.table("Inmueble")).fetch();
        return obtenerListaInmuebles(resultados);
    }
    private static List obtenerListaInmuebles(Result resultados){
        List<Inmueble> inmuebles = new ArrayList<>();
        for(int fila=0; fila < resultados.size() ; fila++){
            String tipoConstruccion = (String) resultados.getValue(fila,"tipo_construccion");
            String ubicacionGeografica = (String) resultados.getValue(fila,"ubicacion_geografica");
            int precio= (Integer) resultados.getValue(fila,"precio");

            inmuebles.add(new Inmueble(tipoConstruccion, ubicacionGeografica, precio));
        }
        return inmuebles;
    }
}
