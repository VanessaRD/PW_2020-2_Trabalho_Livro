/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CatalogoDAO;
import br.edu.ifsul.dao.LivrariaDAO;
import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Livraria;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Vanessa Rossi D.
 */
@Named(value = "controleLivraria")
@ViewScoped
public class ControleLivraria implements Serializable {

    @EJB
    private LivrariaDAO<Livraria> dao;
    private Livraria objeto;

    @EJB
    private CatalogoDAO<Catalogo> daoCatalogo;
    private Catalogo catalogo;
    private Boolean novoCatalogo;
    private int abaAtiva;
/*    private Boolean novoReceituario;
    private Catalogo catalogo;
    private Boolean novoCatalogo;
    private int abaAtiva;*/
    
    public ControleLivraria() {

    }

    public void novoCatalogo(){
        catalogo = new Catalogo();
        novoCatalogo = true;
    }
    public void removerCatalogo(Catalogo obj){
        objeto.getCatalogos().remove(obj);
        Util.mensagemInformacao("Catalogo removido com sucesso!");
    }
            
    public void adicionarCatalogo(){
        if(!objeto.getCatalogos().contains(catalogo)){
            objeto.getCatalogos().add(catalogo);
            Util.mensagemInformacao("Catalogo adicionado com sucesso!");
        }else{
            Util.mensagemInformacao("Livraria já possui este Catalogo!");
        }
    }
    public void alterarCatalogo(int index){
        catalogo = objeto.getCatalogos().get(index);
        novoCatalogo = false;
    }
    public void salvarCatalogo(){
        if (novoCatalogo){
            objeto.adicionarCatalogo(catalogo);
        }
        Util.mensagemInformacao("Catalogo adicionado ou alterado com sucesso!");
    }   
    
    public void removerCatalogo(int index) {
        objeto.removerCatalogo(index);
        Util.mensagemInformacao("Catalogo removido com sucesso!");
    }
    /*
    public void removerCatalogo(Catalogo obj) {
        objeto.getCatalogos().remove(obj);
        Util.mensagemInformacao("Catalogo removido com sucesso!");
    }

    public void adicionarCatalogo() {
        if (!objeto.getCatalogos().contains(catalogo)) {
            objeto.getCatalogos().add(catalogo);
            Util.mensagemInformacao("Catalogo adicionado com sucesso!");
        } else {
            Util.mensagemErro("Livraria já possui este catalogo");
        }
    }

    
    public void novoCatalogo() {
        catalogo = new Catalogo();
        novoCatalogo = true;
    }

    public void alterarCatalogo(int index) {
        catalogo = objeto.getCatalogos().get(index);
        novoCatalogo = false;
    }

    public void salvarCatalogo() {
        if (novoCatalogo) {
            objeto.adicionarCatalogo(catalogo);
        }
        Util.mensagemInformacao("Catalogo adicionado ou alterado com sucesso!");
    } 

    public void removerCatalogo(int index) {
        objeto.removerCatalogo(index);
        Util.mensagemInformacao("Catalogo removido com sucesso!");
    }*/

    public String listar() {
        return "/privado/livraria/listar?faces-redirect=true";
    }

    public void novo() {
        abaAtiva = 0;
        objeto = new Livraria();
    }

    public void alterar(Object id) {
        abaAtiva = 0;
        try {
            objeto = dao.getObjectByID(id);
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

    public void salvar() {
        try {
            if (objeto.getId() == null) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e) {
            Util.mensagemInformacao("Erro ao salvar objeto: " + Util.getMensagemErro(e));
        }
    }

    public LivrariaDAO<Livraria> getDao() {
        return dao;
    }

    public void setDao(LivrariaDAO<Livraria> dao) {
        this.dao = dao;
    }

    public Livraria getObjeto() {
        return objeto;
    }

    public void setObjeto(Livraria objeto) {
        this.objeto = objeto;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public CatalogoDAO<Catalogo> getDaoCatalogo() {
        return daoCatalogo;
    }

    public void setDaoCatalogo(CatalogoDAO<Catalogo> daoCatalogo) {
        this.daoCatalogo = daoCatalogo;
    }

    public Boolean getNovoCatalogo() {
        return novoCatalogo;
    }

    public void setNovoCatalogo(Boolean novoCatalogo) {
        this.novoCatalogo = novoCatalogo;
    }

    public int getAbaAtiva() {
        return abaAtiva;
    }

    public void setAbaAtiva(int abaAtiva) {
        this.abaAtiva = abaAtiva;
    }

}
