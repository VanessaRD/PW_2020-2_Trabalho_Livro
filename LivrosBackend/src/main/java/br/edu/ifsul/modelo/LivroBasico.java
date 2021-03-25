/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "livroBasico")
@Inheritance(strategy = InheritanceType.JOINED)
public class LivroBasico implements Serializable {

    @Id
    @NotBlank(message = "O ISBN deve ser informado")
    @Length(max = 30, message = "O ISBN não deve ter mais que {max} caracteres")
    @Column(name = "ISBN", length = 30, nullable = false)
    private String ISBN;

    @NotBlank(message = "O titulo não pode ser em branco")
    @Length(max = 50, message = "O titulo não pode ter mais que {max} caracteres")
    @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;

    @NotBlank(message = "O resumo não pode ser em branco")
    @Length(max = 500, message = "O resumo não pode ter mais que {max} caracteres")
    @Column(name = "resumo", columnDefinition = "text", nullable = false, length = 500)
    private String resumo;

    @NotBlank(message = "A editora não pode ser em branco")
    @Length(max = 50, message = "A editora não pode ter mais que {max} caracteres")
    @Column(name = "editora", nullable = false, length = 50)
    private String editora;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data da publicação deve ser informada")
    @Column(name = "dataPublicacao", nullable = false)
    private Calendar dataPublicacao;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "autor_livro",
            joinColumns
            = @JoinColumn(name = "ISBN", referencedColumnName = "ISBN",
                    nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "id_Autor", referencedColumnName = "id", nullable = false))
    private Set<Autor> autores = new HashSet<>();

    public LivroBasico() {
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Calendar getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Calendar dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Set<Autor> getAutores() {
        return autores;
    }

    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.ISBN);
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
        final LivroBasico other = (LivroBasico) obj;
        if (!Objects.equals(this.ISBN, other.ISBN)) {
            return false;
        }
        return true;
    }

}
