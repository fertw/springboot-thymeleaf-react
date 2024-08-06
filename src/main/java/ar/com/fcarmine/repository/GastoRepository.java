package ar.com.fcarmine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.fcarmine.model.Gasto;

public interface GastoRepository extends JpaRepository<Gasto, Long> {
}
