package com.shops.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shops.beans.Ville;
import com.shops.dao.VilleDao;

@RestController
public class VilleController {
	@Autowired
	VilleDao villeDao;
	@RequestMapping(value="/cities", method=RequestMethod.GET)
	public List<Ville> getAllCities(){
		return villeDao.findAll();
	}
}
