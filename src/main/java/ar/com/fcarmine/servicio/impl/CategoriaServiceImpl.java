package ar.com.fcarmine.servicio.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.fcarmine.dto.CategoriaDTO;
import ar.com.fcarmine.model.Categoria;
import ar.com.fcarmine.repository.CategoriaRepository;
import ar.com.fcarmine.servicio.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaDTO> findAll() {
        return categoriaRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaDTO findById(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.map(this::convertToDto).orElse(null);
    }

    @Override
    public CategoriaDTO save(Categoria categoria) {
        Categoria savedCategoria = categoriaRepository.save(categoria);
        return convertToDto(savedCategoria);
    }

    @Override
    public CategoriaDTO update(Categoria categoria) {
        Categoria updatedCategoria = categoriaRepository.save(categoria);
        return convertToDto(updatedCategoria);
    }

    @Override
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }

    private CategoriaDTO convertToDto(Categoria categoria) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(categoria.getId());
        categoriaDTO.setNombre(categoria.getNombre());
        return categoriaDTO;
    }
}
