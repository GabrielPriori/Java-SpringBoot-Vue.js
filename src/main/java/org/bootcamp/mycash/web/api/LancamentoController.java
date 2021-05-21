package org.bootcamp.mycash.web.api;

import org.bootcamp.mycash.domain.Lancamento;
import org.bootcamp.mycash.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/lancamento")
public class LancamentoController{

    @Autowired
    private LancamentoService service;

    @GetMapping
    public List<Lancamento> todos() {
        return service.todos();
    }

    @GetMapping("/{id}")
    public Lancamento apenasUm(@PathVariable("id") Integer id){
        return service.apenasUm(id);
    }

    @PostMapping
    public Lancamento criar(@Valid @RequestBody Lancamento lancamento){
        return service.criar(lancamento);
    }

    @PutMapping("/{id}")
    public Lancamento atualizar(@PathVariable Integer id, @RequestBody Lancamento novoLancamento){
        return service.atualizar(id, novoLancamento);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id){
        service.excluir(id);
    }

}
