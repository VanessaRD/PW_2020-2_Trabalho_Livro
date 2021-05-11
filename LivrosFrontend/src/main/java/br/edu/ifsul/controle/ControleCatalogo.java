/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CatalogoDAO;
import br.edu.ifsul.dao.LivrariaDAO;
import br.edu.ifsul.dao.LivroDAO;
import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Livraria;
import br.edu.ifsul.modelo.Livro;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Vanessa Rossi D.
 */
@Named(value = "controleCatalogo")
@ViewScoped
public class ControleCatalogo implements Serializable {

    @EJB
    private CatalogoDAO<Catalogo> dao;
    private Catalogo objeto;
    
    @EJB
    private LivrariaDAO<Livraria> daoLivraria;
    
    @EJB
    private LivroDAO<Livro> daoLivro;
    private Livro livro;
    private int abaAtiva;

    public ControleCatalogo() {

    }
    
    public void removerLivro(Livro obj) {
        objeto.getLivros().remove(obj);
        Util.mensagemInformacao("Livro removido com sucesso!");
    }

    public void adicionarLivro() {
        if (!objeto.getLivros().contains(livro)) {
            objeto.getLivros().add(livro);
            Util.mensagemInformacao("Livro adicionado com sucesso!");
        } else {
            Util.mensagemErro("Catalogo já possui este livro");
        }
    }

    public String listar() {
        return "/privado/catalogo/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Catalogo();
        abaAtiva = 0;
    }

    public void alterar(Object id) {
        try {
            objeto = dao.getObjectByID(id);
            abaAtiva = 0;
        } catch (Exception e) {
            Util.mensagemInformacao("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
        }
    }

    public void excluir(Object id) {
        try {
            objeto = dao.getObjectByID(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e) {
            Util.mensagemInformacao("Erro ao remover objeto: " + Util.getMensagemErro(e));
        }
    }

    public void salvar(){
        try {
            if (objeto.getId() == null){
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e){
            Util.mensagemInformacao("Erro ao salvar objeto: " + Util.getMensagemErro(e));
        }
    }

    public CatalogoDAO<Catalogo> getDao() {
        return dao;
    }

    public void setDao(CatalogoDAO<Catalogo> dao) {
        this.dao = dao;
    }

    public Catalogo getObjeto() {
        return objeto;
    }

    public void setObjeto(Catalogo objeto) {
        this.objeto = objeto;
    }

    public LivroDAO<Livro> getDaoLivro() {
        return daoLivro;
    }

    public void setDaoLivro(LivroDAO<Livro> daoLivro) {
        this.daoLivro = daoLivro;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public int getAbaAtiva() {
        return abaAtiva;
    }

    public void setAbaAtiva(int abaAtiva) {
        this.abaAtiva = abaAtiva;
    }

    public LivrariaDAO<Livraria> getDaoLivraria() {
        return daoLivraria;
    }

    public void setDaoLivraria(LivrariaDAO<Livraria> daoLivraria) {
        this.daoLivraria = daoLivraria;
    }

}
