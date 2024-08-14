package ar.com.fcarmine.admin.vista;

import java.util.List;

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

import ar.com.fcarmine.model.MetodoPago;
import ar.com.fcarmine.servicio.MetodoPagoService;

@Controller
@RequestMapping("/metodosPago")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoService metodoPagoService;

    @GetMapping
    public String listarMetodosPago(Model model) {
        List<MetodoPago> metodosPago = metodoPagoService.findAll();
        model.addAttribute("metodosPago", metodosPago);
        return "metodosPago/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeCrearMetodoPago(Model model) {
        model.addAttribute("metodoPago", new MetodoPago());
        return "metodosPago/formulario";
    }

    @PostMapping
    public String crearMetodoPago(@Valid @ModelAttribute MetodoPago metodoPago, BindingResult result) {
        if (result.hasErrors()) {
            return "metodosPago/formulario";
        }
        metodoPagoService.save(metodoPago);
        return "redirect:/metodosPago";
    }

    @GetMapping("/{id}/editar")
    public String mostrarFormularioDeEditarMetodoPago(@PathVariable Long id, Model model) {
        MetodoPago metodoPago = metodoPagoService.findById(id);
        if (metodoPago == null) {
            return "redirect:/metodosPago";
        }
        model.addAttribute("metodoPago", metodoPago);
        return "metodosPago/formulario";
    }

    @PostMapping("/{id}/actualizar")
    public String actualizarMetodoPago(@PathVariable Long id, @Valid @ModelAttribute MetodoPago metodoPago, BindingResult result) {
        if (result.hasErrors()) {
            return "metodosPago/formulario";
        }
        metodoPago.setId(id);
        metodoPagoService.update(metodoPago);
        return "redirect:/metodosPago";
    }

    @PostMapping("/{id}/eliminar")
    public String eliminarMetodoPago(@PathVariable Long id) {
        metodoPagoService.deleteById(id);
        return "redirect:/metodosPago";
    }
}
