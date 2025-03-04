package servicios;

import entidades.Comentario;
import persistencia.ComentarioDAO;
import java.util.List;

public class ComentarioServicio {
    private ComentarioDAO comentarioDAO;

    // Constructor que inicializa el DAO
    public ComentarioServicio() {
        this.comentarioDAO = new ComentarioDAO();
    }

    // Método para registrar un comentario
    public void registrarComentario(Comentario comentario) throws Exception {
        try {
            // Validaciones antes de insertar
            if (comentario.getComentario() == null || comentario.getComentario().trim().isEmpty()) {
                throw new Exception("El comentario no puede estar vacío.");
            }
            if (comentario.getIdCasa() <= 0) {
                throw new Exception("ID de casa inválido.");
            }

            comentarioDAO.insertarComentario(comentario);
            System.out.println("Comentario registrado con éxito.");
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para actualizar un comentario
    public void actualizarComentario(Comentario comentario) throws Exception {
        try {
            // Validaciones antes de actualizar
            if (comentario.getIdComentario() <= 0) {
                throw new Exception("ID de comentario inválido.");
            }
            if (comentario.getComentario() == null || comentario.getComentario().trim().isEmpty()) {
                throw new Exception("El comentario no puede estar vacío.");
            }
            if (comentario.getIdCasa() <= 0) {
                throw new Exception("ID de casa inválido.");
            }

            comentarioDAO.actualizarComentario(comentario);
            System.out.println("Comentario actualizado con éxito.");
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para eliminar un comentario
    public void eliminarComentario(int idComentario) throws Exception {
        try {
            if (idComentario <= 0) {
                throw new Exception("ID de comentario inválido.");
            }

            comentarioDAO.eliminarComentario(idComentario);
            System.out.println("Comentario eliminado con éxito.");
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para obtener un comentario por su ID
    public Comentario obtenerComentarioPorId(int idComentario) throws Exception {
        try {
            if (idComentario <= 0) {
                throw new Exception("ID de comentario inválido.");
            }

            return comentarioDAO.obtenerComentarioPorId(idComentario);
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para listar todos los comentarios
    public List<Comentario> listarComentarios() throws Exception {
        try {
            return comentarioDAO.listarComentarios();
        } catch (Exception e) {
            throw e;
        }
    }
}
