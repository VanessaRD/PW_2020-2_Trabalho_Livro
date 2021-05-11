/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.conversores.ConverterOrdem;
import br.edu.ifsul.modelo.Livraria;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Vanessa Rossi D.
 */
@Stateful
public class LivrariaDAO<TIPO> extends DAOGenerico<Livraria> implements Serializable {

    public LivrariaDAO() {
        super();
        classePersistente = Livraria.class;
        // definir as ordens possíveis
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("nome", "Nome", "like"));
        // difinir a ordem inicial
        ordemAtual = listaOrdem.get(1);
        // inicializar o conversor das ordens
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);
    }
    
    public Livraria getObjectByID(Object id) throws Exception {
        Livraria obj = em.find(Livraria.class, id);
        // uso para evitar o erro de lazy inicialization exception
        obj.getCatalogos().size();
        return obj;
    }   
}
