package org.example.demojavajsp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demojavajsp.logica.Controladora;

import java.io.IOException;

@WebServlet(name="SvDeleteUser", value = "/SvDeleteUser")
public class DelUsuarioServlet extends HttpServlet {

    Controladora controladora = new Controladora();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("_method");
        if(method.equals("DELETE")) {
            Long userId = Long.parseLong(req.getParameter("userId"));
            controladora.eliminarUsuario(userId);
            System.out.println("Usuario eliminado");
        }

        req.getRequestDispatcher("mostrarUsuarios.jsp").forward(req, resp);
    }

}
