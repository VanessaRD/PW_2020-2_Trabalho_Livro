/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Autor;
import br.edu.ifsul.modelo.Livro;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Vanessa Rossi D.
 */
public class TestePersistirAutores {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LivrosPU");
        EntityManager em = emf.createEntityManager();
        
        Livro l = em.find(Livro.class, "978-65-5560-195-4");
        Autor a = em.find(Autor.class, 7);//"J.K. Rowling "
        Autor a2 = em.find(Autor.class, 10);//"Ko Moon-younga"
        l.getAutores().add(a);
        l.getAutores().add(a2);
        
        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
