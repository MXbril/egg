package persistencia;
import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseConnection extends DAO {
    public void ejecutarConsulta(String query) {
        try {
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(query);
            // Manejar el resultado de la consulta si es necesario
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }
    }

    @Override
    public void connectarDataBase() throws SQLException, ClassNotFoundException {
        super.connectarDataBase(); // Llama al método de conexión de la clase base DAO
    }

    @Override
    public void desconectarDataBase() throws SQLException {
        super.desconectarDataBase(); // Llama al método de desconexión de la clase base DAO
    }

    public Connection getConexion() {
        return this.conexion; // Devuelve la conexión de la clase DAO
    }
}
