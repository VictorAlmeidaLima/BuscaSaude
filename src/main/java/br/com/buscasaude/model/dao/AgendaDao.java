package br.com.buscasaude.model.dao;

import br.com.buscasaude.model.entities.Agenda;
import br.com.buscasaude.model.entities.Pessoa;
import br.com.buscasaude.model.entities.Profissional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.math.BigDecimal;
import java.util.List;

public class AgendaDao {

    public Agenda getAgendaByPK(BigDecimal idAgenda){
        EntityManager em = JpaResourceBean.getEntityManager();
        Agenda Agenda = null;

        try{
            Agenda = (Agenda) em.createQuery("select p from Agenda p where p.idAgenda = :idAgenda")
                    .setParameter("idAgenda",idAgenda).getSingleResult();

            return Agenda;
        }catch (NoResultException e){
            return null;
        }
        finally {
            em.close();
        }
    }

    public List<Agenda> selectAllProfissional(Profissional profissional) throws Exception {
        EntityManager em = JpaResourceBean.getEntityManager();

        List<Agenda> Agendas = null;

        try{
            Agendas = em.createQuery("from Agenda A where A.profissional = :profissional")
                    .setParameter("profissional",profissional).getResultList();

        }catch(Exception e){
            throw new Exception("Agendas não encontrados");
        }finally {
            em.close();
        }

        return Agendas;
    }


    public void insert(Agenda Agenda) throws Exception {
        EntityManager em = JpaResourceBean.getEntityManager();

        try{
            em.getTransaction().begin();
            em.persist(Agenda);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();

            throw new Exception("INSERT: "+e.getMessage());
        }finally {
            em.close();
        }
    }

    public void update(Agenda Agenda){
        EntityManager em = JpaResourceBean.getEntityManager();

        try{
            em.getTransaction().begin();
            em.merge(Agenda);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }

    public void delete(Agenda Agenda){
        EntityManager em = JpaResourceBean.getEntityManager();

        try{
            em.getTransaction().begin();
            em.remove(Agenda);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }
}
