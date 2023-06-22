package com.example.taller_3.Controller;

import com.example.taller_3.Model.Data.DAO.VendedorDAO;
import com.example.taller_3.Model.Data.DBGenerator;
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

@WebServlet(name = "agregarVendedorServlet", value = "/agregarVendedor")
public class agregarVendedorServlet extends HttpServlet {
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
        RequestDispatcher respuesta = request.getRequestDispatcher("/agregarVendedor.jsp");
        respuesta.forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/camposVaciosAgregarVendedor.jsp");
        if(req.getParameter("nombre").length() !=0 && req.getParameter("rut").length() != 0 &&
                req.getParameter("direccion").length() != 0 && req.getParameter("titulo_profesional").length() != 0
                && req.getParameter("estado_civil").length() != 0) {

            String nombre = req.getParameter("nombre");
            String rut = req.getParameter("rut");
            String direccion = req.getParameter("direccion");
            String tituloProfesional = req.getParameter("titulo_profesional");
            String estadoCivil= req.getParameter("estado_civil");

            Vendedor vendedor = new Vendedor(rut, nombre, direccion, tituloProfesional, estadoCivil);

            try {
                if(agregarVendedor(vendedor)){
                    req.setAttribute("Vendedor",vendedor);
                    respuesta = req.getRequestDispatcher("/exitoAgregarVendedor.jsp");
                }else{
                    respuesta = req.getRequestDispatcher("/vendedorRepetido.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }
    private boolean agregarVendedor(Vendedor vendedor) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("TiendaInmueble");
        List<Vendedor> vendedores = VendedorDAO.obtenerVendedor(query,"rut", vendedor.getRut());
        if(vendedores.size() != 0){
            return false;
        }
        else{
            VendedorDAO.agregarVendedor(query,vendedor);
            return true;
        }
    }
}
