package br.com.buscasaude.model.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Profissional extends Pessoa {

    @OneToOne
    Especialidade especialidade;

    @OneToOne
    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
}
