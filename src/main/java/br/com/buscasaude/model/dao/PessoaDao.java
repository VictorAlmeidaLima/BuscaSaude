package br.com.buscasaude.model.dao;

import br.com.buscasaude.model.entities.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class PessoaDao {

    public Pessoa getPessoaByPK(long idPessoa){
        EntityManager em = JpaResourceBean.getEntityManager();
        Pessoa pessoa = null;

        try{
            pessoa = (Pessoa) em.createQuery("select p from Pessoa p where p.idPessoa = :idPessoa")
                    .setParameter("idPessoa",idPessoa).getSingleResult();

            return pessoa;
        }catch (NoResultException e){
            return null;
        }
        finally {
            em.close();
        }
    }

    public List<Pessoa> selectAll(){
        EntityManager em = JpaResourceBean.getEntityManager();

        List<Pessoa> pessoas = null;

        try{
            pessoas = em.createQuery("from Pessoa").getResultList();
        }catch(Exception e){

        }finally {
            em.close();
        }

        return pessoas;
    }

    public void insert(Pessoa pessoa) throws Exception {
        EntityManager em = JpaResourceBean.getEntityManager();

        try{
            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();

            throw new Exception("INSERT: "+e.getMessage());
        }finally {
            em.close();
        }
    }

    public void update(Pessoa pessoa){
        EntityManager em = JpaResourceBean.getEntityManager();

        try{
            em.getTransaction().begin();
            em.merge(pessoa);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }

    public void delete(Pessoa pessoa){
        EntityManager em = JpaResourceBean.getEntityManager();

        try{
            em.getTransaction().begin();
            em.remove(pessoa);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }
}
