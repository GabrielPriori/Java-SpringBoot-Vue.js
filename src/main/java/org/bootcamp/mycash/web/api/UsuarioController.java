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

    @PostMapping
    public Usuario criar(@RequestParam(required = true) String email, @RequestParam(required = true) String senha) {
        return service.save(email, senha);
    }

    @GetMapping("/{email}")
    public Usuario apenasUm(@PathVariable("email") String email) {
        return service.findByEmail(email);
    }

    @PutMapping("/{email}")
    public Usuario resetarSenha(@PathVariable("email") String email, @RequestParam(required = true) String senhaNova) {
        return service.resetarSenha(email, senhaNova);
    }

    //branch teste

}
