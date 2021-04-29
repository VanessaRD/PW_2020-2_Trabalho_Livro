/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.conversores.ConverterOrdem;
import java.io.Serializable;
import javax.ejb.Stateful;
import br.edu.ifsul.modelo.Usuario;
import javax.persistence.Query;

/**
 *
 * @author Vanessa Rossi D.
 */
@Stateful
public class UsuarioDAO<TIPO> extends DAOGenerico<Usuario> implements Serializable {

    public UsuarioDAO() {
        super();
        classePersistente = Usuario.class;
        // definir as ordens possíveis
        listaOrdem.add(new Ordem("nomeUsuario", "Nome de usuário", "like"));
        listaOrdem.add(new Ordem("nome", "Nome", "like"));
        listaOrdem.add(new Ordem("email", "Email", "like"));
        // difinir a ordem inicial
        ordemAtual = listaOrdem.get(1);
        // inicializar o conversor das ordens
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);
    }

    @Override
    public Usuario getObjectByID(Object id) throws Exception {
        Usuario obj = em.find(Usuario.class, id);
        // inicializar a coleção
        obj.getPermissoes().size();
        return obj;
    }

    public boolean verificaUnicidadeNomeUsuario(String nomeUsuario) throws Exception {
        String jpql = "from Usuario where nomeUsuario = :pNomeUsuario";
        Query query = em.createQuery(jpql);
        query.setParameter("pNomeUsuario", nomeUsuario);
        if (query.getResultList().size() > 0) {
            return false;
        } else {
            return true;
        }
    }

}
