/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Livraria;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Vanessa Rossi D.
 */
public class TestePersistirLivraria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LivrosPU");
        EntityManager em = emf.createEntityManager();

        Livraria l = new Livraria();
        l.setNome("Korean Brazil");
        l.setSite("www.koreanBrazil.com");

        Livraria l2 = new Livraria();
        l2.setNome("Saraiva");
        l2.setSite("www.saraiva.com.br");

        Livraria l3 = new Livraria();
        l3.setNome("Amazon");
        l3.setSite("www.amazon.com.br/livros");

        Livraria l4 = new Livraria();
        l4.setNome("Intrinseca");
        l4.setSite("www.intrinseca.com.br");

        em.getTransaction().begin();
        em.persist(l);
        em.persist(l2);
        em.persist(l3);
        em.persist(l4);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
