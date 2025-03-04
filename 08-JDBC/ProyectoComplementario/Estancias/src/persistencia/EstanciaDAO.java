package persistencia;

import entidades.Estancia;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class EstanciaDAO extends DAO {

    // Método para insertar una estancia en la base de datos
    public void insertarEstancia(Estancia estancia) throws Exception {
        try {
            String sql = "INSERT INTO estancias (id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta) " +
                         "VALUES (?, ?, ?, ?, ?)";
            
            insertarModificarEliminarDataBase(sql,
                estancia.getIdCliente(),
                estancia.getIdCasa(),
                estancia.getNombreHuesped(),
                estancia.getFechaDesde(),
                estancia.getFechaHasta());
            
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para actualizar una estancia en la base de datos
    public void actualizarEstancia(Estancia estancia) throws Exception {
        try {
            String sql = "UPDATE estancias SET id_cliente = ?, id_casa = ?, nombre_huesped = ?, fecha_desde = ?, fecha_hasta = ? " +
                         "WHERE id_estancia = ?";
            
            insertarModificarEliminarDataBase(sql,
                estancia.getIdCliente(),
                estancia.getIdCasa(),
                estancia.getNombreHuesped(),
                estancia.getFechaDesde(),
                estancia.getFechaHasta(),
                estancia.getIdEstancia());
            
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para eliminar una estancia de la base de datos
    public void eliminarEstancia(int idEstancia) throws Exception {
        try {
            String sql = "DELETE FROM estancias WHERE id_estancia = ?";
            insertarModificarEliminarDataBase(sql, idEstancia);
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para obtener una estancia por su ID
    public Estancia obtenerEstanciaPorId(int idEstancia) throws Exception {
        try {
            String sql = "SELECT * FROM estancias WHERE id_estancia = ?";
            ResultSet rs = consultarDataBase(sql, idEstancia);

            Estancia estancia = null;
            if (rs.next()) {
                estancia = new Estancia();
                estancia.setIdEstancia(rs.getInt("id_estancia"));
                estancia.setIdCliente(rs.getInt("id_cliente"));
                estancia.setIdCasa(rs.getInt("id_casa"));
                estancia.setNombreHuesped(rs.getString("nombre_huesped"));
                estancia.setFechaDesde(rs.getDate("fecha_desde"));
                estancia.setFechaHasta(rs.getDate("fecha_hasta"));
            }
            return estancia;

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDataBase();
        }
    }

    // Método para listar todas las estancias
    public List<Estancia> listarEstancias() throws Exception {
        try {
            String sql = "SELECT * FROM estancias";
            ResultSet rs = consultarDataBase(sql);

            List<Estancia> estancias = new ArrayList<>();
            while (rs.next()) {
                Estancia estancia = new Estancia();
                estancia.setIdEstancia(rs.getInt("id_estancia"));
                estancia.setIdCliente(rs.getInt("id_cliente"));
                estancia.setIdCasa(rs.getInt("id_casa"));
                estancia.setNombreHuesped(rs.getString("nombre_huesped"));
                estancia.setFechaDesde(rs.getDate("fecha_desde"));
                estancia.setFechaHasta(rs.getDate("fecha_hasta"));
                estancias.add(estancia);
            }
            return estancias;

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDataBase();
        }
    }
}
