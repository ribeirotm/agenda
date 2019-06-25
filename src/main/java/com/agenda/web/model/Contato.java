package com.agenda.web.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Aluno
 */
@Entity
@Table(name = "contato")
@NamedQueries({
    @NamedQuery(name = "Contato.findAll", query = "SELECT c FROM Contato c")
    , @NamedQuery(name = "Contato.findByIdContato", query = "SELECT c FROM Contato c WHERE c.idContato = :idContato")
    , @NamedQuery(name = "Contato.findByNome", query = "SELECT c FROM Contato c WHERE c.nome = :nome")
    , @NamedQuery(name = "Contato.findByCargo", query = "SELECT c FROM Contato c WHERE c.cargo = :cargo")
    , @NamedQuery(name = "Contato.findByEmpresa", query = "SELECT c FROM Contato c WHERE c.empresa = :empresa")
    , @NamedQuery(name = "Contato.findByDataAniversario", query = "SELECT c FROM Contato c WHERE c.dataAniversario = :dataAniversario")})
public class Contato implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idContato")
    private Integer idContato;
    
    @Basic(optional = false)
    @Column(name = "nome")
    @NotNull(message = "Nome é uma informação obrigatória.")
    private String nome;
    
    @Column(name = "cargo")
    private String cargo;
    
    @Column(name = "empresa")
    private String empresa;
    
    @Basic(optional = false)
    @Column(name = "dataAniversario")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataAniversario;
    
    @OneToMany(mappedBy = "idContato")
    private Collection<Endereco> enderecoCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContato")
    private Collection<MeioContato> meioContatoCollection;
    
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuario idUsuario;

    public Contato() {
    }

    public Contato(Integer idContato) {
        this.idContato = idContato;
    }

    public Contato(Integer idContato, String nome) {
        this.idContato = idContato;
        this.nome = nome;
    }

    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Date getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(Date dataAniversario) {
        this.dataAniversario = dataAniversario;
    }

    public Collection<Endereco> getEnderecoCollection() {
        return enderecoCollection;
    }

    public void setEnderecoCollection(Collection<Endereco> enderecoCollection) {
        this.enderecoCollection = enderecoCollection;
    }

    public Collection<MeioContato> getMeioContatoCollection() {
        return meioContatoCollection;
    }

    public void setMeioContatoCollection(Collection<MeioContato> meioContatoCollection) {
        this.meioContatoCollection = meioContatoCollection;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContato != null ? idContato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contato)) {
            return false;
        }
        Contato other = (Contato) object;
        if ((this.idContato == null && other.idContato != null) || (this.idContato != null && !this.idContato.equals(other.idContato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idContato;
    }
    
}
