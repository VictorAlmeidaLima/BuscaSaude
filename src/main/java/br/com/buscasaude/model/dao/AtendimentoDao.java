package br.com.buscasaude.model.dao;

import br.com.buscasaude.model.entities.Atendimento;
import br.com.buscasaude.model.entities.Pessoa;
import br.com.buscasaude.model.entities.Profissional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.math.BigDecimal;
import java.util.List;

public class AtendimentoDao {

    public Atendimento getAtendimentoByPK(BigDecimal idAtendimento){
        EntityManager em = JpaResourceBean.getEntityManager();
        Atendimento atendimento = null;

        try{
            atendimento = (Atendimento) em.createQuery("select p from Atendimento p where p.idAtendimento = :idAtendimento")
                    .setParameter("idAtendimento",idAtendimento).getSingleResult();

            return atendimento;
        }catch (NoResultException e){
            return null;
        }
        finally {
            em.close();
        }
    }

    public List<Atendimento> selectAllPessoa(Pessoa pessoa) throws Exception {
        EntityManager em = JpaResourceBean.getEntityManager();

        List<Atendimento> atendimentos = null;

        try{
            atendimentos = em.createQuery("from Atendimento A where A.Paciente = :pessoa")
                    .setParameter("pessoa",pessoa).getResultList();
        }catch(Exception e){
            throw new Exception("Atendimentos não encontrados");
        }finally {
            em.close();
        }

        return atendimentos;
    }

    public List<Atendimento> selectAllProfissional(Profissional profissional) throws Exception {
        EntityManager em = JpaResourceBean.getEntityManager();

        List<Atendimento> atendimentos = null;

        try{
            atendimentos = em.createQuery("from Atendimento A where A.profissional = :profissional")
                    .setParameter("profissional",profissional).getResultList();

        }catch(Exception e){
            throw new Exception("Atendimentos não encontrados");
        }finally {
            em.close();
        }

        return atendimentos;
    }

    public void insert(Atendimento Atendimento) throws Exception {
        EntityManager em = JpaResourceBean.getEntityManager();

        try{
            em.getTransaction().begin();
            em.persist(Atendimento);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();

            throw new Exception("INSERT: "+e.getMessage());
        }finally {
            em.close();
        }
    }

    public void update(Atendimento Atendimento){
        EntityManager em = JpaResourceBean.getEntityManager();

        try{
            em.getTransaction().begin();
            em.merge(Atendimento);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }

    public void delete(Atendimento Atendimento){
        EntityManager em = JpaResourceBean.getEntityManager();

        try{
            em.getTransaction().begin();
            em.remove(Atendimento);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }
}
