package com.shops.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Shops implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idShop;
	private String nameShop;
	private String imageShop;
	private String description;
	private String address;
	
	@ManyToOne
	@JoinColumn(name="VilleId")
	private Ville ville;
	
	@JsonIgnore
	@ManyToMany(mappedBy="shopsLike")
	private List<User> usersLikeMe =  new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(mappedBy="shopsDislike")
	private List<User> usersDislikeMe =  new ArrayList<>();


	public Shops(String nameShop, String imageShop, String description, String address, Ville ville) {
		super();
		this.nameShop = nameShop;
		this.imageShop = imageShop;
		this.description = description;
		this.address = address;
		this.ville = ville;
	}


	public Shops() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getIdShop() {
		return idShop;
	}


	public void setIdShop(long idShop) {
		this.idShop = idShop;
	}


	public String getNameShop() {
		return nameShop;
	}


	public void setNameShop(String nameShop) {
		this.nameShop = nameShop;
	}


	public String getImageShop() {
		return imageShop;
	}


	public void setImageShop(String imageShop) {
		this.imageShop = imageShop;
	}


	public Ville getVille() {
		return ville;
	}


	public void setVille(Ville ville) {
		this.ville = ville;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public List<User> getUsersLikeMe() {
		return usersLikeMe;
	}


	public void setUsersLikeMe(List<User> usersLikeMe) {
		this.usersLikeMe = usersLikeMe;
	}

	
	public void setUserLikeMe(User usersLikeMe) {
		this.usersLikeMe.add(usersLikeMe);
	}
	

	public List<User> getUsersDislikeMe() {
		return usersDislikeMe;
	}


	public void setUsersDislikeMe(List<User> usersDislikeMe) {
		this.usersDislikeMe = usersDislikeMe;
	}
	
	
	public void setUserDislikeMe(User usersDislikeMe) {
		this.usersDislikeMe.add(usersDislikeMe);
	}
	
	
}
