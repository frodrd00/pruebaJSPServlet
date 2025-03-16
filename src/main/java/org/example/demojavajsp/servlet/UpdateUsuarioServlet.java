package org.example.demojavajsp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.demojavajsp.logica.Controladora;
import org.example.demojavajsp.logica.Usuario;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet("/SvUpdateUser")
public class UpdateUsuarioServlet extends HttpServlet {

    Controladora controladora = new Controladora();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los parámetros del formulario
        Long userId = Long.parseLong(request.getParameter("userId"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");

        // Lógica para actualizar los datos del usuario
        boolean success = updateUser(userId, nombre, apellido, telefono);

        // Redirigir a la página de listado de usuarios después de la actualización
        if (success) {

            List<Usuario> listUsuarios = controladora.getUsuarios();

            HttpSession session = request.getSession();
            session.setAttribute("listUsuarios", listUsuarios);

            System.out.println("Usuario actualizado");

            request.getRequestDispatcher("mostrarUsuarios.jsp").forward(request, response);
            // Redirige a la lista de usuarios
        } else {
            response.sendRedirect("error.jsp");  // Redirige a una página de error si la actualización falla
        }
    }

    private boolean updateUser(Long userId, String nombre, String apellido, String telefono) {

        Usuario usuario = controladora.getUsuario(userId);

        if (Objects.equals(usuario.getId(), userId)) {
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setTelefono(telefono);
            controladora.actualizarUsuario(usuario);
            return true;

        }
        return false;  // Si no se encuentra el usuario
    }
}
