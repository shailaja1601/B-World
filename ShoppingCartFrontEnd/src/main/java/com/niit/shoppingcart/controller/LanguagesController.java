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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.LanguagesDAO;
import com.niit.shoppingcart.model.Authors;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Languages;
import com.niit.shoppingcart.util.FileUtil;

@Controller
public class LanguagesController {
	
	private static final Logger logger=LoggerFactory.getLogger(LanguagesController.class);
    @Autowired
    Languages languages;
    @Autowired
    LanguagesDAO languagesDAO;
	
	@RequestMapping(value="/manageLanguages",method=RequestMethod.GET)
	public String listLanguages (Model model){
		logger.debug("Method START:listLanguages");
		languages.languagesClear();
		model.addAttribute("languages",languages);
		model.addAttribute("languagesList",this.languagesDAO.list());
		model.addAttribute("languagesAdd",true);
		model.addAttribute("isAdminClickedLanguages","true");
		logger.debug("Method END:listLanguages");
		return "/index";
	 }
	
	 @RequestMapping(value="/manage_languages_add",method=RequestMethod.POST)
	    public  String addLanguages(@ModelAttribute("languages")Languages languages,Model model){
		        
	    	   	if(languagesDAO.saveOrUpdate(languages)==true)
	    	{
	    	
	    		model.addAttribute("msg", "Successfully added language");
	    		languages.languagesClear();
	    	}
	    	else
	    	{
	    	 model.addAttribute("msg","ID already exist");	
	    	}
	    	model.addAttribute("languages", languages);
	    	model.addAttribute("languagesList",languagesDAO.list());
	    	model.addAttribute("isAdminClickedLanguages", "true");
	    	return "/index";
	    }
	 
	 @RequestMapping(value="/manage_languages_remove")
	    public String deleteLanguages(@RequestParam("id") String id,Model model) throws Exception{
	    	boolean flag=languagesDAO.delete(id);
	    	 String msg="Successfully done the opertion";
	    	 if(flag!=true){
	    		 msg="The opertion could not success";
	    		 languages.languagesClear();
	    	 }
	        model.addAttribute("msg", msg);
	    	return "forward:/manageLanguages";
	    }
	 
	 @RequestMapping(value="/manage_languages_update",method=RequestMethod.POST)
	   public  String updateLanguage(@ModelAttribute("languages") Languages languages,Model model){
	   	   	
	   	   	
	   	   	
	        if(languagesDAO.update(languages)==true)
	   	{
	       	
	   		model.addAttribute("msg", "Successfully");
	   		languages.languagesClear();
	   	}
	   	else
	   	{
	   		
	   	 model.addAttribute("msg", "operation failed");	
	   	}
	   	model.addAttribute("languages", languages);
	   	model.addAttribute("languagesList",this.languagesDAO.list());
			model.addAttribute("languages",new Languages());

	   	model.addAttribute("isAdminClickedLanguages", "true");
	   	return "/index";
	   }

	   

	    
	    
	    @RequestMapping(value="/manage_languages_edit")
	    public String editLanguages(@RequestParam("id") String id,Model model)
	    {
	    	languages=languagesDAO.get(id);
	    	
	    	model.addAttribute("languages",languages);
			model.addAttribute("languagesList",this.languagesDAO.list());
			model.addAttribute("languagesAdd",false);
			model.addAttribute("isAdminClickedLanguages","true");
	    	return "index";
	    }
	   
	    @RequestMapping(value="/open_select_language")
		 public ModelAndView getSelectedLanguage(@RequestParam("id")String language){
			 
			 ModelAndView mv=new ModelAndView("/index");
			 mv.addObject("language",language);
			 mv.addObject("languagesList",this.languagesDAO.list());
			 return mv;
		 }
	    
}
