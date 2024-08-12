package ar.com.fcarmine.admin.vista;

import ar.com.fcarmine.dto.GastoDTO;
import ar.com.fcarmine.model.Gasto;
import ar.com.fcarmine.servicio.GastoService;
import ar.com.fcarmine.servicio.UsuarioService;
import ar.com.fcarmine.servicio.MetodoPagoService;
import ar.com.fcarmine.servicio.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/gastos")
public class GastoController {

    @Autowired
    private GastoService gastoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MetodoPagoService metodoPagoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String listarGastos(Model model) {
        List<GastoDTO> gastos = gastoService.findAll();
        model.addAttribute("gastos", gastos);
        return "gastos/lista"; // Asegúrate de que este nombre coincide con la ubicación de la plantilla
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeCrearGasto(Model model) {
        model.addAttribute("gasto", new Gasto());
        model.addAttribute("usuarios", usuarioService.findAll());
        model.addAttribute("metodosPago", metodoPagoService.findAll());
        model.addAttribute("categorias", categoriaService.findAll());
        return "gastos/formulario";
    }

    @PostMapping
    public String crearGasto(@Valid @ModelAttribute Gasto gasto, BindingResult result) {
        if (result.hasErrors()) {
            return "gastos/formulario";
        }
        gastoService.save(gasto);
        return "redirect:/gastos";
    }

    @GetMapping("/{id}/editar")
    public String mostrarFormularioDeEditarGasto(@PathVariable Long id, Model model) {
        GastoDTO gasto = gastoService.findById(id);
        if (gasto == null) {
            return "redirect:/gastos";
        }
        model.addAttribute("gasto", gasto);
        model.addAttribute("usuarios", usuarioService.findAll());
        model.addAttribute("metodosPago", metodoPagoService.findAll());
        model.addAttribute("categorias", categoriaService.findAll());
        return "gastos/formulario";
    }

    @PostMapping("/{id}/actualizar")
    public String actualizarGasto(@PathVariable Long id, @Valid @ModelAttribute Gasto gasto, BindingResult result) {
        if (result.hasErrors()) {
            return "gastos/formulario";
        }
        gasto.setId(id);
        gastoService.update(gasto);
        return "redirect:/gastos";
    }

    @PostMapping("/{id}/eliminar")
    public String eliminarGasto(@PathVariable Long id) {
        gastoService.deleteById(id);
        return "redirect:/gastos";
    }
}
