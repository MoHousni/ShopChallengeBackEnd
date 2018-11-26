package com.shops.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idUser;
	@Column(nullable=false, unique=true)
	private String email;
	@Column(nullable=false)
	private String fullName;
	@Column(nullable=false)
	private String password;
	
	@ManyToOne
	@JoinColumn(name="VilleId")
	private Ville ville;
	
	@JsonIgnore
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="liked",
	joinColumns=@JoinColumn(name="idUser"),
	inverseJoinColumns=@JoinColumn(name="idShop"))
	private List<Shops> shopsLike = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="notLiked",
	joinColumns=@JoinColumn(name="idUser"),
	inverseJoinColumns=@JoinColumn(name="idShop"))
	private List<Shops> shopsDislike = new ArrayList<>();
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(String email, String fullName, String password, Ville ville) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.password = password;
		this.ville = ville;
	}

	
	public long getIdUser() {
		return idUser;
	}


	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Shops> getShopsLike() {
		return shopsLike;
	}


	public void setShopsLike(List<Shops> shopsLike) {
		this.shopsLike = shopsLike;
	}
	
	
	public void setShopLike(Shops shopsLike) {
		this.shopsLike.add(shopsLike);
	}


	public List<Shops> getShopsDislike() {
		return shopsDislike;
	}


	public void setShopsDislike(List<Shops> shopsDislike) {
		this.shopsDislike = shopsDislike;
	}


	public Ville getVille() {
		return ville;
	}


	public void setVille(Ville ville) {
		this.ville = ville;
	}
	
	
}
