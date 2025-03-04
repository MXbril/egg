package persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidades.DetallePedido;

public class DetallePedidoDAO extends DAO {
    // Método para guardar un detalle de pedido
    public void guardarDetallePedido(DetallePedido detalle) throws Exception {
        String sql = "INSERT INTO detalle_pedido (id_pedido, id_producto, cantidad, precio_unidad, numero_linea) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try {
            connectarDataBase();

            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, detalle.getIdPedido());
            ps.setInt(2, detalle.getIdProducto());
            ps.setInt(3, detalle.getCantidad());
            ps.setDouble(4, detalle.getPrecioUnidad());
            ps.setShort(5, detalle.getNumeroLinea());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new Exception("Error al guardar el detalle del pedido: " + e.getMessage());
        } finally {
            desconectarDataBase();
        }
    }
}
