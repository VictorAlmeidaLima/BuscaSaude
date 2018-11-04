package br.com.buscasaude.model.dao;

import br.com.buscasaude.model.entities.Especialidade;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class EspecialidadeDao {

    public Especialidade getEspecialidadeByPK(long idEspecialidade){
        EntityManager em = JpaResourceBean.getEntityManager();
        Especialidade especialidade = null;

        try{
            especialidade = (Especialidade) em.createQuery("select p from Especialidade p where p.idEspecialidade = :idEspecialidade")
                    .setParameter("idEspecialidade",idEspecialidade).getSingleResult();

            return especialidade;
        }catch (NoResultException e){
            return null;
        }
        finally {
            em.close();
        }
    }

    public List<Especialidade> selectAll(){
        EntityManager em = JpaResourceBean.getEntityManager();

        List<Especialidade> especialidades = null;

        try{
            especialidades = em.createQuery("from Especialidade").getResultList();
        }catch(Exception e){

        }finally {
            em.close();
        }

        return especialidades;
    }

    public void insert(Especialidade especialidade) throws Exception {
        EntityManager em = JpaResourceBean.getEntityManager();

        try{
            em.getTransaction().begin();
            em.persist(especialidade);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();

            throw new Exception("INSERT: "+e.getMessage());
        }finally {
            em.close();
        }
    }

    public void update(Especialidade especialidade){
        EntityManager em = JpaResourceBean.getEntityManager();

        try{
            em.getTransaction().begin();
            em.merge(especialidade);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }

    public void delete(Especialidade especialidade){
        EntityManager em = JpaResourceBean.getEntityManager();

        try{
            em.getTransaction().begin();
            em.remove(especialidade);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }
}
