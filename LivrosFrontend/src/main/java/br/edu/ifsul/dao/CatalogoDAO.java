/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.conversores.ConverterOrdem;
import br.edu.ifsul.modelo.Catalogo;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Vanessa Rossi D.
 */
@Stateful
public class CatalogoDAO<TIPO> extends DAOGenerico<Catalogo> implements Serializable {

    public CatalogoDAO() {
        super();
        classePersistente = Catalogo.class;
        // definir as ordens possíveis
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("nome", "Nome", "like"));
        listaOrdem.add(new Ordem("livraria.nome", "Livraria", "like"));
        // difinir a ordem inicial
        ordemAtual = listaOrdem.get(1);
        // inicializar o conversor das ordens
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);
    }
}
