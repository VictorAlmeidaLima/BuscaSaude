package br.com.buscasaude.model.dao;

import br.com.buscasaude.model.entities.Endereco;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class EnderecoDao {

    public Endereco getnderecoByPK(long codEndereco){
        EntityManager em = JpaResourceBean.getEntityManager();
        Endereco endereco = null;

        try{
            endereco = (Endereco) em.createQuery("select e from Endereco e where e.codEndereco = :codEndereco")
                    .setParameter("codEndereco",codEndereco).getSingleResult();

            return endereco;
        }catch (NoResultException e){
            return null;
        }
        finally {
            em.close();
        }
    }

    public List<Endereco> selectAll(){
        EntityManager em = JpaResourceBean.getEntityManager();

        List<Endereco> enderecos = null;

        try{
            enderecos = em.createQuery("from Endereco").getResultList();
        }catch(Exception e){

        }finally {
            em.close();
        }

        return enderecos;
    }

    public void inserir(Endereco endereco){
        EntityManager em = JpaResourceBean.getEntityManager();

        try{
            em.getTransaction().begin();
            em.persist(endereco);
            em.getTransaction().commit();
        }catch (Exception e){

        }finally {
            em.close();
        }
    }

    public void update(Endereco endereco){
        EntityManager em = JpaResourceBean.getEntityManager();

        try{
            em.getTransaction().begin();
            em.merge(endereco);
            em.getTransaction().commit();
        }catch(Exception e){

        }finally {
            em.close();
        }
    }

    public void delete(Endereco endereco){
        EntityManager em = JpaResourceBean.getEntityManager();

        try{
            em.getTransaction().begin();
            em.remove(endereco);
            em.getTransaction().commit();
        }catch(Exception e){

        }finally {
            em.close();
        }
    }
    
}
