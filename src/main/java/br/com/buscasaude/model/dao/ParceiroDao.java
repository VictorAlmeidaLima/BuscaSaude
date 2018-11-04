package br.com.buscasaude.model.dao;

import br.com.buscasaude.model.entities.Parceiro;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class ParceiroDao {

    public Parceiro getParceiroByPK(long codParc){
        EntityManager em = JpaResourceBean.getEntityManager();
        Parceiro parceiro = null;

        try{
            parceiro = (Parceiro) em.createQuery("select p from Parceiro p where p.codparc = :codparc")
                    .setParameter("codparc",codParc).getSingleResult();

            return parceiro;
        }catch (NoResultException e){
            return null;
        }
        finally {
            em.close();
        }
    }

    public List<Parceiro> selectAll(){
        EntityManager em = JpaResourceBean.getEntityManager();

        List<Parceiro> parceiros = null;

        try{
            parceiros = em.createQuery("from Parceiro").getResultList();
        }catch(Exception e){

        }finally {
            em.close();
        }

        return parceiros;
    }

    public void inserir(Parceiro parceiro) throws Exception {
        EntityManager em = JpaResourceBean.getEntityManager();

        try{
            em.getTransaction().begin();
            em.persist(parceiro);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();

            throw new Exception("INSERT: "+e.getMessage());
        }finally {
            em.close();
        }
    }

    public void update(Parceiro parceiro){
        EntityManager em = JpaResourceBean.getEntityManager();

        try{
            em.getTransaction().begin();
            em.merge(parceiro);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }

    public void delete(Parceiro parceiro){
        EntityManager em = JpaResourceBean.getEntityManager();

        try{
            em.getTransaction().begin();
            em.remove(parceiro);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }

}
