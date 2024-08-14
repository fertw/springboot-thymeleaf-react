package ar.com.fcarmine.servicio.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.fcarmine.model.Gasto;
import ar.com.fcarmine.repository.GastoRepository;
import ar.com.fcarmine.servicio.GastoService;

@Service
public class GastoServiceImpl implements GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    @Override
    public List<Gasto> findAll() {
        return gastoRepository.findAll();
        
    }

    @Override
    public Gasto findById(Long id) {
        Optional<Gasto> gasto = gastoRepository.findById(id);
        return gasto.get();
    }

    @Override
    public Gasto save(Gasto gasto) {
        Gasto savedGasto = gastoRepository.save(gasto);
        return savedGasto;
    }

    @Override
    public Gasto update(Gasto gasto) {
        Gasto updatedGasto = gastoRepository.save(gasto);
        return updatedGasto;
    }

    @Override
    public void deleteById(Long id) {
        gastoRepository.deleteById(id);
    }

}
