package com.egg.servicios;

import com.egg.entidades.GamaProducto;
import com.egg.persistencia.GamaProductoDAO;

public class GamaProductoServicio {

    private final GamaProductoDAO gamaProductoDAO;
    public GamaProductoServicio() {
        this.gamaProductoDAO = new GamaProductoDAO();
    }

    public void guardarGamaProducto(String descripcionHtml, String descripcionTexto, String gama, String imagen) {
        try {
            GamaProducto nuevoGamaProducto = new GamaProducto();
            nuevoGamaProducto.setDescripcionHtml(descripcionHtml);
            nuevoGamaProducto.setDescripcionTexto(descripcionTexto);
            nuevoGamaProducto.setGama(gama);
            nuevoGamaProducto.setImagen(imagen);

            gamaProductoDAO.guardarGamaProducto(nuevoGamaProducto);
            System.out.println("Gama de producto guardada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al guardar la gama de productos: " + e.getMessage());
        }
    }

    public GamaProducto buscarGamaProducto(int idGama) throws Exception {
        GamaProducto gamaProducto = gamaProductoDAO.buscarGamaProducto(idGama);
        if (gamaProducto == null) {
            throw new Exception("Gama de producto no encontrada con ID: " + idGama);
        }
        return gamaProducto;
    }

    public void actualizarGamaProducto(int idGama, String descripcionHtml, String descripcionTexto, String gama, String imagen) {
        try {
            GamaProducto gamaProducto = buscarGamaProducto(idGama); // Verificamos que la gama existe
            gamaProducto.setDescripcionHtml(descripcionHtml);
            gamaProducto.setDescripcionTexto(descripcionTexto);
            gamaProducto.setGama(gama);
            gamaProducto.setImagen(imagen);

            gamaProductoDAO.actualizarGamaProducto(gamaProducto);
            System.out.println("Gama de producto actualizada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al actualizar la gama de productos: " + e.getMessage());
        }
    }

}
