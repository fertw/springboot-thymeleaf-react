package ar.com.fcarmine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.fcarmine.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
