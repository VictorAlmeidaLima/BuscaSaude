package br.com.buscasaude.model.bean;

import br.com.buscasaude.model.dao.PessoaDao;
import br.com.buscasaude.model.entities.Pessoa;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean
@SessionScoped
public class PessoaBean {
    private Pessoa Pessoa;
    private PessoaDao PessoaDao;
    private List<Pessoa> Pessoas;

    @PostConstruct
    public void init(){

        Pessoa = new Pessoa();
        PessoaDao = new PessoaDao();

        try{
            Pessoas = (List<Pessoa>) PessoaDao.selectAll();
        }catch (Exception e){
            //do nothing
        }
    }

    public String inserir(){
        try {
            PessoaDao.insert(this.Pessoa);
            Pessoa = new Pessoa();

            Pessoas = PessoaDao.selectAll();

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado", " Pessoa Cadastrado com sucesso!"));
            context.getExternalContext().getFlash().setKeepMessages(true);

        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }

        return "sucesso";
    }

    public Pessoa getPessoa() {
        return Pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        Pessoa = pessoa;
    }

    public PessoaDao getPessoaDao() {
        return PessoaDao;
    }

    public void setPessoaDao(PessoaDao pessoaDao) {
        PessoaDao = pessoaDao;
    }

    public List<Pessoa> getPessoas() {
        return Pessoas;
    }

    public void setPessoas(List<Pessoa> Pessoas) {
        Pessoas = Pessoas;
    }
}
