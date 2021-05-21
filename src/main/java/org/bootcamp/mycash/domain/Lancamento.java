package org.bootcamp.mycash.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "lancamento")
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "ds_lancamento", length = 50)
    @NotBlank(message = "Campo Descrição é obrigatório") //NotBlank para do tipo string
    @Size(max = 50)
    private String descricao;

    @Column(name = "vl_lancamento", precision = 8, scale = 2)
    @Min(value = 0, message = "O Valor deve ser maior ou igual a zero")
    //@PositiveOrZero()
    private Double valor;

    @Column(name = "data_lancamento")
    //@FutureOrPresent
    @NotNull(message = "Campo Data é obrigatório")
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Campo Tipo é obrigatório")
    private LancamentoTipo tipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LancamentoTipo getTipo() {
        return tipo;
    }

    public void setTipo(LancamentoTipo tipo) {
        this.tipo = tipo;
    }

}
