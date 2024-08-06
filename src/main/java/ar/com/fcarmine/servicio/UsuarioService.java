package ar.com.fcarmine.servicio;

import java.util.List;

import ar.com.fcarmine.dto.UsuarioDTO;
import ar.com.fcarmine.model.Usuario;

public interface UsuarioService {
	
	List<UsuarioDTO> findAll();
	
	UsuarioDTO findById(Long id);
	
	UsuarioDTO save(Usuario usuario);
	
	UsuarioDTO update(Usuario usuario);
	
	void deleteById(Long id);

}
