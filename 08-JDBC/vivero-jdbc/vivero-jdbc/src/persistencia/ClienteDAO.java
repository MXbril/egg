package persistencia;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entidades.Cliente;

public class ClienteDAO extends DAO {
    public void guardarCliente(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new Exception("El cliente no puede ser nulo");
        }

        String sql = "INSERT INTO cliente (codigo_cliente, nombre_cliente, nombre_contacto, apellido_contacto, telefono, fax, ciudad, region, pais, codigo_postal, id_empleado, limite_credito) " +
        "VALUES (" + 
        cliente.getCodigoCliente() + ", '" +
        cliente.getNombreCliente() + "', '" +
        cliente.getNombreContacto() + "', '" +
        cliente.getApellidoContacto() + "', '" +
        cliente.getTelefono() + "', '" +
        cliente.getFax() + "', '" +
        cliente.getCiudad() + "', '" +
        cliente.getRegion() + "', '" +
        cliente.getPais() + "', '" +
        cliente.getCodigoPostal() + "', " +
        cliente.getIdEmpleado() + ", " +
        cliente.getLimiteCredito() + ");";
        try {
            insertarModificarEliminarDataBase(sql);
            System.out.println("Cliente guardado con exito");
        } catch (SQLException e) {
            System.out.println("Error al guardar el cliente: " +e.getMessage());
            throw e;
        } finally {
            desconectarDataBase();
        }
    }

    public void listarTodosLosClientes() throws Exception {
        String sql = "SELECT id_cliente, nombre_contacto, apellido_contacto FROM cliente";
        List<Cliente> clientes = new ArrayList<>();
        try {
            consultarDataBase(sql);
            if (resultSet != null) {
                while (resultSet.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(resultSet.getInt("id_cliente"));
                    cliente.setNombreContacto(resultSet.getString("nombre_contacto"));
                    cliente.setApellidoContacto(resultSet.getString("apellido_contacto"));
                    clientes.add(cliente);
                }             
            } else {
                System.out.println("El Resultset es nulo. Verifica la consulta.");
            }
        } catch (SQLException e) {
            System.out.println("Error al listar los clientes: " + e.getMessage());
            throw e;
        } finally {
            // Aseguramos que se cierran los recursos
            desconectarDataBase(); // Cerramos la conexión a la base de datos
        }
        // Imprimimos los clientes si existen
        if (!clientes.isEmpty()) {
            for (Cliente cliente : clientes) {
                cliente.imprimirDatosCliente(); // Método que imprime el id, nombre y apellido
            }
        } else {
            System.out.println("No se encontraron clientes en la base de datos.");
        }
    }

    public Cliente buscarClientePorCodigo(int codigo) throws Exception {
        Cliente cliente = null; // Declaramos un objeto Cliente que será devuelto si se encuentra el registro

        try {
            // SQL query con un placeholder (?) para buscar por id_cliente
            String sql = "SELECT * FROM cliente WHERE id_cliente = ?";

            // Establecemos la conexión y preparamos el PreparedStatement
            connectarDataBase(); 
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            // Asignamos el valor del código al primer placeholder (?)
            ps.setInt(1, codigo);

            // Ejecutamos la consulta
            ResultSet rs = ps.executeQuery();

            // Si hay un resultado, lo asignamos al objeto cliente
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setCodigoCliente(rs.getInt("codigo_cliente"));
                cliente.setNombreCliente(rs.getString("nombre_cliente"));
                cliente.setNombreContacto(rs.getString("nombre_contacto"));
                cliente.setApellidoContacto(rs.getString("apellido_contacto"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setFax(rs.getString("fax"));
                cliente.setCiudad(rs.getString("ciudad"));
                cliente.setRegion(rs.getString("region"));
                cliente.setPais(rs.getString("pais"));
                cliente.setCodigoPostal(rs.getString("codigo_postal"));
                cliente.setIdEmpleado(rs.getInt("id_empleado"));
                cliente.setLimiteCredito(rs.getDouble("limite_credito"));

                // Imprimimos la información del cliente usando toString()
                // System.out.println(cliente.toString());
            } else {
                System.out.println("No se encontró ningún cliente con el ID: " + codigo);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDataBase(); // Aseguramos que la conexión siempre se cierre
        }

        return cliente; // Devuelve el objeto cliente o null si no se encontró
    }
}