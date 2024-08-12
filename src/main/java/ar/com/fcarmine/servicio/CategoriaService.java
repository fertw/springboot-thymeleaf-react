package ar.com.fcarmine.servicio;

import java.util.List;
import ar.com.fcarmine.dto.CategoriaDTO;
import ar.com.fcarmine.model.Categoria;

public interface CategoriaService {
    List<CategoriaDTO> findAll();
    CategoriaDTO findById(Long id);
    CategoriaDTO save(Categoria categoria);
    CategoriaDTO update(Categoria categoria);
    void deleteById(Long id);
}
