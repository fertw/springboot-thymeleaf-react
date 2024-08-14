package ar.com.fcarmine.servicio.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.fcarmine.model.Categoria;
import ar.com.fcarmine.repository.CategoriaRepository;
import ar.com.fcarmine.servicio.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria;
    }

    @Override
    public Categoria save(Categoria categoria) {
        Categoria savedCategoria = categoriaRepository.save(categoria);
        return savedCategoria;
    }

    @Override
    public Categoria update(Categoria categoria) {
        Categoria updatedCategoria = categoriaRepository.save(categoria);
        return updatedCategoria;
    }

    @Override
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }

    private Categoria convertToDto(Categoria categoria) {
        Categoria Categoria = new Categoria();
        Categoria.setId(categoria.getId());
        Categoria.setNombre(categoria.getNombre());
        return Categoria;
    }
}
