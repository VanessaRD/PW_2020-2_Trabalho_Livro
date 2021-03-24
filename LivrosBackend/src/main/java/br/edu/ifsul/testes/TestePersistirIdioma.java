/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Idioma;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Vanessa Rossi D.
 */
public class TestePersistirIdioma {
     /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LivrosPU");
        EntityManager em = emf.createEntityManager();
        
        Idioma i1 = new Idioma();
        i1.setNome("Portugues");
        i1.setSigla("PT");

        Idioma i2 = new Idioma();
        i2.setNome("Ingles");
        i2.setSigla("en");

        Idioma i = new Idioma();
        i.setNome("Coreano");
        i.setSigla("kn");
        
        em.getTransaction().begin();
        em.persist(i);
        em.persist(i1);
        em.persist(i2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
