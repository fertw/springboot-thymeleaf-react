package ar.com.fcarmine.servicio;

import java.util.List;

import ar.com.fcarmine.model.MetodoPago;

public interface MetodoPagoService {
    List<MetodoPago> findAll();
    MetodoPago findById(Long id);
    MetodoPago save(MetodoPago metodoPago);
    MetodoPago update(MetodoPago metodoPago);
    void deleteById(Long id);
}
