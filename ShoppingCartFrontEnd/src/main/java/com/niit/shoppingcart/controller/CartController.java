package com.niit.shoppingcart.controller;

import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Product;

@Controller
public class CartController {
	private static final Logger logger=LoggerFactory.getLogger(CartController.class);

	@Autowired
	private Cart cart;
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private Product product;
	
	
	@RequestMapping(value="/cart")
	public String cart(Model model,HttpSession session){
		logger.debug("Starting of the method Cart");
		model.addAttribute("cart",new Cart());
		String loggedInUserMailID=(String)session.getAttribute("loggedInUserMailID");
		/*if(loggedInUserID==null){
			 
		 }*/
		int cartSize=cartDAO.getbyUser(loggedInUserMailID).size();
		
		if(cartSize==0){
			model.addAttribute("errorMessagecart","Empty cart");
		}
		else{
			model.addAttribute("cartList",cartDAO.getbyUser(loggedInUserMailID));
			model.addAttribute("totalAmount",cartDAO.getTotalAmount(loggedInUserMailID));
			model.addAttribute("displayCart",true);

		}
		logger.debug("Ending of the method Cart");
	return "index";	
	}
	
	@RequestMapping(value="/card_add",method = RequestMethod.GET)
	public ModelAndView addToCart(@RequestParam("productName") String productName , HttpSession session)
	{
		logger.debug("Starting of the method addToCart");
		
		//get the product based on product name
		Product product =productDAO.get(productName);
	    cart.setPrice(product.getPrice());
		
		cart.setProductName(product.getProductName());
		cart.setQuantity(1);
		
		
		String loggedInUserMailID = (String)session.getAttribute("loggedInUserMailID");
		
		/*if(loggedInUserid == null)
		{
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			loggedInUserid =auth.getName();
		}*/
		
	
		cart.setUserMailId(loggedInUserMailID);
	    cart.setId(ThreadLocalRandom.current().nextInt(100, 1000000 + 1));
	
	
	cartDAO.save(cart);
	
	ModelAndView mv = new ModelAndView("/index");
	mv.addObject("successMessage"," Successfully add the product to Cart");
	logger.debug("Ending of the method addToCart");
    return mv;
	}
	
	@RequestMapping("/cart_delete")
	public String removeCart(@RequestParam("id") int id, Model model) throws Exception
	{
		logger.debug("Starting of the method removeCart");
		try{
			
			cartDAO.delete(id);
			model.addAttribute("successMessage" , "Successfully Removed from your cart");
			}
		catch(Exception e)
		{
			model.addAttribute("message" , e.getMessage());
			e.printStackTrace();
		}
		logger.debug("Ending of the method removeCart");
		return "redirect:/index";
	}

 

}
