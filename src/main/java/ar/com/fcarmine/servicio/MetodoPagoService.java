package ar.com.fcarmine.servicio;

import java.util.List;
import ar.com.fcarmine.dto.MetodoPagoDTO;
import ar.com.fcarmine.model.MetodoPago;

public interface MetodoPagoService {
    List<MetodoPagoDTO> findAll();
    MetodoPagoDTO findById(Long id);
    MetodoPagoDTO save(MetodoPago metodoPago);
    MetodoPagoDTO update(MetodoPago metodoPago);
    void deleteById(Long id);
}
