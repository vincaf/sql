package com.example.database.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the comuni database table.
 * 
 */
@Entity
@Table(name="comuni")
@NamedQuery(name="Comune.findAll", query="SELECT c FROM Comune c")
public class Comune implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(updatable=false, unique=true, nullable=false)
	private Integer id;

	@Column(name="capoluogo_provincia")
	private Integer capoluogoProvincia;

	@Lob
	@Column(name="codice_catastale", nullable=false)
	private String codiceCatastale;

	@Column(nullable=false, precision=10, scale=6)
	private BigDecimal latitudine;

	@Column(nullable=false, precision=10, scale=6)
	private BigDecimal longitudine;

	@Lob
	@Column(nullable=false)
	private String nome;

	//uni-directional many-to-one association to Provincia
	@ManyToOne
	@JoinColumn(name="id_provincia", nullable=false)
	private Provincia provincia;

	//uni-directional many-to-one association to Regione
	@ManyToOne
	@JoinColumn(name="id_regione", nullable=false)
	private Regione regione;

	public Comune() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCapoluogoProvincia() {
		return this.capoluogoProvincia;
	}

	public void setCapoluogoProvincia(Integer capoluogoProvincia) {
		this.capoluogoProvincia = capoluogoProvincia;
	}

	public String getCodiceCatastale() {
		return this.codiceCatastale;
	}

	public void setCodiceCatastale(String codiceCatastale) {
		this.codiceCatastale = codiceCatastale;
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

	public Provincia getProvincia() {
		return this.provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Regione getRegione() {
		return this.regione;
	}

	public void setRegione(Regione regione) {
		this.regione = regione;
	}

}