package com.shops.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shops.beans.Role;
import com.shops.beans.Shops;
import com.shops.beans.User;
import com.shops.dao.RoleDao;
import com.shops.dao.ShopsDao;
import com.shops.dao.UserDao;
import com.shops.dao.VilleDao;


@RestController
public class UserController {
	
	private User user;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	VilleDao villeDao;
	
	@Autowired
	RoleDao roleDao;
	
	@Autowired
	ShopsDao shopsDao;
	
	@Autowired
    protected AuthenticationManager authenticationManager;
	
	 @RequestMapping("/user")
	  public Principal user(Principal user) {
	    return user;
	  }
	 
	 @RequestMapping(value = "/singup", method=RequestMethod.POST)
	 public Principal singup(@RequestBody User user, HttpServletRequest request) {
		 String password = user.getPassword();
		 user.setVille(villeDao.findByNomVille(user.getVille().getNomVille()));
		 PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(5);
		 user.setPassword(passwordEncoder.encode(user.getPassword()));
		 Role role = new Role("user", user.getEmail());
		try {
			 userDao.save(user);
			 roleDao.save(role);
			 authenticateUserAndSetSession(user, password, request);
			 Principal principal = request.getUserPrincipal();
			 this.user = user;
			 return principal;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("save User error");
			return null;
		}
	 }
	 
	 private void authenticateUserAndSetSession(User user,String password, HttpServletRequest request) {
	        String email = user.getEmail();
	        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, password);

	        // generate session if one doesn't exist
	        request.getSession();

	        token.setDetails(new WebAuthenticationDetails(request));
	        Authentication authenticatedUser = authenticationManager.authenticate(token);

	        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
	    }
	 
	 @GetMapping(value="/home")
	 @PreAuthorize("hasRole('ROLE_USER')")
	 public List<Shops> home(HttpServletRequest request){
		 Principal principal = request.getUserPrincipal();
		 this.user = userDao.findByEmail(principal.getName());
		 
		 System.out.println(user.getShopsLike().get(0).getUsersLikeMe().get(0).getEmail());
		 return shopsDao.getShopsNotLikedYet(user.getIdUser(),user.getVille().getNomVille());
	 }
	 
	 @PostMapping(value="/like")
	 @PreAuthorize("hasRole('ROLE_USER')")
	 public User like(@RequestBody Shops shops, HttpServletRequest request) {
		 Principal principal = request.getUserPrincipal();
		 this.user = userDao.findByEmail(principal.getName());
		 user.setShopLike(shops);
		 userDao.save(user);
		 return user;
	 }
	 
	 @GetMapping("/liked")
	 @PreAuthorize("hasRole('ROLE_USER')")
	 public List<Shops> liked(HttpServletRequest request){
		 

		 if(this.user == null) {
			 Principal principal = request.getUserPrincipal();
			 this.user = userDao.findByEmail(principal.getName());
		 }
		 
		 return shopsDao.findDistinctByUsersLikeMeIdUser(this.user.getIdUser());
		 
	 }
	 
	 @DeleteMapping("/remove/{id}")
	 @PreAuthorize("hasRole('ROLE_USER')")
	 public Boolean removeLikedShop(@PathVariable long id, HttpServletRequest request) {

		Principal principal = request.getUserPrincipal();
		this.user = userDao.findByEmail(principal.getName());

		 Shops shops = shopsDao.findById(id).get();
		 if( shops == null) {
			 return false;
		 }
		 int index = 0;
		 for (Shops s : user.getShopsLike()) {
			if( s.getIdShop() == shops.getIdShop()) {
				break;
			}
			index++;
		}
		 user.getShopsLike().remove(index);
		 try {
			 userDao.save(user);
			 return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;
		}
		 
	 }
}
