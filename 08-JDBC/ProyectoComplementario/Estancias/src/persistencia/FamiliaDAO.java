package persistencia;

import entidades.Familia;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FamiliaDAO extends DAO {

    // Método para insertar una familia en la base de datos
    public void insertarFamilia(Familia familia) throws Exception {
        try {
            String sql = "INSERT INTO familias (nombre, edad_minima, edad_maxima, num_hijos, email, id_casa_familia) " +
                         "VALUES (?, ?, ?, ?, ?, ?)";

            insertarModificarEliminarDataBase(sql,
                familia.getNombre(),
                familia.getEdadMinima(),
                familia.getEdadMaxima(),
                familia.getNumHijos(),
                familia.getEmail(),
                familia.getIdCasaFamilia());

        } catch (Exception e) {
            throw e;
        }
    }

    // Método para actualizar una familia en la base de datos
    public void actualizarFamilia(Familia familia) throws Exception {
        try {
            String sql = "UPDATE familias SET nombre = ?, edad_minima = ?, edad_maxima = ?, num_hijos = ?, email = ?, id_casa_familia = ? " +
                         "WHERE id_familia = ?";

            insertarModificarEliminarDataBase(sql,
                familia.getNombre(),
                familia.getEdadMinima(),
                familia.getEdadMaxima(),
                familia.getNumHijos(),
                familia.getEmail(),
                familia.getIdCasaFamilia(),
                familia.getIdFamilia());

        } catch (Exception e) {
            throw e;
        }
    }

    // Método para eliminar una familia de la base de datos
    public void eliminarFamilia(int idFamilia) throws Exception {
        try {
            String sql = "DELETE FROM familias WHERE id_familia = ?";
            insertarModificarEliminarDataBase(sql, idFamilia);
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para obtener una familia por su ID
    public Familia obtenerFamiliaPorId(int idFamilia) throws Exception {
        try {
            String sql = "SELECT * FROM familias WHERE id_familia = ?";
            ResultSet rs = consultarDataBase(sql, idFamilia);

            Familia familia = null;
            if (rs.next()) {
                familia = new Familia();
                familia.setIdFamilia(rs.getInt("id_familia"));
                familia.setNombre(rs.getString("nombre"));
                familia.setEdadMinima(rs.getInt("edad_minima"));
                familia.setEdadMaxima(rs.getInt("edad_maxima"));
                familia.setNumHijos(rs.getInt("num_hijos"));
                familia.setEmail(rs.getString("email"));
                familia.setIdCasaFamilia(rs.getInt("id_casa_familia"));
            }
            return familia;

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDataBase();
        }
    }

    // Método para listar todas las familias
    public List<Familia> listarFamilias() throws Exception {
        try {
            String sql = "SELECT * FROM familias";
            ResultSet rs = consultarDataBase(sql);

            List<Familia> familias = new ArrayList<>();
            while (rs.next()) {
                Familia familia = new Familia();
                familia.setIdFamilia(rs.getInt("id_familia"));
                familia.setNombre(rs.getString("nombre"));
                familia.setEdadMinima(rs.getInt("edad_minima"));
                familia.setEdadMaxima(rs.getInt("edad_maxima"));
                familia.setNumHijos(rs.getInt("num_hijos"));
                familia.setEmail(rs.getString("email"));
                familia.setIdCasaFamilia(rs.getInt("id_casa_familia"));
                familias.add(familia);
            }
            return familias;

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDataBase();
        }
    }

    // Método para listar familias con un número mínimo de hijos y una edad máxima inferior a un valor dado
    public List<Familia> listarFamiliasConHijosYEdad(int numHijos, int edadMaxima) throws Exception {
        List<Familia> familias = new ArrayList<>();
        try {
            // Consulta SQL ajustada con parámetros para el número de hijos y la edad máxima
            String sql = "SELECT * FROM familias WHERE num_hijos >= ? AND edad_maxima < ?";
            ResultSet resultSet = consultarDataBase(sql, numHijos, edadMaxima);  // Ambos parámetros son dinámicos ahora
            
            // Iteramos sobre los resultados para llenar la lista de familias
            while (resultSet.next()) {
                Familia familia = new Familia();
                familia.setIdFamilia(resultSet.getInt("id_familia"));
                familia.setNombre(resultSet.getString("nombre"));
                familia.setEdadMinima(resultSet.getInt("edad_minima"));
                familia.setEdadMaxima(resultSet.getInt("edad_maxima"));
                familia.setNumHijos(resultSet.getInt("num_hijos"));
                familia.setEmail(resultSet.getString("email"));
                familia.setIdCasaFamilia(resultSet.getInt("id_casa_familia"));
                
                // Añadimos la familia a la lista de resultados
                familias.add(familia);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            desconectarDataBase(); // Aseguramos que la base de datos se desconecta al final
        }
        return familias;
    }
}
