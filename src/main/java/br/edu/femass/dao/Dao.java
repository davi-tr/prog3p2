package br.edu.femass.dao;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Dao<E> {
    
    private static EntityManagerFactory emf;
    private static EntityManager em;

    static{
        try{
            emf = Persistence.createEntityManagerFactory("jpa_prog3");
            
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public Dao (){
        em = emf.createEntityManager();
    }
    
    public void inserir(E entidade){
        em.getTransaction().begin();
        em.persist(entidade);
        em.getTransaction().commit();
    }
}
