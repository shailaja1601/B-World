package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.AuthorsDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.LanguagesDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Authors;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Languages;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;

@Controller
public class HomeController {
private static final Logger logger=LoggerFactory.getLogger(HomeController.class);
	@Autowired
	User user;
	@Autowired
	UserDAO userDAO;
	@Autowired
	private Category category;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private Product product;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private Supplier supplier;
	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired
	private Authors authors;
	@Autowired
	private AuthorsDAO authorsDAO;
	@Autowired
	private Languages languages;
	@Autowired
	private LanguagesDAO languagesDAO;
	
	@RequestMapping(value={"/","/home"})
	public ModelAndView gotoHome(HttpSession session,Model model) {
		logger.debug("Method START:gotoHome");
		ModelAndView mv = new ModelAndView("index");
		session.setAttribute("category", category);
		List<Category> categoryList = categoryDAO.list();
		session.setAttribute("categoryList", categoryList);
		
		session.setAttribute("product", product);
		List<Product> productList = productDAO.list();
	    session.setAttribute("productList", productList);
		session.setAttribute("newArrivalsList",productDAO.arrivalsList());

		
		session.setAttribute("supplier", supplier);
		List<Supplier> supplierList=supplierDAO.list();
		session.setAttribute("supplierList", supplierList);
		
		session.setAttribute("authors", authors);
		List<Authors> authorsList=authorsDAO.list();
		session.setAttribute("authorsList", authorsList);
		
		session.setAttribute("languages", languages);
		List<Languages> languagesList=languagesDAO.list();
		session.setAttribute("languagesList", languagesList);
		
		model.addAttribute("loadHome","true");
		logger.debug("Method END:gotoHome");
		return mv;
	}

	
	@RequestMapping("/Logout")
	public ModelAndView logout(HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		logger.debug("Starting of method logout");
		ModelAndView mv=new ModelAndView("index");
		//session.invalidate();//will remove the attributes which are added to session
		session=request.getSession(true);
		session.setAttribute("category", category);
		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("supplier", supplier);
		session.setAttribute("supplierList", supplierDAO.list());
		session.setAttribute("product", product);
		session.setAttribute("productList", productDAO.list());
		session.setAttribute("authors", authors);
		session.setAttribute("authorsList", authorsDAO.list());
		session.setAttribute("languages", languages);
		session.setAttribute("languagesList", languagesDAO.list());
        mv.addObject("logoutMessage","You successfully logged out");
        mv.addObject("loggedOut","true");
       /* Authentication auth=SecurityContextHolder.getContext().getAuthentication();
        if(auth!=null){
        	new SecurityContextLogoutHandler().logout(request, response,auth);
        }*/
		logger.debug("Ending of method logout");
		return mv;
	}

		@RequestMapping("/Login")
	public String login(Model model) {
			logger.debug("Method STARTED:Login of mapping /Login");
		model.addAttribute("user", user);
		model.addAttribute("UserClickedLogin", "true");
		logger.debug("Method END:Login of mapping /Login");
		return "index";
	}

	@RequestMapping("/register")
	public String resigter(Model model) {
		logger.debug("Method STARTED:Login of mapping /register");
		model.addAttribute("user", user);
		model.addAttribute("UserClickedRegister", "true");
		logger.debug("Method END:Login of mapping /register");
		return "index";
		
	}
	
	@RequestMapping("/aboutUs")
	public String aboutUs(Model model) {
			logger.debug("Method STARTED: mapping /aboutUs");
		model.addAttribute("user", user);
		model.addAttribute("UserClickedAboutUs", "true");
		logger.debug("Method END: mapping /aboutUs");
		return "index";
	}
	
	@RequestMapping("/contactUs")
	public String contactUs(Model model) {
			logger.debug("Method STARTED: mapping /contactUs");
		model.addAttribute("user", user);
		model.addAttribute("UserClickedContactUs", "true");
		logger.debug("Method END: mapping /contactUs");
		return "index";
	}	
}
