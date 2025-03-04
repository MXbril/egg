package servicios;

import entidades.Cliente;
import persistencia.ClienteDAO;
import java.util.List;

public class ClienteServicio {

    private ClienteDAO clienteDAO;

    // Constructor que inicializa el DAO
    public ClienteServicio() {
        this.clienteDAO = new ClienteDAO();
    }

    // Método para registrar un cliente, con posibles validaciones de negocio
    public void registrarCliente(Cliente cliente) throws Exception {
        try {
            // Aquí puedes realizar validaciones o transformaciones de datos
            if (cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()) {
                throw new Exception("El nombre del cliente no puede estar vacío.");
            }

            // Llamamos al DAO para insertar el cliente
            clienteDAO.insertarCliente(cliente);
            System.out.println("Cliente registrado con éxito.");
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para actualizar un cliente
    public void actualizarCliente(Cliente cliente) throws Exception {
        try {
            // Validaciones o transformaciones de datos
            if (cliente.getIdCliente() <= 0) {
                throw new Exception("ID de cliente inválido.");
            }

            clienteDAO.actualizarCliente(cliente);
            System.out.println("Cliente actualizado con éxito.");
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para eliminar un cliente
    public void eliminarCliente(int idCliente) throws Exception {
        try {
            if (idCliente <= 0) {
                throw new Exception("ID de cliente inválido.");
            }

            clienteDAO.eliminarCliente(idCliente);
            System.out.println("Cliente eliminado con éxito.");
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para obtener un cliente por su ID
    public Cliente obtenerClientePorId(int idCliente) throws Exception {
        try {
            if (idCliente <= 0) {
                throw new Exception("ID de cliente inválido.");
            }

            return clienteDAO.obtenerClientePorId(idCliente);
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para listar todos los clientes
    public List<Cliente> listarClientes() throws Exception {
        try {
            return clienteDAO.listarClientes();
        } catch (Exception e) {
            throw e;
        }
    }
}
