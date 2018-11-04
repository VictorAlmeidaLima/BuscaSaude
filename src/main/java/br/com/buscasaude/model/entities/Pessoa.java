package br.com.buscasaude.model.entities;

import br.com.buscasaude.model.types.TipoPessoa;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "Pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal idPessoa;

    @NotNull
    @Column
    @Size(max = 255,min = 3)
    private String nome;

    @NotNull
    @Range(min = 0)
    private int idade;

    private String telefone;

    private String celular;

    @CPF
    private String cpf_cnpj;

    @NotNull
    private TipoPessoa tipoPessoa;

    @OneToOne
    private Endereco endereco;

    @OneToOne
    private Usuario usuario;

    //--------------------GETTERS AND SETTERS---------------------

    @Id
    public BigDecimal getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(BigDecimal id) {
        this.idPessoa = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @OneToOne
    public Endereco getEndereco() {
        return endereco;
    }


    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @OneToOne
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
