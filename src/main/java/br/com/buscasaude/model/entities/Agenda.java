package br.com.buscasaude.model.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

@Entity
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    BigDecimal idAgenda;

    @Column
    @Temporal(TemporalType.DATE)
    Date dtAgendamento;

    @Column
    @Size(min = 1,max= 12)
    int Mes;

    @Column
    @Temporal(TemporalType.TIME)
    Time hrInicial;

    @Column
    @Temporal(TemporalType.TIME)
    Time hrFinal;

    @OneToOne
    Atendimento atendimento;
/*
    @OneToOne
    @JoinTable(name = "Pessoa")
    @MapKeyJoinColumn(name = "idPessoa")
    private Pessoa profissional;*/

    @Id
    public BigDecimal getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(BigDecimal idAgenda) {
        this.idAgenda = idAgenda;
    }

    public Date getDtAgendamento() {
        return dtAgendamento;
    }

    public void setDtAgendamento(Date dtAgendamento) {
        this.dtAgendamento = dtAgendamento;
    }

    public int getMes() {
        return Mes;
    }

    public void setMes(int mes) {
        Mes = mes;
    }

    public Time getHrInicial() {
        return hrInicial;
    }

    public void setHrInicial(Time hrInicial) {
        this.hrInicial = hrInicial;
    }

    public Time getHrFinal() {
        return hrFinal;
    }

    public void setHrFinal(Time hrFinal) {
        this.hrFinal = hrFinal;
    }

    @OneToOne
    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }
    /*
    @OneToOne
    public Pessoa getProfissional() {
        return profissional;
    }

    public void setProfissional(Pessoa profissional) {
        this.profissional = profissional;
    }*/

}
