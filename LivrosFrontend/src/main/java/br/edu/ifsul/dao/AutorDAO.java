/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;


import br.edu.ifsul.modelo.Autor;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Vanessa Rossi D.
 * @param <TIPO>
 */
@Stateful
public class AutorDAO<TIPO> extends DAOGenerico<Autor> implements Serializable {

    public AutorDAO() {
        super();
        classePersistente = Autor.class;
    }
}