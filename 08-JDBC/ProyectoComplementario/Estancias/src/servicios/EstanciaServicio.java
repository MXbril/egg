package servicios;

import entidades.Estancia;
import persistencia.EstanciaDAO;
import java.util.List;

public class EstanciaServicio {

    private EstanciaDAO estanciaDAO;

    // Constructor que inicializa el DAO
    public EstanciaServicio() {
        this.estanciaDAO = new EstanciaDAO();
    }

    // Método para registrar una estancia
    public void registrarEstancia(Estancia estancia) throws Exception {
        try {
            // Validaciones antes de insertar
            if (estancia.getIdCliente() <= 0) {
                throw new Exception("ID de cliente inválido.");
            }
            if (estancia.getIdCasa() <= 0) {
                throw new Exception("ID de casa inválido.");
            }
            if (estancia.getNombreHuesped() == null || estancia.getNombreHuesped().trim().isEmpty()) {
                throw new Exception("El nombre del huésped no puede estar vacío.");
            }

            estanciaDAO.insertarEstancia(estancia);
            System.out.println("Estancia registrada con éxito.");
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para actualizar una estancia
    public void actualizarEstancia(Estancia estancia) throws Exception {
        try {
            // Validaciones
            if (estancia.getIdEstancia() <= 0) {
                throw new Exception("ID de estancia inválido.");
            }

            estanciaDAO.actualizarEstancia(estancia);
            System.out.println("Estancia actualizada con éxito.");
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para eliminar una estancia
    public void eliminarEstancia(int idEstancia) throws Exception {
        try {
            if (idEstancia <= 0) {
                throw new Exception("ID de estancia inválido.");
            }

            estanciaDAO.eliminarEstancia(idEstancia);
            System.out.println("Estancia eliminada con éxito.");
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para obtener una estancia por su ID
    public Estancia obtenerEstanciaPorId(int idEstancia) throws Exception {
        try {
            if (idEstancia <= 0) {
                throw new Exception("ID de estancia inválido.");
            }

            return estanciaDAO.obtenerEstanciaPorId(idEstancia);
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para listar todas las estancias
    public List<Estancia> listarEstancias() throws Exception {
        try {
            return estanciaDAO.listarEstancias();
        } catch (Exception e) {
            throw e;
        }
    }
}
