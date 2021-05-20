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
import br.edu.ifsul.modelo.Livraria;
import br.edu.ifsul.modelo.Livro;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author vaneh
 */
public class FabricaObjetos {
    
    public static List<Livraria> carregaLivraria(){
        List<Livraria> lista = new ArrayList<>();
        Livraria l = new Livraria();
        l.setId(1);
        l.setNome("teste");
        l.setSite("");
        
        // LIVRO 1 
        Livro l1 = new Livro();
        l1.setCodigoBarras("1235453467");
        l1.setNumeroPaginas(24);
        l1.setAtivo(true);
        l1.setDataCadastro(new GregorianCalendar(2021, Calendar.JANUARY, 14));
        l1.setValor(45.99);
        // Livro Basico
        l1.setISBN("978-65-5560-195-4");
        l1.setTitulo("O menino que se alimentava de pesadelos");
        l1.setResumo("Em Criança zumbi, um menino de pele muito pálida e olhos bem grandes nasceu num pequeno vilarejo.");
        l1.setEditora("It’s Okay to Not Be Okay");
        l1.setDataPublicacao(Calendar.getInstance());//"14/01/2021"
        
        Formato f = new Formato();
        f.setNome("e-book digital");
        l1.setFormato(f);
        
        
        Idioma i = new Idioma();
        i.setNome("coreano");
        i.setSigla("kr");
        l1.setIdioma(i); 
        
        
        Catalogo c = new Catalogo();
        //c.setId(2);
        c.setNome("");
        c.setDescricao("");
        c.setLivraria(l);
        //c.setLivros();
        
        l1.setCatalogo(c);
        //c.getLivros().add(l1);
        
        
        l.getCatalogos().add(c);
        
        return lista;
        
    }
    
    public static List<Autor> carregaAutores(){
        List<Autor> lista = new ArrayList<>();
        Autor a = new Autor();
        //a.setId(1);
        a.setNome("test nome autor primeiro");
        a.setBibliografia("testando bibliografia do primeiro autor!");
        
        Autor a3 = new Autor();// LIVRO -- Working effectively with legacy code
        a3.setNome("Michael C. Feathers");
        a3.setBibliografia("Michael is also the author of the book Working Effectively with Legacy Code (Prentice Hall, 2004).");
        
        Autor a4 = new Autor(); //Design Patterns: Elements of Reusable Object-Oriented Software
        a4.setNome("Richard Helm ");
        a4.setBibliografia("Richard Helm is a core member of The Boston Consulting Group’s Technology Advantage practice and has been a BCG Fellow since 2012.");
        
        return lista;
    }
}
