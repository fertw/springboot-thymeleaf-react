package ar.com.fcarmine.servicio;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ar.com.fcarmine.model.Usuario;

@Component
public class UsuarioConverter implements Converter<String, Usuario> {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public Usuario convert(String id) {
        return usuarioService.findById(Long.valueOf(id));
    }
}
//     }