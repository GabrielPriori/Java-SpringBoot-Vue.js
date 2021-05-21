package org.bootcamp.mycash.service;

import org.bootcamp.mycash.domain.Usuario;
import org.bootcamp.mycash.domain.UsuarioRole;
import org.bootcamp.mycash.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public List<Usuario> todos() {
        return repo.findAll();
    }

    public void registroUsuarioAdmin(String email, String senha){
        if (repo.findByEmail(email).isEmpty()) {
            Usuario usuario = new Usuario();
            usuario.setEmail(email);
            usuario.setSenha(senha);
            usuario.setRole(UsuarioRole.ROLE_ADMIN);

            repo.save(usuario);
        }


    }

}
