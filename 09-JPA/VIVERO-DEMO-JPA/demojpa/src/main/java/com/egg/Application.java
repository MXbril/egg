package com.egg;

public class Application {

    public static void main(String[] args) {

        // try {
        //     String nombreCliente = "Tendo Garden";
        //     Date fechaInicio = new SimpleDateFormat("yyyy-MM-dd").parse("2008-01-01");
        //     Date fechaFin = new SimpleDateFormat("yyyy-MM-dd").parse("2009-12-31");

        //     PedidoServicio pedidoServicio = new PedidoServicio();
        //     pedidoServicio.listarPedidosPorClienteYFechas(nombreCliente, fechaInicio, fechaFin);
        // } catch (ParseException e) {
        //     e.printStackTrace(); // Muestra el error en la consola
        // }
        // Instanciar la clase OficinaServicio para acceder a sus métodos
    //    OficinaServicio oficinaServicio = new OficinaServicio();
    //     // Llamar al método del servicio para crear una nueva oficina
    //    oficinaServicio.crearOficina("OFI01", "Mendoza", "Argentina", "Cuyo", "11111111", "CP5000");
    //     // Opción para cerrar el EntityManager al final
    //    oficinaServicio.cerrar();
    // Instanciar las clases de servicio
        // ClienteServicio clienteServicio = new ClienteServicio();
        // GamaProductoServicio gamaProductoServicio = new GamaProductoServicio();
        // EmpleadoServicio empleadoServicio = new EmpleadoServicio();
        // int idEmpleadoAEliminar = 21;
        // empleadoServicio.eliminarEmpleado(idEmpleadoAEliminar);

        //buscar empleado por id
        // int idEmpleadoABuscar = 21;
        // try {
        //     Empleado empleadoEncontrado = empleadoServicio.buscarEmpleado(idEmpleadoABuscar);
        //     System.out.println("Empleado encontrado:");
        //     System.out.println("ID: " + empleadoEncontrado.getIdEmpleado());
        //     System.out.println("Nombre: " + empleadoEncontrado.getNombre());
        //     System.out.println("Apellido: " + empleadoEncontrado.getApellido());
        //     System.out.println("Email: " + empleadoEncontrado.getEmail());
        //     System.out.println("Puesto: " + empleadoEncontrado.getPuesto());
        // } catch (Exception e) {
        //     System.out.println("Error: " + e.getMessage());
        // }

         // Crear un nuevo empleado
        // Empleado nuevoEmpleado = new Empleado();
        // nuevoEmpleado.setNombre("Juan");
        // nuevoEmpleado.setApellido("Pérez");
        // nuevoEmpleado.setCodigoEmpleado(21);
        // nuevoEmpleado.setEmail("juan.perez@example.com");
        // nuevoEmpleado.setExtension("123");
        // nuevoEmpleado.setIdJefe(1); // Asignar ID de jefe si aplica
        // nuevoEmpleado.setPuesto("Desarrollador");
        // // Guardar el empleado
        // try {
        //     empleadoServicio.guardarEmpleado(nuevoEmpleado);
        // } catch (Exception e) {
        //     System.out.println("Error al guardar el empleado: " + e.getMessage());
        // }

        //Actualizar Gama
        // int idGama = 7; // Supongamos que estamos actualizando la gama con ID 7
        // String nuevaDescripcionHtml = null;
        // String nuevaDescripcionTexto = "Juguetes en linea";
        // String nuevaGama = "Jugueteria";
        // String nuevaImagen = null;
        // gamaProductoServicio.actualizarGamaProducto(idGama, nuevaDescripcionHtml, nuevaDescripcionTexto, nuevaGama, nuevaImagen);

        // Crear y guardar un nuevo cliente
        // clienteServicio.guardarCliente("Zapata", "Madrid", 20, "20235", "165464846", 8, 3000, "Promax", "Jorge", "USA", null, "5882225555");

        // // Crear y guardar una nueva gama de productos
        // gamaProductoServicio.guardarGamaProducto(null, "Aparatos tecnológicos", "Electrodomésticos", null);
        // try {
        //     // Buscar cliente por ID
        //     Cliente cliente = clienteServicio.buscarCliente(1);
        //     System.out.println("Cliente encontrado: " + cliente.getNombreCliente());

        //     // Buscar gama de productos por ID
        //     GamaProducto gamaProducto = gamaProductoServicio.buscarGamaProducto(1);
        //     System.out.println("Gama de producto encontrada: " + gamaProducto.getGama());

        // } catch (Exception e) {
        //     System.out.println("Error: " + e.getMessage());
        // }



        // Cerrar la fábrica de EntityManager
        JPAUtil.closeEntityManagerFactory();
    }
}
