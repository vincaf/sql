package com.example.database.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the province database table.
 * 
 */
@Entity
@Table(name="province")
@NamedQuery(name="Provincia.findAll", query="SELECT p FROM Provincia p")
public class Provincia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(updatable=false, unique=true, nullable=false)
	private Integer id;

	@Column(name="codice_citta_metropolitana")
	private Integer codiceCittaMetropolitana;

	@Column(nullable=false, precision=10, scale=6)
	private BigDecimal latitudine;

	@Column(nullable=false, precision=10, scale=6)
	private BigDecimal longitudine;

	@Lob
	@Column(nullable=false)
	private String nome;

	@Column(name="sigla_automobilistica", nullable=false, length=2)
	private String siglaAutomobilistica;

	//bi-directional many-to-one association to Regione
	@ManyToOne
	@JoinColumn(name="id_regione", nullable=false)
	private Regione regione;

	public Provincia() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodiceCittaMetropolitana() {
		return this.codiceCittaMetropolitana;
	}

	public void setCodiceCittaMetropolitana(Integer codiceCittaMetropolitana) {
		this.codiceCittaMetropolitana = codiceCittaMetropolitana;
	}

	public BigDecimal getLatitudine() {
		return this.latitudine;
	}

	public void setLatitudine(BigDecimal latitudine) {
		this.latitudine = latitudine;
	}

	public BigDecimal getLongitudine() {
		return this.longitudine;
	}

	public void setLongitudine(BigDecimal longitudine) {
		this.longitudine = longitudine;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSiglaAutomobilistica() {
		return this.siglaAutomobilistica;
	}

	public void setSiglaAutomobilistica(String siglaAutomobilistica) {
		this.siglaAutomobilistica = siglaAutomobilistica;
	}

	public Regione getRegione() {
		return this.regione;
	}

	public void setRegione(Regione regione) {
		this.regione = regione;
	}

}