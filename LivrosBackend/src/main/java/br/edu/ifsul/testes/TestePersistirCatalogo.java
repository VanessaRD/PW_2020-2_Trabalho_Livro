/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Livraria;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Vanessa Rossi D.
 */
public class TestePersistirCatalogo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LivrosPU");
        EntityManager em = emf.createEntityManager();

        Catalogo c = new Catalogo();
        c.setNome("Infantil");
        c.setDescricao("Livro Infantil");
        Livraria l = em.find(Livraria.class, 9);
        c.setLivraria(l);

        Catalogo c2 = new Catalogo();
        c2.setNome("Policial");
        c2.setDescricao("Livro Policial, Suspense e Misterio");
        c2.setLivraria(l);

        Catalogo c3 = new Catalogo();
        c3.setNome("Romance");
        c3.setDescricao("Livro de Romance e Drama");
        c3.setLivraria(l);

        em.getTransaction().begin();
        em.persist(c);
        em.persist(c2);
        em.persist(c3);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
