package servicios;

import entidades.Casa;
import persistencia.CasaDAO;
import java.util.List;

public class CasaServicio {

    private CasaDAO casaDAO;

    // Constructor que inicializa el DAO
    public CasaServicio() {
        this.casaDAO = new CasaDAO();
    }

    // Método para registrar una casa
    public void registrarCasa(Casa casa) throws Exception {
        try {
            // Validaciones antes de insertar
            if (casa.getCalle() == null || casa.getCalle().trim().isEmpty()) {
                throw new Exception("La calle no puede estar vacía.");
            }
            if (casa.getNumero() <= 0) {
                throw new Exception("El número de la casa debe ser válido.");
            }
            if (casa.getCiudad() == null || casa.getCiudad().trim().isEmpty()) {
                throw new Exception("La ciudad no puede estar vacía.");
            }
            if (casa.getPais() == null || casa.getPais().trim().isEmpty()) {
                throw new Exception("El país no puede estar vacío.");
            }
            if (casa.getPrecioHabitacion() <= 0) {
                throw new Exception("El precio de la habitación debe ser mayor a 0.");
            }

            casaDAO.insertarCasa(casa);
            System.out.println("Casa registrada con éxito.");
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para actualizar una casa
    public void actualizarCasa(Casa casa) throws Exception {
        try {
            // Validaciones
            if (casa.getIdCasa() <= 0) {
                throw new Exception("ID de casa inválido.");
            }

            casaDAO.actualizarCasa(casa);
            System.out.println("Casa actualizada con éxito.");
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para eliminar una casa
    public void eliminarCasa(int idCasa) throws Exception {
        try {
            if (idCasa <= 0) {
                throw new Exception("ID de casa inválido.");
            }

            casaDAO.eliminarCasa(idCasa);
            System.out.println("Casa eliminada con éxito.");
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para obtener una casa por su ID
    public Casa obtenerCasaPorId(int idCasa) throws Exception {
        try {
            if (idCasa <= 0) {
                throw new Exception("ID de casa inválido.");
            }

            return casaDAO.obtenerCasaPorId(idCasa);
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para listar todas las casas
    public List<Casa> listarCasas() throws Exception {
        try {
            return casaDAO.listarCasas();
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para listar casas disponibles en Reino Unido entre las fechas dadas
    public List<Casa> listarCasasDisponiblesReinoUnido(String fechaInicio, String fechaFin) throws Exception {
        // Llamar al método de CasaDAO para obtener las casas disponibles
        return casaDAO.listarCasasDisponiblesReinoUnido(fechaInicio, fechaFin);
    }
}
