package com.niit.shoppingcart.controller;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;

@Controller
public class UserController {
	private static final Logger logger=LoggerFactory.getLogger(HomeController.class);
@Autowired
User user;
@Autowired
UserDAO userDAO;
@Autowired
Supplier supplier;
@Autowired
SupplierDAO supplierDAO;
@Autowired
Category category;
@Autowired
CategoryDAO categoryDAO;
@Autowired
Product product;
@Autowired
ProductDAO productDAO;
@Autowired
Cart cart;
@Autowired
CartDAO cartDAO;
@RequestMapping("/validate")
public ModelAndView login(HttpSession session){
	logger.debug("START Method:login");
	
	
	ModelAndView mv=new ModelAndView("/index");
	//user=userDAO.isValidUser(usermailId, password);//if this record exist with this user name and password it will be returned to user
	 Authentication auth=SecurityContextHolder.getContext().getAuthentication();
	 String mailID=null;
     if(auth!=null){
     	mailID=auth.getName();
     }
     	user=userDAO.get(mailID);

	if(user!=null)
	{
		logger.debug("valid User");
		user=userDAO.get(mailID);
		
		mv.addObject("UserLoggedIn","true");
		session.setAttribute("loggedInUser", user.getName());
		session.setMaxInactiveInterval(600);
		session.setAttribute("loggedInUserID", user.getId());
		session.setAttribute("loggedInUserMailID",user.getMail() );

		session.setAttribute("user", user);
		
		if(user.getRole().equals("ROLE_ADMIN"))
		{
			logger.debug("Logged in as ADMIN");
			
			session.setAttribute("isAdmin","true");
			session.setAttribute("supplier", supplier);
			session.setAttribute("supplierDAO", supplierDAO);
			session.setAttribute("category", category);
			session.setAttribute("categoryDAO", categoryDAO);
			session.setAttribute("product", product);
			session.setAttribute("productDAO", productDAO);
			
		}else{
			logger.debug("Logged in as USER");
			session.setAttribute("isAdmin","false");
			
			//cart=cartDAO.get(0);
			//mv.addObject("cart",cart);
			List<Cart> cartList=cartDAO.getbyUser(mailID);
			/*mv.addObject("cartList",cartList);
			mv.addObject("cartSize",cartList.size());*/
			session.setAttribute("cartList",cartList);
			session.setAttribute("cartSize",cartList.size());
			}
			}
		
	logger.debug("END of method:login");
		return mv;
}
    @RequestMapping(value="/register_form",method=RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute User user){
    	logger.debug("Starting of registerUser method");
    	 ModelAndView mv=new ModelAndView("index");  //if(userDAO.get(user.getId())==null)
    	 if(userDAO.get(user.getMail())==null){
    		 user.setRole("ROLE_USER");//all the user's role will by default set Role_user
    		   user.setId(ThreadLocalRandom.current().nextInt(100, 1000000 + 1));
         
    		 userDAO.saveOrUpdate(user);
    		 logger.debug("You are successfully registered");
    		 mv.addObject("successMessageforUser","You are successfully registered");
    	 }else{
    		 logger.debug("User exist with this mail-id");
    		 mv.addObject("errorMessageforUser","User exist with this mail-id");
    		 }
    	logger.debug("Ending of registerUser method");
        return mv;
    }
    @RequestMapping(value="/loginError",method=RequestMethod.GET)
    public String loginError(Model model){
    	model.addAttribute("errorMessage", "Login Error");
    	return "index";
    }
    
    @RequestMapping(value="/accessDenied",method=RequestMethod.GET)
    public String accessDenied(Model model){
    	model.addAttribute("errorMessage", "You are not authorized to access this page");
    	return "index";
    }
    
    }



















