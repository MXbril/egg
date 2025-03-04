package persistencia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;

public abstract class DAO implements ConectorBD {
    protected Connection conexion = null;
    protected ResultSet resultSet = null;
    protected Statement statement = null;
    private final String HOST = "127.0.0.1";
    private final String PORT = "3306";
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "vivero";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String ZONA = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    @Override
    public void connectarDataBase() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(DRIVER);
            String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + ZONA;
            conexion = DriverManager.getConnection(url, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public void desconectarDataBase() throws SQLException {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    protected void insertarModificarEliminarDataBase(String sql) throws Exception {
        try {
            // Conectar a la base de datos
            connectarDataBase();
            // Crear un Statement para ejecutar la consulta
            statement = conexion.createStatement();
            // Ejecutar la sentencia SQL (INSERT, UPDATE o DELETE)
            int filasAfectadas = statement.executeUpdate(sql);
            System.out.println("Operación exitosa. Filas afectadas: " + filasAfectadas);
        } catch (SQLException | ClassNotFoundException e) {
            // Manejar cualquier excepción que pueda ocurrir durante la ejecución
            System.out.println("Error al ejecutar la operación: " + e.getMessage());
            throw e; // Rethrow para que el manejador lo trate
        } finally {
            // Asegurarse de cerrar la conexión siempre
            desconectarDataBase();
        }
    }

    protected void consultarDataBase(String sql) throws Exception {
        try {
            connectarDataBase(); // Método que puede lanzar ClassNotFoundException
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }
}