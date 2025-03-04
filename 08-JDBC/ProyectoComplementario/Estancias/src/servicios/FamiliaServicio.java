package servicios;

import entidades.Familia;
import persistencia.FamiliaDAO;

import java.util.ArrayList;
import java.util.List;

public class FamiliaServicio {

    private FamiliaDAO familiaDAO;

    // Constructor que inicializa el DAO
    public FamiliaServicio() {
        this.familiaDAO = new FamiliaDAO();
    }

    // Método para registrar una familia
    public void registrarFamilia(Familia familia) throws Exception {
        try {
            // Validaciones antes de insertar
            if (familia.getNombre() == null || familia.getNombre().trim().isEmpty()) {
                throw new Exception("El nombre de la familia no puede estar vacío.");
            }
            if (familia.getEdadMinima() < 0 || familia.getEdadMaxima() < familia.getEdadMinima()) {
                throw new Exception("Rango de edades inválido.");
            }
            if (familia.getNumHijos() < 0) {
                throw new Exception("El número de hijos no puede ser negativo.");
            }
            if (familia.getEmail() == null || familia.getEmail().trim().isEmpty()) {
                throw new Exception("El email no puede estar vacío.");
            }

            familiaDAO.insertarFamilia(familia);
            System.out.println("Familia registrada con éxito.");
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para actualizar una familia
    public void actualizarFamilia(Familia familia) throws Exception {
        try {
            // Validaciones antes de actualizar
            if (familia.getIdFamilia() <= 0) {
                throw new Exception("ID de familia inválido.");
            }
            if (familia.getNombre() == null || familia.getNombre().trim().isEmpty()) {
                throw new Exception("El nombre de la familia no puede estar vacío.");
            }
            if (familia.getEdadMinima() < 0 || familia.getEdadMaxima() < familia.getEdadMinima()) {
                throw new Exception("Rango de edades inválido.");
            }
            if (familia.getNumHijos() < 0) {
                throw new Exception("El número de hijos no puede ser negativo.");
            }
            if (familia.getEmail() == null || familia.getEmail().trim().isEmpty()) {
                throw new Exception("El email no puede estar vacío.");
            }

            familiaDAO.actualizarFamilia(familia);
            System.out.println("Familia actualizada con éxito.");
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para eliminar una familia
    public void eliminarFamilia(int idFamilia) throws Exception {
        try {
            if (idFamilia <= 0) {
                throw new Exception("ID de familia inválido.");
            }

            familiaDAO.eliminarFamilia(idFamilia);
            System.out.println("Familia eliminada con éxito.");
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para obtener una familia por su ID
    public Familia obtenerFamiliaPorId(int idFamilia) throws Exception {
        try {
            if (idFamilia <= 0) {
                throw new Exception("ID de familia inválido.");
            }

            return familiaDAO.obtenerFamiliaPorId(idFamilia);
        } catch (Exception e) {
            throw e;
        }
    }

    // Método para listar todas las familias
    public List<Familia> listarFamilias() throws Exception {
        try {
            return familiaDAO.listarFamilias();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Familia> listarFamiliasConHijosYEdad(int numHijos, int edadMaxima) {
        try {
            return familiaDAO.listarFamiliasConHijosYEdad(numHijos, edadMaxima);
        } catch (Exception e) {
            System.out.println("Error en la consulta: " + e.getMessage());
            return new ArrayList<>(); // Devuelve una lista vacía en caso de error
        }
    }
}
