package com.example.database.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the regioni database table.
 * 
 */
@Entity
@Table(name="regioni")
@NamedQuery(name="Regione.findAll", query="SELECT r FROM Regione r")
public class Regione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(updatable=false, unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, precision=10, scale=6)
	private BigDecimal latitudine;

	@Column(nullable=false, precision=10, scale=6)
	private BigDecimal longitudine;

	@Lob
	@Column(nullable=false)
	private String nome;

	//bi-directional many-to-one association to Provincia
	@OneToMany(mappedBy="regione")
	private List<Provincia> province;

	public Regione() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<Provincia> getProvince() {
		return this.province;
	}

	public void setProvince(List<Provincia> province) {
		this.province = province;
	}

	public Provincia addProvince(Provincia province) {
		getProvince().add(province);
		province.setRegione(this);

		return province;
	}

	public Provincia removeProvince(Provincia province) {
		getProvince().remove(province);
		province.setRegione(null);

		return province;
	}

}