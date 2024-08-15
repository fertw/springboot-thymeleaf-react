package ar.com.fcarmine.admin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.fcarmine.model.Usuario;
import ar.com.fcarmine.servicio.UsuarioService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioReactiveController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public Flux<Usuario> listarUsuarios() {
		return Flux.fromIterable(usuarioService.findAll());
	}

	@GetMapping("/{id}")
	public Mono<ResponseEntity<Usuario>> obtenerUsuario(@PathVariable("id") Long id) {
		return Mono.justOrEmpty(usuarioService.findById(id)).map(usuario -> ResponseEntity.ok(usuario))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@PutMapping
	public Mono<Usuario> crearUsuario(Usuario usuario) {
		return Mono.just(usuarioService.save(usuario));
	}

	@PutMapping("/{id}")
	public Mono<ResponseEntity<Usuario>> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
		return Mono.justOrEmpty(usuarioService.findById(id)).flatMap(existingUsuario -> {
			usuario.setId(id);
			return Mono.just(usuarioService.update(usuario));
		}).map(updatedUsuario -> ResponseEntity.ok(updatedUsuario)).defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	 @DeleteMapping("/{id}")
	    public Mono<Void> eliminarUsuario(@PathVariable Long id) {
	        return Mono.justOrEmpty(usuarioService.findById(id))
	                   .flatMap(usuario -> {
	                       usuarioService.deleteById(id);
	                       return Mono.empty();
	                   });
	    }

}
