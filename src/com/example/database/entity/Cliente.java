package com.example.database.entity;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idCliente; // Integer invece di int data la possibilità di vedere se il campo non è popolato (null)
	private String nome;
	private String cognome;
	private String email;
	private String indirizzo;
	private String citta;
	private String provincia;
	private String cap;

	public Cliente(Integer idCliente, String nome, String cognome, String email, String indirizzo, String citta,
			String provincia, String cap) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.provincia = provincia;
		this.cap = cap;
	}

	public Cliente(String nome, String cognome, String email, String indirizzo, String citta,
			String provincia, String cap) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.provincia = provincia;
		this.cap = cap;
	}


	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}

	@Override
	public String toString() {
		return String.format(
				"Cliente [idCliente=%s, nome=%s, cognome=%s, email=%s, indirizzo=%s, citta=%s, provincia=%s, cap=%s]",
				idCliente, nome, cognome, email, indirizzo, citta, provincia, cap);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(idCliente, other.idCliente);
	}

	
}
