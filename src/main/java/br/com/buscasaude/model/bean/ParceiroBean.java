package br.com.buscasaude.model.bean;

import br.com.buscasaude.model.dao.ParceiroDao;
import br.com.buscasaude.model.entities.Parceiro;
import br.com.buscasaude.model.types.TipoParceiro;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean
@SessionScoped
public class ParceiroBean {


    private Parceiro parceiro;
    private ParceiroDao parceiroDao;
    private List<Parceiro> parceiros;

    @PostConstruct
    public void init(){
        parceiro = new Parceiro();
        parceiroDao = new ParceiroDao();

        try{
            parceiros = (List<Parceiro>) parceiroDao.selectAll();
        }catch (Exception e){

        }
    }

    public String inserir(){
        try {
            parceiroDao.inserir(this.parceiro);
            parceiro = new Parceiro();

            parceiros = parceiroDao.selectAll();

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado", " Parceiro Cadastrado com sucesso!"));
            context.getExternalContext().getFlash().setKeepMessages(true);

    } catch (Exception e) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
        context.getExternalContext().getFlash().setKeepMessages(true);
    }

        return "sucesso";
    }

    public Parceiro getParceiro() {
        return parceiro;
    }

    public void setParceiro(Parceiro parceiro) {
        this.parceiro = parceiro;
    }

    public List<Parceiro> getParceiros() {
        return parceiros;
    }

    public TipoParceiro[] getTipoParceiro(){
        return TipoParceiro.values();
    }

}
