package com.egg.servicios;

import java.util.List;

import com.egg.entidades.Empleado;
import com.egg.persistencia.EmpleadoDAO;

public class EmpleadoServicio {

     private final EmpleadoDAO empleadoDAO;

    public EmpleadoServicio() {
        this.empleadoDAO = new EmpleadoDAO();
    }

    public void guardarEmpleado(Empleado empleado) {
        try {
            empleadoDAO.guardarEmpleado(empleado);
            System.out.println("Empleado guardado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al guardar el empleado: " + e.getMessage());
        }
    }

    public Empleado buscarEmpleado(int idEmpleado) throws Exception {
        Empleado empleado = empleadoDAO.buscarEmpleado(idEmpleado);
        if (empleado == null) {
            throw new Exception("Empleado no encontrado con ID: " + idEmpleado);
        }
        return empleado;
    }

    public void eliminarEmpleado(int idEmpleado) {
        try {
            empleadoDAO.remove(idEmpleado);
            System.out.println("Empleado eliminado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar el empleado: " + e.getMessage());
        }
    }
    

    // Método para listar empleados por ID de oficina
    public void listarEmpleadosPorIdOficina(int idOficina) throws Exception {
        List<Empleado> empleadosPorOficina = empleadoDAO.listarEmpleadosPorIdOficina(idOficina);
        imprimirListaEmpleados(empleadosPorOficina);
    }

    // Método para imprimir la lista de empleados
    public void imprimirListaEmpleados(List<Empleado> listaRecibida) {
        if (listaRecibida == null || listaRecibida.isEmpty()) {
            System.out.println("No se encontraron empleados para la oficina.");
            return;
        }
        for (Empleado empleado : listaRecibida) {
            System.out.println(empleado.getIdEmpleado() + " - " 
                               + empleado.getNombre() + " " 
                               + empleado.getApellido() + " - "
                               + empleado.getEmail() + " - "
                               + empleado.getPuesto());
        }
    }
}   
