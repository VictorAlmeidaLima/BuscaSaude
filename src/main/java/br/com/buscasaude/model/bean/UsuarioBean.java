package br.com.buscasaude.model.bean;

import br.com.buscasaude.model.dao.UsuarioDao;
import br.com.buscasaude.model.entities.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean
@SessionScoped
public class UsuarioBean {

    private Usuario usuario;
    private UsuarioDao usuarioDao;
    private List<Usuario> usuarios;

    @PostConstruct
    public void init(){

        usuario = new Usuario();
        usuarioDao = new UsuarioDao();

        try{
            usuarios = (List<Usuario>) usuarioDao.selectAll();
        }catch (Exception e){
            //do nothing
        }
    }

    public String login(){
        usuario = usuarioDao.getUsuario(usuario.getEmail(),usuario.getPassword());
        if (usuario == null){
            usuario = new Usuario();
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario não Encontrado",
                            "Erro no Login"));
            return null;
        }else {
            return "telaprincipal";
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
