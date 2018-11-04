package br.com.buscasaude.model.bean;

import br.com.buscasaude.model.dao.EspecialidadeDao;
import br.com.buscasaude.model.entities.Especialidade;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

public class EspecialidadeBean {

    private Especialidade Especialidade;
    private EspecialidadeDao EspecialidadeDao;
    private List<Especialidade> Especialidades;

    @PostConstruct
    public void init(){

        Especialidade = new Especialidade();
        EspecialidadeDao = new EspecialidadeDao();

        try{
            Especialidades = (List<Especialidade>) EspecialidadeDao.selectAll();
        }catch (Exception e){
            //do nothing
        }
    }

    public String inserir(){
        try {
            EspecialidadeDao.insert(this.Especialidade);
            Especialidade = new Especialidade();

            Especialidades = EspecialidadeDao.selectAll();

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado", " Especialidade Cadastrado com sucesso!"));
            context.getExternalContext().getFlash().setKeepMessages(true);

        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }

        return "sucesso";
    }

    public Especialidade getEspecialidade() {
        return Especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        Especialidade = especialidade;
    }

    public List<Especialidade> getEspecialidades() {
        return Especialidades;
    }

    public void setEspecialidades(List<Especialidade> especialidades) {
        Especialidades = especialidades;
    }
}
