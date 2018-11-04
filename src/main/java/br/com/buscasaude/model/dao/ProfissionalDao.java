package br.com.buscasaude.model.dao;

import br.com.buscasaude.model.entities.Profissional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class ProfissionalDao {

    public Profissional getProfissionalByPK(long idProfissional){
        EntityManager em = JpaResourceBean.getEntityManager();
        Profissional profissional = null;

        try{
            profissional = (Profissional) em.createQuery("select p from Profissional p where p.idProfissional = :idProfissional")
                    .setParameter("idProfissional",idProfissional).getSingleResult();

            return profissional;
        }catch (NoResultException e){
            return null;
        }
        finally {
            em.close();
        }
    }

    public List<Profissional> selectAll(){
        EntityManager em = JpaResourceBean.getEntityManager();

        List<Profissional> profissionais = null;

        try{
            profissionais = em.createQuery("from Profissional").getResultList();
        }catch(Exception e){

        }finally {
            em.close();
        }

        return profissionais;
    }

    public void insert(Profissional profissional) throws Exception {
        EntityManager em = JpaResourceBean.getEntityManager();

        try{
            em.getTransaction().begin();
            em.persist(profissional);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();

            throw new Exception("INSERT: "+e.getMessage());
        }finally {
            em.close();
        }
    }

    public void update(Profissional profissional){
        EntityManager em = JpaResourceBean.getEntityManager();

        try{
            em.getTransaction().begin();
            em.merge(profissional);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }

    public void delete(Profissional profissional){
        EntityManager em = JpaResourceBean.getEntityManager();

        try{
            em.getTransaction().begin();
            em.remove(profissional);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }
}
