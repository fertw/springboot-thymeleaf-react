package ar.com.fcarmine.servicio.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.fcarmine.dto.MetodoPagoDTO;
import ar.com.fcarmine.model.MetodoPago;
import ar.com.fcarmine.repository.MetodoPagoRepository;
import ar.com.fcarmine.servicio.MetodoPagoService;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService {

    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    @Override
    public List<MetodoPagoDTO> findAll() {
        return metodoPagoRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public MetodoPagoDTO findById(Long id) {
        Optional<MetodoPago> metodoPago = metodoPagoRepository.findById(id);
        return metodoPago.map(this::convertToDto).orElse(null);
    }

    @Override
    public MetodoPagoDTO save(MetodoPago metodoPago) {
        MetodoPago savedMetodoPago = metodoPagoRepository.save(metodoPago);
        return convertToDto(savedMetodoPago);
    }

    @Override
    public MetodoPagoDTO update(MetodoPago metodoPago) {
        MetodoPago updatedMetodoPago = metodoPagoRepository.save(metodoPago);
        return convertToDto(updatedMetodoPago);
    }

    @Override
    public void deleteById(Long id) {
        metodoPagoRepository.deleteById(id);
    }

    private MetodoPagoDTO convertToDto(MetodoPago metodoPago) {
        MetodoPagoDTO metodoPagoDTO = new MetodoPagoDTO();
        metodoPagoDTO.setId(metodoPago.getId());
        metodoPagoDTO.setNombre(metodoPago.getNombre());
        return metodoPagoDTO;
    }
}
