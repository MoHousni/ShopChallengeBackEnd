package com.shops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.shops.beans.Shops;
import com.shops.beans.Ville;
import com.shops.dao.ShopsDao;
import com.shops.dao.VilleDao;

@SpringBootApplication
public class ShopsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ShopsApplication.class, args);
		
		/*VilleDao villeDao = ctx.getBean(VilleDao.class);
		ShopsDao shopsDao = ctx.getBean(ShopsDao.class);
		
		Ville ville = new Ville("Agadir");
		villeDao.save(ville);
		shopsDao.save(new Shops("AgadirShop", "01.png", "Clothes Shop" , "Hay Salam", ville));
		shopsDao.save(new Shops("AgadirShop", "01.png", "Clothes Shop" , "Hay Salam", ville));
		shopsDao.save(new Shops("AgadirShop", "01.png", "Clothes Shop" , "Hay Salam", ville));
		shopsDao.save(new Shops("AgadirShop", "01.png", "Clothes Shop" , "Hay Salam", ville));
		shopsDao.save(new Shops("AgadirShop", "01.png", "Clothes Shop" , "Hay Salam", ville));
		shopsDao.save(new Shops("AgadirShop", "01.png", "Clothes Shop" , "Hay Salam", ville));
		
		ville = new Ville("Casablanca");
		villeDao.save(ville);
		shopsDao.save(new Shops("CasablancaShop", "02.png", "Clothes Shop" , "Technopark (hh)",  ville));
		
		ville = new Ville("Rabat");
		villeDao.save(ville);
		shopsDao.save(new Shops("RabatShop", "03.png", "Clothes Shop" , "Souk Bab L7ed",  ville));
		
		ville = new Ville("Marrakesh");
		villeDao.save(ville);
		shopsDao.save(new Shops("MarrakeshShop", "04.png", "Clothes Shop" , "Hay Zitoune",  ville));
		*/
		
	}
}
