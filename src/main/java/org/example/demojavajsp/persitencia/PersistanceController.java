package org.example.demojavajsp.persitencia;

import org.example.demojavajsp.logica.Usuario;

import java.util.List;

public class PersistanceController {

    UsuarioJpaController usuarioJpaController = UsuarioJpaController.getInstancia();

    public void crearUsuario(Usuario usuario) {
        usuarioJpaController.crear(usuario);
    }

    public void eliminarUsuario(Long id) {
        usuarioJpaController.eliminar(id);
    }

    public List<Usuario> getUsuarios() {
        return usuarioJpaController.listarUsuarios();
    }

    public Usuario getUsuario(Long id) {
        return usuarioJpaController.encontrarPorId(id);
    }

    public void actualizarUsuario(Usuario usuario) {
        usuarioJpaController.actualizar(usuario);
    }

}
