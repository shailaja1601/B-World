package com.niit.shoppingcart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.AuthorsDAO;
import com.niit.shoppingcart.model.Authors;

@Controller
public class AuthorsController {
	private static final Logger logger=LoggerFactory.getLogger(AuthorsController.class);
  
	@Autowired
	Authors authors;
	@Autowired
	AuthorsDAO authorsDAO;
	
	@RequestMapping(value="/manageAuthors",method=RequestMethod.GET)
	public String listAuthors (Model model){
		logger.debug("Method START:listAuthors");
		model.addAttribute("authors",authors);
		model.addAttribute("authorsList",this.authorsDAO.list());
		model.addAttribute("authorsAdd",true);
		model.addAttribute("isAdminClickedAuthors","true");
		logger.debug("Method END:listAuthors");
		return "/index";
	 }
	
	 @RequestMapping(value="/manage_authors_add",method=RequestMethod.POST)
	    public  String addAuthors(@ModelAttribute("authors")Authors authors,Model model){
	    	   	if(authorsDAO.saveOrUpdate(authors)==true)
	    	{
	    	   	
	    		model.addAttribute("msg", "Successfully added Author");
	    	}
	    	else
	    	{
	    		
	    	 model.addAttribute("msg", "ID already exist");	
	    	}
	    	model.addAttribute("authors", authors);
	    	model.addAttribute("authorsList",authorsDAO.list());
	    	model.addAttribute("isAdminClickedAuthors", "true");
	    	return "/index";
	    }
	 
	 @RequestMapping(value="/manage_authors_update",method=RequestMethod.POST)
	   public  String updateAuthors(@ModelAttribute("authors") Authors authors,Model model){
	   	   	
	   	   	
	   	   	
	        if(authorsDAO.update(authors)==true)
	   	{
	       	
	   		model.addAttribute("msg", "Successfully");
	   	}
	   	else
	   	{
	   		
	   	 model.addAttribute("msg", "operation failed");	
	   	}
	   	model.addAttribute("authors", authors);
	   	model.addAttribute("authorsList",this.authorsDAO.list());
			model.addAttribute("authors",new Authors());

	   	model.addAttribute("isAdminClickedAuthors", "true");
	   	return "/index";
	   }

	 
	 @RequestMapping("/manage_authors_remove")
	    public String deleteAuthors(@RequestParam("author") String author,Model model) throws Exception{
	    	boolean flag=authorsDAO.delete(author);
	    	
	    	 String msg="Successfully done the opertion";
	    	 if(flag!=true){
	    		 msg="The opertion could not success";
	    	 }
	        model.addAttribute("msg", msg);
	    	return "forward:/manageAuthors";
	    }
	    
	    
	    @RequestMapping(value="/manage_authors_edit")
	    public String editAuthors(@RequestParam("id") String id,Model model)
	    {
	    	authors=authorsDAO.get(id);
	    	
	    	model.addAttribute("authors",authors);
			model.addAttribute("authorsList",this.authorsDAO.list());
			model.addAttribute("authorsAdd",false);
			model.addAttribute("isAdminClickedAuthors","true");
			return "index";
	    }
	   
	    @RequestMapping(value="/open_select_author")
		 public ModelAndView getSelectedAuthor(@RequestParam("id")String author){
			 
			 ModelAndView mv=new ModelAndView("/index");
			 mv.addObject("author",author);
			 mv.addObject("authorsList",this.authorsDAO.list());
			 return mv;
		 }
	    

}
