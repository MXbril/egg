package persistencia;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class ProductoDAO extends DAO {
    public void eliminarProductoPorCodigo(int codigo) throws Exception {
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM Producto WHERE id_producto = ?";
            connectarDataBase(); // Asegúrate de que este método establezca la conexión
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, codigo); // Usar PreparedStatement para prevenir inyección SQL
            int filasAfectadas = ps.executeUpdate(); // Ejecutar la consulta de eliminación
            if (filasAfectadas > 0) {
                System.out.println("El registro fue eliminado de manera exitosa.");
            } else {
                System.out.println("No se encontró un producto con el código proporcionado.");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el producto con id " + codigo + ": " + e.getMessage());
            throw e;
        } finally {
            if (ps != null) {
                try {
                    ps.close(); // Cerrar PreparedStatement
                } catch (SQLException e) {
                    System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());
                }
            }
            desconectarDataBase(); // Asegurarse de cerrar la conexión
        }
    }
}
