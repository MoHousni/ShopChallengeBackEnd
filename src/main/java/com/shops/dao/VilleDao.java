package com.shops.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shops.beans.Ville;

public interface VilleDao extends JpaRepository<Ville, Long> {
	Ville findByNomVille(String nomVille);
}
