/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Autor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Vanessa Rossi D.
 */
public class TestePersistirAutor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LivrosPU");
        EntityManager em = emf.createEntityManager();

        /*Autor a = new Autor();
        a.setNome("Ko Moon-young");
        a.setBibliografia("Vinda do drama sul-coreano It’s Okay to Not Be Okay (Tudo bem não ser normal) conquistou uma legião de fãs ao redor do mundo e movimentou as redes sociais brasileiras a cada novo episódio lançado pela Netflix.");
           */ 
        Autor a2 = new Autor();
        a2.setNome("J.K. Rowling ");
        a2.setBibliografia("J. K. Rowling (1965) é uma escritora britânica, autora da série \"Harry Potter\", que conquistou o público jovem e vendeu milhões de exemplares. J. K. Rowling nasceu em Yate, Inglaterra, no dia 31 de julho de 1965.");
        
        Autor a3 = new Autor();// LIVRO -- Working effectively with legacy code
        a3.setNome("Michael C. Feathers");
        a3.setBibliografia("Michael is also the author of the book Working Effectively with Legacy Code (Prentice Hall, 2004).");
        
        Autor a4 = new Autor(); //Design Patterns: Elements of Reusable Object-Oriented Software
        a4.setNome("Richard Helm ");
        a4.setBibliografia("Richard Helm is a core member of The Boston Consulting Group’s Technology Advantage practice and has been a BCG Fellow since 2012.");
        
        Autor a5 = new Autor(); //Design Patterns: Elements of Reusable Object-Oriented Software
        a5.setNome("Ralph Johnson");
        a5.setBibliografia("Ralph Johnson é um cientista da computação estadunidense. É um dos quatro autores do livro Design Patterns: Elements of Reusable Object-Oriented Software.");
        
        Autor a6 = new Autor(); //Design Patterns: Elements of Reusable Object-Oriented Software
        a6.setNome("Erich Gamma");
        a6.setBibliografia("Erich Gamma é um cientista da computação suíço. É um dos quatro autores do livro Design Patterns: Elements of Reusable Object-Oriented Software. É também o principal projetista do JUnit e do Eclipse.");
        em.getTransaction().begin();
        em.persist(a2);
        em.persist(a3);
        em.persist(a4);
        em.persist(a5);
        em.persist(a6);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
