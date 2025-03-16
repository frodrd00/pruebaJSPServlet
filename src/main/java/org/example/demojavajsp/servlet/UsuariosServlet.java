package org.example.demojavajsp.servlet;

import java.io.*;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.demojavajsp.logica.Controladora;
import org.example.demojavajsp.logica.Usuario;

@WebServlet(name = "SvUsuarios", value = "/SvUsuarios")
public class UsuariosServlet extends HttpServlet {

    Controladora controladora = new Controladora();

    public void init() {
        String message = "Hello World!";
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");

        Usuario usuario = new Usuario();
        usuario.setDni(dni);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setTelefono(telefono);

        controladora.crearUsuario(usuario);

        response.sendRedirect("index.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<Usuario> listUsuarios = controladora.getUsuarios();

        HttpSession session = request.getSession();
        session.setAttribute("listUsuarios", listUsuarios);

        request.getRequestDispatcher("mostrarUsuarios.jsp").forward(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    public void destroy() {
    }
}