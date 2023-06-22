package com.example.taller_3.Controller;

import com.example.taller_3.Model.Data.DAO.InmuebleDAO;
import com.example.taller_3.Model.Data.DAO.VendedorDAO;
import com.example.taller_3.Model.Data.DBGenerator;
import com.example.taller_3.Model.Inmueble;
import com.example.taller_3.Model.Vendedor;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "agregarInmuebleServlet", value = "/agregarInmueble")
public class agregarInmuebleServlet extends HttpServlet{
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("TiendaInmueble");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher respuesta = request.getRequestDispatcher("/agregarInmueble.jsp");
        respuesta.forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/camposVaciosAgregarInmueble.jsp");
        if(req.getParameter("tipo_construccion").length() !=0 && req.getParameter("ubicacion_geografica").length() != 0 &&
                req.getParameter("precio").length() != 0 && req.getParameter("titulo_profesional").length() != 0
                && req.getParameter("estado_civil").length() != 0) {

            String tipoConstruccion= req.getParameter("tipo_construccion");
            String ubicacionGeografica = req.getParameter("ubicacion_geografica");
            int precio = Integer.getInteger(req.getParameter("precio"));

            Inmueble inmueble = new Inmueble(tipoConstruccion, ubicacionGeografica, precio);

            try {
                DSLContext query= DBGenerator.conectarBD("TiendaInmueble");
                req.setAttribute("Inmueble",inmueble);
                InmuebleDAO.agregarInmueble(query,inmueble);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            respuesta = req.getRequestDispatcher("/exitoAgregarInmueble.jsp");
        }
        respuesta.forward(req,resp);
    }
}
