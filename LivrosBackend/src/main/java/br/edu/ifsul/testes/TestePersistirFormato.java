/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Formato;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Vanessa Rossi D.
 */
public class TestePersistirFormato {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LivrosPU");
        EntityManager em = emf.createEntityManager();

        Formato f = new Formato();
        f.setNome("e-book"); // Digital
        
        Formato f2 = new Formato();
        f2.setNome("livro");
        
        em.getTransaction().begin();
        em.persist(f);
        em.persist(f2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
