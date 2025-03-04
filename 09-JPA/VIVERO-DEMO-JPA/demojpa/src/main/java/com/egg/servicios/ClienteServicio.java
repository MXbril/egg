package com.egg.servicios;

import java.util.List;
import com.egg.entidades.Cliente;
import com.egg.persistencia.ClienteDAO;

public class ClienteServicio {
    
    private final ClienteDAO clienteDAO;
    public ClienteServicio() {
        this.clienteDAO = new ClienteDAO();
    }

    public void guardarCliente(String apellidoContacto, String ciudad, int codigoCliente, String codigoPostal, String fax, int idEmpleado, double limiteCredito, String nombreCliente, String nombreContacto, String pais, String region, String telefono) {
        try {
            Cliente nuevoCliente = new Cliente();
            nuevoCliente.setApellidoContacto(apellidoContacto);
            nuevoCliente.setCiudad(ciudad);
            nuevoCliente.setCodigoCliente(codigoCliente);
            nuevoCliente.setCodigoPostal(codigoPostal);
            nuevoCliente.setFax(fax);
            nuevoCliente.setIdEmpleado(idEmpleado);
            nuevoCliente.setLimiteCredito(limiteCredito);
            nuevoCliente.setNombreCliente(nombreCliente);
            nuevoCliente.setNombreContacto(nombreContacto);
            nuevoCliente.setPais(pais);
            nuevoCliente.setRegion(region);
            nuevoCliente.setTelefono(telefono);
            // Usar el DAO para guardar el cliente
            clienteDAO.guardarCliente(nuevoCliente);
            System.out.println("Cliente guardado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al guardar el cliente: " + e.getMessage());
        }
    }

    public Cliente buscarCliente(int idCliente) throws Exception {
        Cliente cliente = clienteDAO.buscarCliente(idCliente);
        if (cliente == null) {
            throw new Exception("Cliente no encontrado con ID: " + idCliente);
        }
        return cliente;
    }

    public void listarClientes(String nombreRecibido) throws Exception {
        List<Cliente> clientesNombre = clienteDAO.listarClientesPorNombre(nombreRecibido); // Llama al DAO
        imprimirLista(clientesNombre); // Imprime los resultados
    }

    public void listarClientesPorCiudad(String ciudadRecibida) throws Exception {
        List<Cliente> clientesCiudad = clienteDAO.listarClientesPorCiudad(ciudadRecibida); // Llama al DAO
        imprimirLista(clientesCiudad); // Imprime los resultados
    }

    // Método para imprimir los datos de la lista de clientes
    public void imprimirLista(List<Cliente> listaRecibida) {
        if (listaRecibida.isEmpty()) {
            System.out.println("No se encontraron clientes.");
            return;
        }
        
        System.out.println("ID Cliente - Apellido - Nombre - Ciudad");
        for (Cliente unitarioCliente : listaRecibida) {
            System.out.println(unitarioCliente.getIdCliente() + " - " 
                               + unitarioCliente.getApellidoContacto() + " - "
                               + unitarioCliente.getNombreContacto() + " - "
                               + unitarioCliente.getCiudad());
        }
    }
    
}
