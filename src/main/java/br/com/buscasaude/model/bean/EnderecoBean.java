package br.com.buscasaude.model.bean;

import br.com.buscasaude.model.dao.EnderecoDao;
import br.com.buscasaude.model.entities.Endereco;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class EnderecoBean {
    
    private Endereco Endereco;
    private EnderecoDao EnderecoDao;
    private List<Endereco> Enderecos;

    @PostConstruct
    public void init(){

        Endereco = new Endereco();
        EnderecoDao = new EnderecoDao();

        try{
            Enderecos = (List<Endereco>) EnderecoDao.selectAll();
        }catch (Exception e){
            //do nothing
        }
    }

    public Endereco getEndereco() {
        return Endereco;
    }

    public void setEndereco(Endereco endereco) {
        Endereco = endereco;
    }

    public List<Endereco> getEnderecos() {
        return Enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        Enderecos = enderecos;
    }
}
