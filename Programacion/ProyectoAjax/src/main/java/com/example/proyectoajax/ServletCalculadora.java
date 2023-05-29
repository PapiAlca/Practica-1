package com.example.proyectoajax;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.PrintWriter;
import java.io.IOException;

@WebServlet(name = "com.example.proyectoayax", value = "/Calculadora")
public class ServletCalculadora extends HttpServlet {
    // Declaraciones globales (de clase)
    private float resultado;
    private String texto;
    private CalculadoraDePila cal1;

    // Inicialización
    public void init() {
        cal1 = new CalculadoraDePila();
    }

    // Cuando apagamos para ordenar y limpiar (sólo se ejecuta 1 vez)
    public void destroy() {
    }

    // Peticiones GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Tipo de respuesta ofrecida (texto, imagen, etc)
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        texto = request.getParameter("texto");
        resultado = cal1.obtenerResultado(texto);
        out.print("<html><body>" +
                resultado +
                "</body></html>"
        );
    }

    // Peticiones POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}