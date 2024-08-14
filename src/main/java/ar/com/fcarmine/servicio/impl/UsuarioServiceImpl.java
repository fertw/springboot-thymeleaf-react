package ar.com.fcarmine.servicio.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.fcarmine.model.Usuario;
import ar.com.fcarmine.repository.UsuarioRepository;
import ar.com.fcarmine.servicio.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> findAll() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios;
	}

	@Override
	public Usuario findById(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.map(this::converToDto).orElse(null);

	}

	@Override
	public Usuario save(Usuario usuario) {
		usuario = usuarioRepository.save(usuario);
		return usuario;
	}

	@Override
	public Usuario update(Usuario usuario) {
		usuario = usuarioRepository.save(usuario);
		return usuario;
	}

	@Override
	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);

	}

	private Usuario converToDto(Usuario usuario) {
		Usuario Usuario = new Usuario();
		Usuario.setId(usuario.getId());
		Usuario.setUsername(usuario.getUsername());
		Usuario.setApellido(usuario.getApellido());
		Usuario.setPassword(usuario.getPassword());
		return Usuario;

	}

}
