package org.example.demojavajsp.persitencia;

import jakarta.persistence.*;
import org.example.demojavajsp.logica.Usuario;

import java.util.List;

public class UsuarioJpaController {

    // Singleton: Una única instancia de EntityManagerFactory
    private static UsuarioJpaController instancia;
    private static EntityManagerFactory emf;

    private UsuarioJpaController() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("demoPersistanceUnit");
        }
    }

    // Método para obtener la única instancia del controlador
    public static UsuarioJpaController getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioJpaController();
        }
        return instancia;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Crear Usuario
    public void crear(Usuario usuario) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Leer Usuario por ID
    public Usuario encontrarPorId(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    // Obtener Todos los Usuarios
    public List<Usuario> listarUsuarios() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
        } finally {
            em.close();
        }
    }

    // Actualizar Usuario
    public void actualizar(Usuario usuario) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Eliminar Usuario
    public void eliminar(Long id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Usuario usuario = em.find(Usuario.class, id);
            if (usuario != null) {
                em.remove(usuario);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Método para cerrar la conexión cuando la aplicación termine
    public void cerrar() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
