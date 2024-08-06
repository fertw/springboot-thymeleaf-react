package ar.com.fcarmine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.fcarmine.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}