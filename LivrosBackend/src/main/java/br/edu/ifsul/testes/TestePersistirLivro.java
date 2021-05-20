/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Autor;
import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Formato;
import br.edu.ifsul.modelo.Idioma;
import br.edu.ifsul.modelo.Livro;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Vanessa Rossi D.
 */
public class TestePersistirLivro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LivrosPU");
        EntityManager em = emf.createEntityManager();
        
        /* LIVRO 1 */
        Livro l1 = new Livro();
        l1.setCodigoBarras("1235453467");
        l1.setNumeroPaginas(24);
        l1.setAtivo(true);
        l1.setDataCadastro(new GregorianCalendar(2021, Calendar.JANUARY, 14));
        l1.setValor(45.99);
        /* Livro Basico */
        /* O ISBN (International Standard Book Number/ Padrão Internacional de Numeração de Livro) */
        l1.setISBN("444-65-5560-195-3");
        l1.setTitulo("O menino TESTE");
        l1.setResumo("Em tsdgg zumbTESTjo.");
        l1.setEditora("It’s TERER Okay");
        l1.setDataPublicacao(Calendar.getInstance());//"14/01/2021"

        //Autor a = em.find(Autor.class, 1);
        //l1.setAutores((Set<Autor>) a);

        Formato f = em.find(Formato.class, 4); //e-book digital
        l1.setFormato(f);
        Idioma i = em.find(Idioma.class, 10);
        l1.setIdioma(i);
        Catalogo c = em.find(Catalogo.class, 7); // livro infantil
        l1.setCatalogo(c);

        em.getTransaction().begin();
        em.persist(l1);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
