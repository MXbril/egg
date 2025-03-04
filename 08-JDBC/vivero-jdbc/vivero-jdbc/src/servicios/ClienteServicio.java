package servicios;
import entidades.Cliente;
import persistencia.ClienteDAO;

public class ClienteServicio {
    private ClienteDAO cd;

    public ClienteServicio() {
        this.cd = new ClienteDAO();
    }

    public Cliente CrearNuevoCliente(int codigoCliente, String nombreCliente, String nombreContacto, String apellidoContacto, String telefono, String fax,
                                    String ciudad, String region, String pais, String codigoPostal, int idEmpleado, double limiteCredito) throws Exception {
        validarDatosCliente(nombreContacto, apellidoContacto, telefono, limiteCredito);
        Cliente cliente = new Cliente(codigoCliente, nombreCliente, nombreContacto, apellidoContacto, telefono, fax, ciudad, region, pais, codigoPostal, idEmpleado, limiteCredito);
        // Guardar cliente
        cd.guardarCliente(cliente);
        System.out.println("Cliente creado exitosamente: " +cliente.toString());
        return cliente;
    }

    public void validarDatosCliente(String nombrecontacto, String apellidoContacto, String telefono, double limiteCredito) throws Exception {
        if (nombrecontacto == null || nombrecontacto.isEmpty()) {
            throw new Exception("El nombre del contacto no puede ser nulo o vacío.");
        }
        if (apellidoContacto == null || apellidoContacto.isEmpty()) {
            throw new Exception("El apellido del contacto no puede ser nulo o vacío.");
        }
        if (telefono == null || telefono.isEmpty()) {
            throw new Exception("El teléfono no puede ser nulo o vacío.");
        }
        if (limiteCredito <= 0) {
            throw new Exception("El límite de crédito debe ser mayor a 0.");
        }
    }

    public void listarTodosLosClientes() {
        try {
            System.out.println("Listando todos los clientes...");
            cd.listarTodosLosClientes();
        } catch (Exception e) {
            System.out.println("Error al listar los clientes: " +e.getMessage());
        }
    }

    // Método para buscar un cliente por su código
    public void buscarClientePorCodigo(int codigo) {
        if (codigo <= 0) {
            System.out.println("El código de cliente debe ser un número positivo.");
            return;
        }
        try {
            System.out.println("Buscando cliente con el código: " +codigo);
            Cliente cliente = cd.buscarClientePorCodigo(codigo);
            if (cliente != null) {
                System.out.println("Cliente encontrado:");
                System.out.println(cliente.toString());
            } else {
                System.out.println("No se encontró un cliente con el código: " +codigo);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar el cliente: " + e.getMessage());
        }
    }
}
