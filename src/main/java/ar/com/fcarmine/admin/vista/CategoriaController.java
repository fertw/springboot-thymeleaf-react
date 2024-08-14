package ar.com.fcarmine.admin.vista;

import ar.com.fcarmine.model.Categoria;
import ar.com.fcarmine.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public String listarCategorias(Model model) {
        List<Categoria> categorias = categoriaRepository.findAll();
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
        categoriaRepository.save(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/{id}/editar")
    public String mostrarFormularioDeEditarCategoria(@PathVariable("id") Long id, Model model) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada: " + id));
        model.addAttribute("categoria", categoria);
        return "categorias/formulario";
    }

    @PostMapping("/{id}/actualizar")
    public String actualizarCategoria(@PathVariable("id") Long id, @Valid @ModelAttribute Categoria categoria, BindingResult result) {
        if (result.hasErrors()) {
            return "categorias/formulario";
        }
        categoria.setId(id);
        categoriaRepository.save(categoria);
        return "redirect:/categorias";
    }

    @PostMapping("/{id}/eliminar")
    public String eliminarCategoria(@PathVariable("id") Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada: " + id));
        categoriaRepository.delete(categoria);
        return "redirect:/categorias";
    }
}

