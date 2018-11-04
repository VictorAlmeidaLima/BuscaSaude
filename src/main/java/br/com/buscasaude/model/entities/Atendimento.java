package br.com.buscasaude.model.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal idAtendimento;

    /*
    @OneToOne
    @JoinTable(name = "Pessoa")
    @MapKeyJoinColumn(name = "idPessoa")
    private Profissional profissional;*/

    @ManyToOne
    private Pessoa Paciente;

    @ManyToOne
    private Pessoa profissional;

    @Column
    private boolean confirmado;

    @Column
    @Temporal(TemporalType.DATE)
    private Date dtMarcacaoAtendimento;

    @Id
    public BigDecimal getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(BigDecimal idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    @ManyToOne
    public Pessoa getPaciente() {
        return Paciente;
    }

    public void setPaciente(Pessoa paciente) {
        Paciente = paciente;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public Date getDtMarcacaoAtendimento() {
        return dtMarcacaoAtendimento;
    }

    public void setDtMarcacaoAtendimento(Date dtMarcacaoAtendimento) {
        this.dtMarcacaoAtendimento = dtMarcacaoAtendimento;
    }

    @ManyToOne
    public Pessoa getProfissional() {
        return profissional;
    }

    public void setProfissional(Pessoa profissional) {
        this.profissional = profissional;
    }
}
