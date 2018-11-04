package br.com.buscasaude.model.types;

public enum TipoPessoa {

    PESSOA("P","Pessoa"),
    PROFISSIONAL("M","Profissional");

    private String silga;
    private String descricao;

    TipoPessoa(String m, String profissional) {

    }

    public String getSilga() {
        return silga;
    }

    public String getDescricao() {
        return descricao;
    }
}

