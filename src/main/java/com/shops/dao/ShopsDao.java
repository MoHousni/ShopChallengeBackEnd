package com.shops.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shops.beans.Shops;

public interface ShopsDao extends JpaRepository<Shops, Long> {
	List<Shops> findByVilleNomVille(String nomVille);
	
	@Query("select s from  Shops s left join s.usersLikeMe sul on sul.idUser =:y where sul.idUser <> :y or sul.idUser is null and s.ville.nomVille=:x")
	public List<Shops> getShopsNotLikedYet(@Param("y") long idUser,@Param("x") String nomVille);
	
	List<Shops> findDistinctByUsersLikeMeIdUser(long idUser);
}
