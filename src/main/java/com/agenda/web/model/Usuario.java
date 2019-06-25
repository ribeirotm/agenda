package com.agenda.web.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome")
    , @NamedQuery(name = "Usuario.findByUsername", query = "SELECT u FROM Usuario u WHERE u.username = :username")
    , @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuario")
    private Integer idUsuario;

    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;

    @Basic(optional = false)
    @Column(name = "login")
    private String username;

    @Basic(optional = false)
    @Column(name = "senha")
    private String password;

    @OneToMany(mappedBy = "idUsuario")
    private Collection<Contato> contatoCollection;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
	this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String nome, String username, String password) {
	this.idUsuario = idUsuario;
	this.nome = nome;
	this.username = username;
	this.password = password;
    }

    public Integer getIdUsuario() {
	return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
	this.idUsuario = idUsuario;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public Collection<Contato> getContatoCollection() {
	return contatoCollection;
    }

    public void setContatoCollection(Collection<Contato> contatoCollection) {
	this.contatoCollection = contatoCollection;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (idUsuario != null ? idUsuario.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	if (!(object instanceof Usuario)) {
	    return false;
	}
	Usuario other = (Usuario) object;
	if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "" + idUsuario;
    }

}
