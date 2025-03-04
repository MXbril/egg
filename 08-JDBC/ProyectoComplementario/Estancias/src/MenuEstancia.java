// import java.sql.SQLException;
// import persistencia.DAO;

// public class MenuEstancia extends DAO {
//     public void iniciarConexión() {
//         try {
//             this.conectarDataBase(); // Usa this para llamar al método de la clase base
//             // Aquí puedes añadir más lógica, como realizar consultas a la base de datos.
//         } catch (ClassNotFoundException e) {
//             System.err.println("Error: Driver no encontrado.");
//             e.printStackTrace();
//         } catch (SQLException e) {
//             System.err.println("Error de conexión: " + e.getMessage());
//             e.printStackTrace();
//         } finally {
//             try {
//                 this.desconectarDataBase(); // Asegúrate de desconectar
//                 System.out.println("Desconexión de la base de datos.");
//             } catch (SQLException e) {
//                 System.err.println("Error al desconectar: " + e.getMessage());
//                 e.printStackTrace();
//             }
//         }
//     }
// }