package persistencia;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entidades.Pedido;

public class PedidoDAO extends DAO {
    public int guardarPedido(Pedido pedido) throws Exception {
        if (pedido == null) {
            throw new Exception("El pedido no puede ser nulo.");
        }
        int idPedidoGenerado = 0;
        String sql = "INSERT INTO pedido (codigo_pedido, fecha_pedido, fecha_esperada, fecha_entrega, estado, comentarios, id_cliente) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try {
            connectarDataBase();
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pedido.getCodigoPedido());
            ps.setDate(2, new java.sql.Date(pedido.getFechaPedido().getTime()));
            ps.setDate(3, new java.sql.Date(pedido.getFechaEsperada().getTime()));
            ps.setDate(4, new java.sql.Date(pedido.getFechaEntrega().getTime()));
            ps.setString(5, pedido.getEstado());
            ps.setString(6, pedido.getComentarios());
            ps.setInt(7, pedido.getIdCliente());
            
            ps.executeUpdate();
            
            // Obtener el ID generado del pedido para asociar con los detalles
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idPedidoGenerado = rs.getInt(1); // Asignar el ID generado al pedido
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new Exception("Error al guardar el pedido: " + e.getMessage());
        } finally {
            desconectarDataBase();
        }
        return idPedidoGenerado;
    }
}
