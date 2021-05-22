package org.bootcamp.mycash.service;

import org.bootcamp.mycash.domain.Usuario;
import org.bootcamp.mycash.domain.UsuarioRole;
import org.bootcamp.mycash.exception.UsuarioExcepiton;
import org.bootcamp.mycash.repository.UsuarioRepository;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public List<Usuario> todos() {
        return repo.findAll();
    }

    public void registraUsuarioAdmin(String email, String senha){
        if(repo.findByEmail(email).isPresent()) {
            new EntityNotFoundException();
        } else {
            Usuario usuario = new Usuario();
            usuario.setEmail(email);
            usuario.setSenha(senha);
            usuario.setRole(UsuarioRole.ROLE_ADMIN);

            repo.save(usuario);
        }
    }

    public Usuario save(String email, String senha) {
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setRole(UsuarioRole.ROLE_ADMIN);

        if (repo.findByEmail(email).isPresent())
            throw new UsuarioExcepiton("Já existe usuário com este e-mail");

        return repo.save(usuario);
    }

    public Usuario findByEmail(String email) {
        return repo.findByEmail(email).orElseThrow(() -> new EntityNotFoundException());
    }

    public Usuario resetarSenha(String email, String senhaNova) {
        Usuario usuario = findByEmail(email);
        usuario.setSenha(senhaNova);

        return repo.save(usuario);
    }
}
