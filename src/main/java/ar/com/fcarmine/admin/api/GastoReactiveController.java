package ar.com.fcarmine.admin.api;

import org.springframework.web.bind.annotation.RestController;

import ar.com.fcarmine.model.Gasto;
import ar.com.fcarmine.servicio.GastoService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/gastos")
public class GastoReactiveController {
    @Autowired
    private GastoService gastoService;

    @GetMapping
    public Flux<Gasto> listarGastos() {
        return Flux.fromIterable(gastoService.findAll());
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Gasto>> obtenerGasto(@PathVariable Long id) {
        return Mono.justOrEmpty(gastoService.findById(id))
                   .map(gasto -> ResponseEntity.ok(gasto))
                   .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<Gasto> crearGasto(@RequestBody Gasto gasto) {
        return Mono.just(gastoService.save(gasto));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Gasto>> actualizarGasto(@PathVariable Long id, @RequestBody Gasto gasto) {
        return Mono.justOrEmpty(gastoService.findById(id))
                   .flatMap(existingGasto -> {
                       gasto.setId(id);
                       return Mono.just(gastoService.update(gasto));
                   })
                   .map(updatedGasto -> ResponseEntity.ok(updatedGasto))
                   .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminarGasto(@PathVariable Long id) {
        return Mono.justOrEmpty(gastoService.findById(id))
                   .flatMap(gasto -> {
                       gastoService.deleteById(id);
                       return Mono.empty();
                   });
    }
}
