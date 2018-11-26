package com.shops.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ville implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idVille;
	@Column(unique=true)
	private String nomVille;
	
	public Ville() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ville(String nomVille) {
		super();
		this.nomVille = nomVille;
	}

	public long getIdVille() {
		return idVille;
	}

	public void setIdVille(long idVille) {
		this.idVille = idVille;
	}

	public String getNomVille() {
		return nomVille;
	}

	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	
	
}
