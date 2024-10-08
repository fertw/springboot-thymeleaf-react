package ar.com.fcarmine.admin.vista;

import ar.com.fcarmine.model.Usuario;
import ar.com.fcarmine.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.findAll(); // Cambiado a Usuario
        model.addAttribute("usuarios", usuarios);
        return "usuarios/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeCrearUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/formulario";
    }

    @PostMapping
    public String crearUsuario(@Valid @ModelAttribute Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "usuarios/formulario";
        }
        usuarioService.save(usuario);
        return "redirect:/usuarios";
    }

    @PostMapping("/{id}/actualizar")
    public String actualizarUsuario(@PathVariable("id") Long id, @Valid @ModelAttribute Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "usuarios/formulario";
        }
        usuario.setId(id);
        usuarioService.update(usuario);
        return "redirect:/usuarios";
    }
    
    @GetMapping("/{id}/editar")
    public String mostrarFormularioDeEditarUsuario(@PathVariable("id") Long id, Model model) {
        Usuario usuario = usuarioService.findById(id); // Cambiado a Usuario
        if (usuario == null) {
            return "redirect:/usuarios";
        }
        model.addAttribute("usuario", usuario);
        return "usuarios/formulario";
    }


    @PostMapping("/{id}/eliminar")
    public String eliminarUsuario(@PathVariable("id") Long id) {
        usuarioService.deleteById(id);
        return "redirect:/usuarios";
    }

}
