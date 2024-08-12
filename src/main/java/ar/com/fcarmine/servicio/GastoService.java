package ar.com.fcarmine.servicio;

import java.util.List;
import ar.com.fcarmine.dto.GastoDTO;
import ar.com.fcarmine.model.Gasto;

public interface GastoService {
    List<GastoDTO> findAll();
    GastoDTO findById(Long id);
    GastoDTO save(Gasto gasto);
    GastoDTO update(Gasto gasto);
    void deleteById(Long id);
}
