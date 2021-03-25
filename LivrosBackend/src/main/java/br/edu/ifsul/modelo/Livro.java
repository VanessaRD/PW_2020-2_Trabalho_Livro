/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Vanessa Rossi D.
 */
@Entity
@Table(name = "livro")
public class Livro extends LivroBasico implements Serializable {

    @NotBlank(message = "O codigo de Barras deve ser informado")
    @Length(max = 40, message = "O codigo de Barras não deve ter mais que {max} caracteres")
    @Column(name = "codigoBarras", length = 40, nullable = false)
    private String codigoBarras;

    @NotNull(message = "O numero de Paginas deve ser informada")
    @Length(max = 10, message = "O numero de Paginas não deve ter mais que {max} caracteres")
    @Column(name = "numeroPaginas", nullable = false, length = 10)
    private Integer numeroPaginas;

    @NotNull(message = "O campo ativo deve ser informado")
    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de cadastro deve ser informada")
    @Column(name = "dataCadastro", nullable = false)
    private Calendar dataCadastro;

    @NotNull(message = "O valor deve ser informada")
    @Column(name = "valor", nullable = false, columnDefinition = "numeric(4,2)")
    private double valor;

    @NotNull(message = "O formato deve ser informado")
    @ManyToOne
    @JoinColumn(name = "formato_id", referencedColumnName = "id", nullable = false)
    private Formato formato;

    @NotNull(message = "O idioma deve ser informado")
    @ManyToOne
    @JoinColumn(name = "idioma_id", referencedColumnName = "id", nullable = false)
    private Idioma idioma;

    @NotNull(message = "O catalogo deve ser informado")
    @ManyToOne
    @JoinColumn(name = "catalogo_id", referencedColumnName = "id", nullable = false)
    private Catalogo catalogo;

    public Livro() {
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.codigoBarras);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Livro other = (Livro) obj;
        if (!Objects.equals(this.codigoBarras, other.codigoBarras)) {
            return false;
        }
        return true;
    }

}
