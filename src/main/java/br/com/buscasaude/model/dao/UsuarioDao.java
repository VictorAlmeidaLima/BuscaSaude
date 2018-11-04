package br.com.buscasaude.model.dao;


import br.com.buscasaude.model.entities.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class UsuarioDao {


    public Usuario getUsuario(String email, String senha){
        EntityManager em = JpaResourceBean.getEntityManager();
        Usuario usuario;

        try {
            usuario = (Usuario) em.createQuery("Select u from Usuario u where u.email = :email and u.password = :password")
                    .setParameter("email", email)
                    .setParameter("password", senha).getSingleResult();

            return usuario;
        }catch(NoResultException e){
            return null;
        }

    }

    public Usuario getUsuarioByPK(long idUsuario){
        EntityManager em = JpaResourceBean.getEntityManager();
        Usuario usuario = null;

        try{
            usuario = (Usuario) em.createQuery("select u from Usuario u where u.idUsuario = :idUsuario")
                    .setParameter("idUsuario",idUsuario).getSingleResult();

            return usuario;
        }catch (NoResultException e){
            return null;
        }
        finally {
            em.close();
        }
    }

    public List<Usuario> selectAll(){
        EntityManager em = JpaResourceBean.getEntityManager();

        List<Usuario> usuarios = null;

        try{
            usuarios = em.createQuery("from Usuario").getResultList();
        }catch(Exception e){

        }finally {
            em.close();
        }

        return usuarios;
    }

    public void insert(Usuario usuario){
        EntityManager em = JpaResourceBean.getEntityManager();

        try{
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        }catch(Exception e){

        }finally {
            em.close();
        }

    }

    public void update(Usuario usuario){
        EntityManager em = JpaResourceBean.getEntityManager();

        try{
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
        }catch(Exception e){

        }finally {
            em.close();
        }
    }

    public void delete(Usuario usuario){
        EntityManager em = JpaResourceBean.getEntityManager();

        try{
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();
        }catch(Exception e){

        }finally {
            em.close();
        }
    }
}