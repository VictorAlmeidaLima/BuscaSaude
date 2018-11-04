package br.com.buscasaude.model.bean;

import br.com.buscasaude.model.dao.AgendaDao;
import br.com.buscasaude.model.entities.Agenda;
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
public class AgendaBean {

    private br.com.buscasaude.model.entities.Agenda Agenda;
    private br.com.buscasaude.model.dao.AgendaDao AgendaDao;
    private List<Agenda> AgendasProfissional;

    @PostConstruct
    public void init(){

        Agenda = new Agenda();
        AgendaDao = new AgendaDao();
    }


    public void carregaAgendaProfissional(Profissional profissional){

        try{
            AgendasProfissional = (List<Agenda>) AgendaDao.selectAllProfissional(profissional);
        }catch (Exception e){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }
    }
}


