package br.com.buscasaude.model.types;

public enum TipoParceiro{

    CLIENTE("C","Cliente"),
    FORNECEDOR("F","Fornecedor"),
    FUNCIONARIO("E","Funcionário");

    private String sigla;
    private String descricao;

    TipoParceiro(String sigla, String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public String getSigla() { return sigla; }

    public String getDescricao() { return descricao; }
}
