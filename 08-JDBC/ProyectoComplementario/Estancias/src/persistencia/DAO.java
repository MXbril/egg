package persistencia;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DAO {
     protected Connection conexion = null;
    protected ResultSet resultSet = null;
    protected Statement statement = null;
    private final String HOST = "127.0.0.1";
    private final String PORT = "3306";
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "estancias_exterior";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String ZONA = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public void conectarDataBase() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(DRIVER);
            String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + ZONA;
            conexion = DriverManager.getConnection(url, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();  // Más útil para diagnóstico
            throw e;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

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
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    protected void insertarModificarEliminarDataBase(String sql, Object... params) throws Exception {
    try {
        conectarDataBase();
        // Usar PreparedStatement para evitar inyecciones SQL
        PreparedStatement preparedStatement = conexion.prepareStatement(sql);
        
        // Si hay parámetros, establecerlos en el PreparedStatement
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }
        
        int filasAfectadas = preparedStatement.executeUpdate();
        System.out.println("Operación exitosa. Filas afectadas: " + filasAfectadas);
    } catch (SQLException | ClassNotFoundException e) {
        System.out.println("Error al ejecutar la operación: " + e.getMessage());
        throw e; // Rethrow para que el manejador lo trate
    } finally {
        desconectarDataBase();
    }
}

    protected ResultSet consultarDataBase(String sql, Object... params) throws Exception {
        ResultSet resultSet = null;
        try {
            conectarDataBase();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            
            // Si hay parámetros, establecerlos en el PreparedStatement
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
        return resultSet; // Devolver el ResultSet para ser procesado por el llamador
    }
}
