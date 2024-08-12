package ar.com.fcarmine.servicio.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.fcarmine.dto.GastoDTO;
import ar.com.fcarmine.model.Gasto;
import ar.com.fcarmine.repository.GastoRepository;
import ar.com.fcarmine.servicio.GastoService;

@Service
public class GastoServiceImpl implements GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    @Override
    public List<GastoDTO> findAll() {
        return gastoRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public GastoDTO findById(Long id) {
        Optional<Gasto> gasto = gastoRepository.findById(id);
        return gasto.map(this::convertToDto).orElse(null);
    }

    @Override
    public GastoDTO save(Gasto gasto) {
        Gasto savedGasto = gastoRepository.save(gasto);
        return convertToDto(savedGasto);
    }

    @Override
    public GastoDTO update(Gasto gasto) {
        Gasto updatedGasto = gastoRepository.save(gasto);
        return convertToDto(updatedGasto);
    }

    @Override
    public void deleteById(Long id) {
        gastoRepository.deleteById(id);
    }

    private GastoDTO convertToDto(Gasto gasto) {
        GastoDTO gastoDTO = new GastoDTO();
        gastoDTO.setId(gasto.getId());
        gastoDTO.setConcepto(gasto.getConcepto());
        gastoDTO.setMonto(gasto.getMonto());
        gastoDTO.setFecha(gasto.getFecha());
        gastoDTO.setUsuarioId(gasto.getUsuario().getId());
        gastoDTO.setMetodoPagoId(gasto.getMetodo().getId());
        gastoDTO.setCategoriaId(gasto.getCategoria().getId());
        return gastoDTO;
    }
}
