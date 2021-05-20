/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.conversores.ConverterOrdem;
import br.edu.ifsul.modelo.Livro;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author Vanessa Rossi D.
 */
@Stateful
public class LivroDAO<TIPO> extends DAOGenerico<Livro> implements Serializable {

    public LivroDAO() {
        super();
        classePersistente = Livro.class;
        // definir as ordens possíveis
        listaOrdem.add(new Ordem("ISBN", "ISBN", "="));
        listaOrdem.add(new Ordem("titulo", "Titulo", "like"));
        listaOrdem.add(new Ordem("formato.nome", "Formato", "like"));
        listaOrdem.add(new Ordem("idioma.nome", "Idioma", "like"));
        listaOrdem.add(new Ordem("catalogo.nome", "Catalogo", "like"));
        // difinir a ordem inicial
        ordemAtual = listaOrdem.get(1);
        // inicializar o conversor das ordens
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);
    }

    public Livro getObjectByID(Object ISBN) throws Exception {
        Livro obj = em.find(Livro.class, ISBN);
        // uso para evitar o erro de lazy inicialization exception
        obj.getAutores().size();
        return obj;
    }
    
      public void remover(Livro obj) throws Exception {
        obj = em.find(Livro.class, obj.getISBN());
        em.remove(obj);
    } 
}
