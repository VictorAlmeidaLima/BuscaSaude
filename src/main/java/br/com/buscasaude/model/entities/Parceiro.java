package br.com.buscasaude.model.entities;

import br.com.buscasaude.model.types.TipoParceiro;
import br.com.buscasaude.model.types.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity(name = "Parceiro")
public class Parceiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codParc;

    @Column
    @NotNull
    @Size(min = 2, max = 255)
    private String nomeParc;

    @CPF
    private String cpf_cnpj;

    @NotNull
    @Min(1)
    private int idade;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dtNascimento;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoParceiro tipoParceiro;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;

    @Column
    private String telefone;

    @Column
    private String email;

    @OneToOne
    @JoinColumn(columnDefinition="idEndereco")
    private Endereco endereco;

    @OneToOne
    @JoinColumn(columnDefinition = "idUsuario")
    private Usuario usuario;


//--------------------GETTERS AND SETTERS---------------------

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public long getCodParc() {
        return codParc;
    }

    public void setCodParc(long codParc) {
        this.codParc = codParc;
    }

    public String getNomeParc() {
        return nomeParc;
    }

    public void setNomeParc(String nomeParc) {
        this.nomeParc = nomeParc;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoParceiro getTipoParceiro() {
        return tipoParceiro;
    }

    public void setTipoParceiro(TipoParceiro tipoParceiro) {
        this.tipoParceiro = tipoParceiro;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }


}
