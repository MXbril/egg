package persistencia;

import entidades.Casa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CasaDAO extends DAO {

    // Método para insertar una casa en la base de datos
    public void insertarCasa(Casa casa) throws Exception {
        try {
            String sql = "INSERT INTO casas (calle, numero, codigo_postal, ciudad, pais, fecha_desde, fecha_hasta, tiempo_minimo, tiempo_maximo, precio_habitacion, tipo_vivienda) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            insertarModificarEliminarDataBase(sql,
                casa.getCalle(),
                casa.getNumero(),
                casa.getCodigoPostal(),
                casa.getCiudad(),
                casa.getPais(),
                casa.getFechaDesde(),
                casa.getFechaHasta(),
                casa.getTiempoMinimo(),
                casa.getTiempoMaximo(),
                casa.getPrecioHabitacion(),
                casa.getTipoVivienda());
            
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para actualizar una casa en la base de datos
    public void actualizarCasa(Casa casa) throws Exception {
        try {
            String sql = "UPDATE casas SET calle = ?, numero = ?, codigo_postal = ?, ciudad = ?, pais = ?, fecha_desde = ?, fecha_hasta = ?, tiempo_minimo = ?, tiempo_maximo = ?, precio_habitacion = ?, tipo_vivienda = ? " +
                         "WHERE id_casa = ?";
            
            insertarModificarEliminarDataBase(sql,
                casa.getCalle(),
                casa.getNumero(),
                casa.getCodigoPostal(),
                casa.getCiudad(),
                casa.getPais(),
                casa.getFechaDesde(),
                casa.getFechaHasta(),
                casa.getTiempoMinimo(),
                casa.getTiempoMaximo(),
                casa.getPrecioHabitacion(),
                casa.getTipoVivienda(),
                casa.getIdCasa());
            
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para eliminar una casa de la base de datos
    public void eliminarCasa(int idCasa) throws Exception {
        try {
            String sql = "DELETE FROM casas WHERE id_casa = ?";
            insertarModificarEliminarDataBase(sql, idCasa);
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para obtener una casa por su ID
    public Casa obtenerCasaPorId(int idCasa) throws Exception {
        try {
            String sql = "SELECT * FROM casas WHERE id_casa = ?";
            ResultSet rs = consultarDataBase(sql, idCasa);

            Casa casa = null;
            if (rs.next()) {
                casa = new Casa();
                casa.setIdCasa(rs.getInt("id_casa"));
                casa.setCalle(rs.getString("calle"));
                casa.setNumero(rs.getInt("numero"));
                casa.setCodigoPostal(rs.getString("codigo_postal"));
                casa.setCiudad(rs.getString("ciudad"));
                casa.setPais(rs.getString("pais"));
                casa.setFechaDesde(rs.getDate("fecha_desde"));
                casa.setFechaHasta(rs.getDate("fecha_hasta"));
                casa.setTiempoMinimo(rs.getInt("tiempo_minimo"));
                casa.setTiempoMaximo(rs.getInt("tiempo_maximo"));
                casa.setPrecioHabitacion(rs.getDouble("precio_habitacion"));
                casa.setTipoVivienda(rs.getString("tipo_vivienda"));
            }
            return casa;

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDataBase();
        }
    }

    // Método para listar todas las casas
    public List<Casa> listarCasas() throws Exception {
        try {
            String sql = "SELECT * FROM casas";
            ResultSet rs = consultarDataBase(sql);

            List<Casa> casas = new ArrayList<>();
            while (rs.next()) {
                Casa casa = new Casa();
                casa.setIdCasa(rs.getInt("id_casa"));
                casa.setCalle(rs.getString("calle"));
                casa.setNumero(rs.getInt("numero"));
                casa.setCodigoPostal(rs.getString("codigo_postal"));
                casa.setCiudad(rs.getString("ciudad"));
                casa.setPais(rs.getString("pais"));
                casa.setFechaDesde(rs.getDate("fecha_desde"));
                casa.setFechaHasta(rs.getDate("fecha_hasta"));
                casa.setTiempoMinimo(rs.getInt("tiempo_minimo"));
                casa.setTiempoMaximo(rs.getInt("tiempo_maximo"));
                casa.setPrecioHabitacion(rs.getDouble("precio_habitacion"));
                casa.setTipoVivienda(rs.getString("tipo_vivienda"));
                casas.add(casa);
            }
            return casas;

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDataBase();
        }
    }

    public List<Casa> listarCasasDisponiblesReinoUnido(String fechaInicio, String fechaFin) throws Exception {
        List<Casa> casas = new ArrayList<>();
        String sql = "SELECT * FROM casas WHERE pais = 'Reino Unido' AND fecha_desde >= ? AND fecha_hasta <= ?";

        try (ResultSet resultSet = consultarDataBase(sql, fechaInicio, fechaFin)) {
            while (resultSet.next()) {
                Casa casa = new Casa();
                casa.setIdCasa(resultSet.getInt("id_casa"));
                casa.setCalle(resultSet.getString("calle"));
                casa.setNumero(resultSet.getInt("numero"));
                casa.setCodigoPostal(resultSet.getString("codigo_postal"));
                casa.setCiudad(resultSet.getString("ciudad"));
                casa.setPais(resultSet.getString("pais"));
                casa.setFechaDesde(resultSet.getDate("fecha_desde"));
                casa.setFechaHasta(resultSet.getDate("fecha_hasta"));
                casa.setTiempoMinimo(resultSet.getInt("tiempo_minimo"));
                casa.setTiempoMaximo(resultSet.getInt("tiempo_maximo"));
                casa.setPrecioHabitacion(resultSet.getDouble("precio_habitacion"));
                casa.setTipoVivienda(resultSet.getString("tipo_vivienda"));

                casas.add(casa); // Agregar la casa a la lista
            }
        } catch (SQLException e) {
            throw new Exception("Error al consultar casas: " + e.getMessage(), e);
        }

        return casas; // Retorna la lista de casas encontradas
    }
}
