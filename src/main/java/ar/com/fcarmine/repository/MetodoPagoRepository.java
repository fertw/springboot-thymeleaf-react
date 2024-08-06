package ar.com.fcarmine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.fcarmine.model.MetodoPago;

public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Long> {
}
