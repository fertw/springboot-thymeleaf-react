package ar.com.fcarmine.servicio;

import java.util.List;

import ar.com.fcarmine.model.Gasto;

public interface GastoService {
    List<Gasto> findAll();
    Gasto findById(Long id);
    Gasto save(Gasto gasto);
    Gasto update(Gasto gasto);
    void deleteById(Long id);
}
