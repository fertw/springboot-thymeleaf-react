package ar.com.fcarmine.servicio;

import java.util.List;
import java.util.Optional;

import ar.com.fcarmine.model.Categoria;

public interface CategoriaService {
    List<Categoria> findAll();
    Optional<Categoria> findById(Long id);
    Categoria save(Categoria categoria);
    Categoria update(Categoria categoria);
    void deleteById(Long id);
}
