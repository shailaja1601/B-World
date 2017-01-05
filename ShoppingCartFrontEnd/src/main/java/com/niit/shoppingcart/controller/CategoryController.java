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

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.util.FileUtil;

@Controller
public class CategoryController {
	private static final Logger logger=LoggerFactory.getLogger(CategoryController.class);

    @Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private Category category;
	
	private String path="C:\\Users\\sumeet\\Desktop\\spring_project\\ShoppingCartFrontEnd\\src\\main\\webapp\\lib\\image\\categoryImage";

	
	@RequestMapping(value="/manageCategories",method=RequestMethod.GET)
	public String listCategory (Model model){
		 category.clear();
		model.addAttribute("category",category);
		model.addAttribute("categoryList",categoryDAO.list());
		model.addAttribute("categoryAdd",true);
		model.addAttribute("isAdminClickedCategories","true");
		return "/index";
	 }
	
	
   @RequestMapping(value="/manage_category_add",method=RequestMethod.POST)
    public  String addCategory(@ModelAttribute("category") Category category,@RequestParam("image") MultipartFile file,Model model){
    	   	
    	   	
    	   	
         if(categoryDAO.saveOrUpdate(category)==true)
    	{
        	 FileUtil.upload(path, file, category.getCategoryId()+".jpg");
    		model.addAttribute("msg", "Successfully");
    		 category.clear();
    	}
    	else
    	{
    		
    	 model.addAttribute("msg", "operation failed");	
    	}
    	model.addAttribute("category", category);
    	model.addAttribute("categoryList",this.categoryDAO.list());
		model.addAttribute("category",new Category());

    	model.addAttribute("isAdminClickedCategory", "true");
    	return "/index";
    }
      
   
   @RequestMapping(value="/manage_category_update",method=RequestMethod.POST)
   public  String updateCategory(@ModelAttribute("category") Category category,@RequestParam("image") MultipartFile file,Model model){
   	   	
   	   	
   	   	
        if(categoryDAO.update(category)==true)
   	{
       	 FileUtil.upload(path, file, category.getCategoryId()+".jpg");
   		model.addAttribute("msg", "Successfully");
   	 category.clear();
   	}
   	else
   	{
   		
   	 model.addAttribute("msg", "operation failed");	
   	}
   	model.addAttribute("category", category);
   	model.addAttribute("categoryList",this.categoryDAO.list());
		model.addAttribute("category",new Category());

   	model.addAttribute("isAdminClickedCategory", "true");
   	return "/index";
   }

   
   
    @RequestMapping(value="/manage_category_remove")
    public String deleteCategory(@RequestParam("categoryName") String categoryName,Model model) throws Exception{
    	boolean flag=categoryDAO.delete(categoryName);
    	 String msg="Successfully done the opertion";
    	 if(flag!=true){
    		 msg="The opertion could not success";
    	 }
        model.addAttribute("msg", msg);
    	return "forward:/manageCategories";
    }
    
    
    @RequestMapping(value="/manage_category_edit")
    public String editCategory(@RequestParam("id") String id,Model model)
    {
    	category=categoryDAO.get(id);
    	
    	model.addAttribute("category", category);
    	model.addAttribute("categoryList",categoryDAO.list());
		model.addAttribute("categoryAdd",false);
		model.addAttribute("isAdminClickedCategories","true");
		return "/index";
    }
  
}
