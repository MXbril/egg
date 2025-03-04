package persistencia;

import entidades.Comentario;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ComentarioDAO extends DAO {

    // Método para insertar un comentario en la base de datos
    public void insertarComentario(Comentario comentario) throws Exception {
        try {
            String sql = "INSERT INTO comentarios (id_casa, comentario) VALUES (?, ?)";

            insertarModificarEliminarDataBase(sql,
                comentario.getIdCasa(),
                comentario.getComentario());

        } catch (Exception e) {
            throw e;
        }
    }

    // Método para actualizar un comentario en la base de datos
    public void actualizarComentario(Comentario comentario) throws Exception {
        try {
            String sql = "UPDATE comentarios SET id_casa = ?, comentario = ? WHERE id_comentario = ?";

            insertarModificarEliminarDataBase(sql,
                comentario.getIdCasa(),
                comentario.getComentario(),
                comentario.getIdComentario());

        } catch (Exception e) {
            throw e;
        }
    }

    // Método para eliminar un comentario de la base de datos
    public void eliminarComentario(int idComentario) throws Exception {
        try {
            String sql = "DELETE FROM comentarios WHERE id_comentario = ?";
            insertarModificarEliminarDataBase(sql, idComentario);
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para obtener un comentario por su ID
    public Comentario obtenerComentarioPorId(int idComentario) throws Exception {
        try {
            String sql = "SELECT * FROM comentarios WHERE id_comentario = ?";
            ResultSet rs = consultarDataBase(sql, idComentario);

            Comentario comentario = null;
            if (rs.next()) {
                comentario = new Comentario();
                comentario.setIdComentario(rs.getInt("id_comentario"));
                comentario.setIdCasa(rs.getInt("id_casa"));
                comentario.setComentario(rs.getString("comentario"));
            }
            return comentario;

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDataBase();
        }
    }

    // Método para listar todos los comentarios
    public List<Comentario> listarComentarios() throws Exception {
        try {
            String sql = "SELECT * FROM comentarios";
            ResultSet rs = consultarDataBase(sql);

            List<Comentario> comentarios = new ArrayList<>();
            while (rs.next()) {
                Comentario comentario = new Comentario();
                comentario.setIdComentario(rs.getInt("id_comentario"));
                comentario.setIdCasa(rs.getInt("id_casa"));
                comentario.setComentario(rs.getString("comentario"));
                comentarios.add(comentario);
            }
            return comentarios;

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDataBase();
        }
    }
}
