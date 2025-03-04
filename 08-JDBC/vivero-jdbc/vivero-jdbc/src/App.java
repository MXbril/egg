import java.sql.Connection;
import java.sql.SQLException;
import persistencia.DataBaseConnection;

public class App {
    
    public static void main(String[] args) throws Exception {
        DataBaseConnection dbConnection = new DataBaseConnection();
        // PedidoServicio pedidoServicio = new PedidoServicio();
        // ClienteServicio clienteServicio = new ClienteServicio();
        // ProductoDAO productoDAO = new ProductoDAO();
        // ClienteDAO clienteDAO = new ClienteDAO();
        Connection conexion = null;
        try {
            dbConnection.connectarDataBase(); // Conectar a la base de datos
            conexion = dbConnection.getConexion(); // obtener conección
            System.out.println("Conexión establecida exitosamente.");
            // clienteServicio.listarTodosLosClientes();
            // clienteServicio.buscarClientePorCodigo(1);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (conexion != null && !conexion.isClosed()) { // Verificar que la conexión no sea null y esté abierta
                    dbConnection.desconectarDataBase(); // Llamar al método desconectar
                    System.out.println("Desconexión exitosa.");
                }
            } catch (SQLException e) {
                System.out.println("Error al desconectar: " + e.getMessage());
            }
        }
    }
}
