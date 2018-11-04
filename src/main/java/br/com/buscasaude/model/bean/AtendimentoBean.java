package br.com.buscasaude.model.bean;

import br.com.buscasaude.model.dao.AtendimentoDao;
import br.com.buscasaude.model.entities.Atendimento;
import br.com.buscasaude.model.entities.Parceiro;
import br.com.buscasaude.model.entities.Pessoa;
import br.com.buscasaude.model.entities.Profissional;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean
@SessionScoped
public class AtendimentoBean {

    private Atendimento Atendimento;
    private AtendimentoDao AtendimentoDao;
    private List<Atendimento> AtendimentosPessoa;
    private List<Atendimento> AtendimentosProfissional;

    @PostConstruct
    public void init(){

        Atendimento = new Atendimento();
        AtendimentoDao = new AtendimentoDao();
    }

    public void carregaAtendimentoPessoa(Pessoa pessoa){

        try{
            AtendimentosPessoa = (List<Atendimento>) AtendimentoDao.selectAllPessoa(pessoa);
        }catch (Exception e){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }
    }

    public void carregaAtendimentoProfissional(Profissional profissional){

        try{
            AtendimentosProfissional = (List<Atendimento>) AtendimentoDao.selectAllProfissional(profissional);
        }catch (Exception e){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }
    }
}
