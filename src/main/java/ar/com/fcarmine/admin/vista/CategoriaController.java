package ar.com.fcarmine.admin.vista;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.com.fcarmine.model.Categoria;
import ar.com.fcarmine.servicio.CategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public String listarCategorias(Model model) {
		List<Categoria> categorias = categoriaService.findAll();
		model.addAttribute("categorias", categorias);
		return "categorias/lista";
	}

	@GetMapping("/nueva")
	public String mostrarFormularioDeCrearCategoria(Model model) {
		model.addAttribute("categoria", new Categoria());
		return "categorias/formulario";
	}

	@PostMapping
	public String crearCategoria(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
		if (result.hasErrors()) {
			return "categorias/formulario";
		}
		categoriaService.save(categoria);
		return "redirect:/categorias";
	}

	@GetMapping("/{id}/editar")
	public String mostrarFormularioDeEditarCategoria(@PathVariable("id") Long id, Model model) {
		Optional<Categoria> categoria = categoriaService.findById(id);
		if (categoria.isEmpty()) {
			throw new IllegalArgumentException("Categoría no encontrada: " + id);
		}
		model.addAttribute("categoria", categoria);
		return "categorias/formulario";
	}

	@PostMapping("/{id}/actualizar")
	public String actualizarCategoria(@PathVariable("id") Long id, @Valid @ModelAttribute Categoria categoria,
			BindingResult result) {
		if (result.hasErrors()) {
			return "categorias/formulario";
		}
		categoria.setId(id);
		categoriaService.save(categoria);
		return "redirect:/categorias";
	}

	@PostMapping("/{id}/eliminar")
	public String eliminarCategoria(@PathVariable("id") Long id) {
		Optional<Categoria> categoria = categoriaService.findById(id);
		if (categoria.isEmpty()) {
			throw new IllegalArgumentException("Categoría no encontrada: " + id);
		}
		categoriaService.deleteById(categoria.get().getId());
		return "redirect:/categorias";
	}
}
