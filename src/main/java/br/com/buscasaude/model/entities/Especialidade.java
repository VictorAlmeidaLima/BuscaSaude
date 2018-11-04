package br.com.buscasaude.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal idEspecialidade;

    @NotNull
    private String descricao;

    @Id
    public BigDecimal getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(BigDecimal idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
