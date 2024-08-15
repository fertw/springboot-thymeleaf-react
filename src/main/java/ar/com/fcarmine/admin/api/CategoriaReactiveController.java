package ar.com.fcarmine.admin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.fcarmine.model.Categoria;
import ar.com.fcarmine.servicio.CategoriaService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaReactiveController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public Flux<Categoria> listarCategorias() {
		return Flux.fromIterable(categoriaService.findAll());
	}

	@GetMapping("/{id}")
	public Mono<ResponseEntity<Categoria>> obtenerCategoria(@PathVariable Long id) {
		return Mono.justOrEmpty(categoriaService.findById(id)).map(categoria -> ResponseEntity.ok(categoria))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Mono<Categoria> crearCategoria(@RequestBody Categoria categoria) {
		return Mono.just(categoriaService.save(categoria));
	}

	@PutMapping("/{id}")
	public Mono<ResponseEntity<Categoria>> actualizarCategoria(@PathVariable Long id,
			@RequestBody Categoria categoria) {
		return Mono.justOrEmpty(categoriaService.findById(id)).flatMap(existingCategoria -> {
			categoria.setId(id);
			return Mono.just(categoriaService.update(categoria));
		}).map(updatedCategoria -> ResponseEntity.ok(updatedCategoria))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public Mono<Void> eliminarCategoria(@PathVariable Long id) {
		return Mono.justOrEmpty(categoriaService.findById(id)).flatMap(categoria -> {
			categoriaService.deleteById(id);
			return Mono.empty();
		});
	}

}
