package ar.com.fcarmine.admin.vista;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("appName", "Administrador de Gastos Personales");
        return "home";
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("appName", "Administrador de Gastos Personales");
        return "home";
    }
}
