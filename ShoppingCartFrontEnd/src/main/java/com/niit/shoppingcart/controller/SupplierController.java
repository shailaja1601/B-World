package com.niit.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

@Controller
public class SupplierController {
	
	@Autowired
	private Supplier supplier;
	@Autowired
	private SupplierDAO supplierDAO;
	
	@RequestMapping(value="/manageSupplier",method=RequestMethod.GET)
	public String listSupplier(Model model){

		model.addAttribute("supplier",supplier);
		model.addAttribute("supplierList",supplierDAO.list());
		model.addAttribute("supplierAdd",true);
		model.addAttribute("isAdminClickedSupplier","true");
		return "/index";
	 }
	 @RequestMapping(value="/manage_supplier_add",method=RequestMethod.POST)
	    public  String addSupplier(@ModelAttribute("supplier")Supplier supplier,Model model){
	    	   	if(supplierDAO.saveOrUpdate(supplier)==true)
	    	{
	    	   	//categoryDAO.saveOrUpdate(category);	
	    		model.addAttribute("msg", "Successfully created the supplier");
	    		supplier.supplierclear();
	    	}
	    	else
	    	{
	    		//categoryDAO.update(category);	
	    	 model.addAttribute("msg", "Id already exist");	
	    	}
	    	model.addAttribute("supplier", supplier);
	    	model.addAttribute("supplierList",supplierDAO.list());
	    	model.addAttribute("isAdminClickedSupplier", "true");
	    	return "/index";
	    }
	  
	   
	    @RequestMapping(value="/manage_supplier_update",method=RequestMethod.POST)
	    public String updateCategory(@ModelAttribute("supplier")Supplier supplier,Model model){
	    	if(supplierDAO.update(supplier)==true)
	    	{
	    		model.addAttribute("msg", "Successfully update the supplier");
	    		supplier.supplierclear();
	    	}
	    	else
	    	{
	    	 model.addAttribute("msg", "not able to update the supplier");	
	    	}
	    	model.addAttribute("supplier", supplier);
	    	model.addAttribute("supplierList", this.supplierDAO.list());
	    	model.addAttribute("isAdminClickedSupplier", "true");
	    	return "/index";
	    }
	    
	 
	 
	    @RequestMapping(value="/manage_supplier_remove")
	    public String deleteSupplier(@RequestParam("id") String id,Model model) throws Exception{
	    	boolean flag=supplierDAO.delete(id);
	    	 String msg="Successfully done the opertion";
	    	 supplier.supplierclear();
	    	 if(flag!=true){
	    		 msg="The opertion could not success";
	    		 
	    	 }
	        model.addAttribute("msg", msg);
	    	return "forward:/manageSupplier";
	    }
	    
	    
	    @RequestMapping(value="/manage_supplier_edit")
	    public String editSupplier(@RequestParam("id") String id,Model model)
	    {
	    	supplier=supplierDAO.get(id);
	    	model.addAttribute("supplier",supplier);
			model.addAttribute("supplierList",supplierDAO.list());
			model.addAttribute("supplierAdd",false);
			model.addAttribute("isAdminClickedSupplier","true");
			return "/index";
	    }
	   
	    
	

}
