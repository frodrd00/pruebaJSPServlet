package org.example.demojavajsp.logica;

import org.example.demojavajsp.persitencia.PersistanceController;

import java.util.List;

public class Controladora {
    PersistanceController persistanceController = new PersistanceController();

    public void crearUsuario(Usuario usuario) {
        persistanceController.crearUsuario(usuario);
    }

    public List<Usuario> getUsuarios() {
        return persistanceController.getUsuarios();
    }

    public void eliminarUsuario(Long id) {
        persistanceController.eliminarUsuario(id);
    }

    public Usuario getUsuario(Long id) {
        return persistanceController.getUsuario(id);
    }

    public void actualizarUsuario(Usuario usuario) {
        persistanceController.actualizarUsuario(usuario);
    }
}
