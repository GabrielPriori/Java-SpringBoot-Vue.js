package org.bootcamp.mycash.web.api;


import java.util.List;

import org.bootcamp.mycash.domain.Usuario;
import org.bootcamp.mycash.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    List<Usuario> todos() {
        return service.todos();
    }



}
