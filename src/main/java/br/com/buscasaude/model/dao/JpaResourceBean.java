package br.com.buscasaude.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaResourceBean {

    private static EntityManagerFactory emf;

    public static EntityManager getEntityManager(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("persistence");
        }

        return emf.createEntityManager();
    }
}
