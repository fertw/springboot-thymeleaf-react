package ar.com.fcarmine.servicio.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.fcarmine.dto.UsuarioDTO;
import ar.com.fcarmine.model.Usuario;
import ar.com.fcarmine.repository.UsuarioRepository;
import ar.com.fcarmine.servicio.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<UsuarioDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDTO findById(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.map(this::converToDto).orElse(null);
		
	}

	@Override
	public UsuarioDTO save(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDTO update(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

	private UsuarioDTO converToDto(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setId(usuario.getId());
		usuarioDTO.setUsername(usuario.getUsername());
		usuarioDTO.setApellido(usuario.getApellido());
		usuarioDTO.setPassword(usuario.getPassword());
		return usuarioDTO;

	}

}
