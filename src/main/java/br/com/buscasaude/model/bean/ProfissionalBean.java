package br.com.buscasaude.model.bean;


import br.com.buscasaude.model.dao.ProfissionalDao;
import br.com.buscasaude.model.entities.Profissional;
import br.com.buscasaude.model.entities.Profissional;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean
@SessionScoped
public class ProfissionalBean {
    private Profissional Profissional;
    private ProfissionalDao ProfissionalDao;
    private List<Profissional> Profissionais;

    @PostConstruct
    public void init(){

        Profissional = new Profissional();
        ProfissionalDao = new ProfissionalDao();

        try{
            Profissionais = (List<Profissional>) ProfissionalDao.selectAll();
        }catch (Exception e){
            //do nothing
        }
    }

    public String inserir(){
        try {
            ProfissionalDao.insert(this.Profissional);
            Profissional = new Profissional();

            Profissionais = ProfissionalDao.selectAll();

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado", " Profissional Cadastrado com sucesso!"));
            context.getExternalContext().getFlash().setKeepMessages(true);

        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }

        return "sucesso";
    }

    public Profissional getProfissional() {
        return Profissional;
    }

    public void setProfissional(Profissional profissional) {
        Profissional = profissional;
    }


    public List<Profissional> getProfissionais() {
        return Profissionais;
    }

    public void setProfissionais(List<Profissional> profissionais) {
        Profissionais = profissionais;
    }
}
