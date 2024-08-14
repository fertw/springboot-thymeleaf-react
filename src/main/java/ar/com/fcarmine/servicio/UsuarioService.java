package ar.com.fcarmine.servicio;

import java.util.List;

import ar.com.fcarmine.model.Usuario;

public interface UsuarioService {
	
	List<Usuario> findAll();
	
	Usuario findById(Long id);
	
	Usuario save(Usuario usuario);
	
	Usuario update(Usuario usuario);
	
	void deleteById(Long id);

}
