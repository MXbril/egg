package persistencia;

import entidades.Cliente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO extends DAO {

    // Método para insertar un cliente en la base de datos
    public void insertarCliente(Cliente cliente) throws Exception {
        try {
            String sql = "INSERT INTO clientes (nombre, calle, numero, codigo_postal, ciudad, pais, email) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            insertarModificarEliminarDataBase(sql, 
                cliente.getNombre(), 
                cliente.getCalle(), 
                cliente.getNumero(), 
                cliente.getCodigoPostal(), 
                cliente.getCiudad(), 
                cliente.getPais(), 
                cliente.getEmail());
            
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para actualizar un cliente en la base de datos
    public void actualizarCliente(Cliente cliente) throws Exception {
        try {
            String sql = "UPDATE clientes SET nombre = ?, calle = ?, numero = ?, codigo_postal = ?, ciudad = ?, pais = ?, email = ? " +
                         "WHERE id_cliente = ?";
            
            insertarModificarEliminarDataBase(sql, 
                cliente.getNombre(), 
                cliente.getCalle(), 
                cliente.getNumero(), 
                cliente.getCodigoPostal(), 
                cliente.getCiudad(), 
                cliente.getPais(), 
                cliente.getEmail(), 
                cliente.getIdCliente());
            
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para eliminar un cliente de la base de datos
    public void eliminarCliente(int idCliente) throws Exception {
        try {
            String sql = "DELETE FROM clientes WHERE id_cliente = ?";
            insertarModificarEliminarDataBase(sql, idCliente);
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para consultar un cliente por su ID
    public Cliente obtenerClientePorId(int idCliente) throws Exception {
        try {
            String sql = "SELECT * FROM clientes WHERE id_cliente = ?";
            ResultSet rs = consultarDataBase(sql, idCliente);

            Cliente cliente = null;
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setCalle(rs.getString("calle"));
                cliente.setNumero(rs.getInt("numero"));
                cliente.setCodigoPostal(rs.getString("codigo_postal"));
                cliente.setCiudad(rs.getString("ciudad"));
                cliente.setPais(rs.getString("pais"));
                cliente.setEmail(rs.getString("email"));
            }
            return cliente;

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDataBase();
        }
    }

    // Método para listar todos los clientes
    public List<Cliente> listarClientes() throws Exception {
        try {
            String sql = "SELECT * FROM clientes";
            ResultSet rs = consultarDataBase(sql);

            List<Cliente> clientes = new ArrayList<>();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setCalle(rs.getString("calle"));
                cliente.setNumero(rs.getInt("numero"));
                cliente.setCodigoPostal(rs.getString("codigo_postal"));
                cliente.setCiudad(rs.getString("ciudad"));
                cliente.setPais(rs.getString("pais"));
                cliente.setEmail(rs.getString("email"));
                clientes.add(cliente);
            }
            return clientes;

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDataBase();
        }
    }
}
