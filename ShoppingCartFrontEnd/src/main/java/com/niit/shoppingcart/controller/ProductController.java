package com.niit.shoppingcart.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shoppingcart.dao.AuthorsDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.LanguagesDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Authors;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Languages;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.util.FileUtil;

@Controller
public class ProductController {
	private static final Logger logger=LoggerFactory.getLogger(ProductController.class);
	@Autowired(required= true)
	private Product product;
	@Autowired(required= true)
	private ProductDAO productDAO;
	@Autowired(required= true)
	private Category category;
	@Autowired(required= true)
	private CategoryDAO categoryDAO;
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
	
	private String path="C:\\Users\\sumeet\\Desktop\\spring_project\\ShoppingCartFrontEnd\\src\\main\\webapp\\lib\\image\\productImage";
	
	@RequestMapping(value="/manageProducts",method=RequestMethod.GET)
	public String listProduct (Model model){
		logger.debug("Method START:listProduct");
		model.addAttribute("product",product);
		model.addAttribute("productList",this.productDAO.list());
		model.addAttribute("isAdminClickedProduct","true");
		model.addAttribute("productAdd",true);
		product.productClear();
		logger.debug("Method END:listProduct");
		return "/index";
	 }
	
	
	@RequestMapping(value="/manage_product_add",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("product")Product product,@RequestParam("image") MultipartFile file,Model model ){
		logger.debug("Method START:addProduct");

		Category category=categoryDAO.getByName(product.getCategory().getCategoryName());
	   	Supplier supplier=supplierDAO.getByName(product.getSupplier().getSupplierName());
	   	Authors authors=authorsDAO.getByName(product.getAuthors().getAuthor());
	   	Languages languages=languagesDAO.getByName(product.getLanguages().getLanguage());
	  
		
	   	product.setCategory(category);
	   	product.setCategoryID(category.getCategoryId());
		
		product.setSupplier(supplier);
		product.setSupplierID(supplier.getSupplierId());
		
		product.setAuthors(authors);
		product.setAuthorID(authors.getAuthorsId());
		
		product.setLanguages(languages);
		product.setLanguageID(languages.getId());
		
		
		
		productDAO.saveOrUpdate(product);
		
		FileUtil.upload(path, file, product.getProductId()+".jpg");
		logger.debug("Method END:addProduct");
		model.addAttribute("isAdminClickedProduct","true");
		model.addAttribute("productList",this.productDAO.list());
		model.addAttribute("product",new Product());
		product.productClear();
		return "/index";
	}
	
	@RequestMapping(value="/manage_product_update",method=RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product")Product product,Model model ){
		logger.debug("Method START:addProduct");

		Category category=categoryDAO.getByName(product.getCategory().getCategoryName());
	   	Supplier supplier=supplierDAO.getByName(product.getSupplier().getSupplierName());
	   	Authors authors=authorsDAO.getByName(product.getAuthors().getAuthor());
	   	Languages languages=languagesDAO.getByName(product.getLanguages().getLanguage());
	  
		
	   	product.setCategory(category);
	   	product.setCategoryID(category.getCategoryId());
		
		product.setSupplier(supplier);
		product.setSupplierID(supplier.getSupplierId());
		
		product.setAuthors(authors);
		product.setAuthorID(authors.getAuthorsId());
		
		product.setLanguages(languages);
		product.setLanguageID(languages.getId());
	
		productDAO.update(product);
		
		/*FileUtil.upload(path, file, product.getProductId()+".jpg");*/
		logger.debug("Method END:addProduct");
		model.addAttribute("isAdminClickedProduct","true");
		model.addAttribute("productList",this.productDAO.list());
		model.addAttribute("product",new Product());
		product.productClear();
		return "/index";
	}
	
	
	@RequestMapping(value="/manage_product_remove")
    public String deleteProduct(@RequestParam("productId") String productId,Model model)throws Exception{
		boolean flag=productDAO.delete(productId);
   	 String msg="Successfully done the opertion";
   	if(flag!=true){
		 msg="The opertion could not success";
	 }
   model.addAttribute("msg", msg);
	return "forward:/manageProducts";
}
	 @RequestMapping(value="/manage_product_edit")
	    public String editProduct(@RequestParam("productName") String productName,Model model)
	    {
	    	product=productDAO.get(productName);
	    	
	    	model.addAttribute("product",product);
			model.addAttribute("productList",this.productDAO.list());
			model.addAttribute("isAdminClickedProduct","true");
			model.addAttribute("productAdd",false);
			
	    	return "index";
	    }	 
	 
	 @RequestMapping(value="/show_product")
	  public ModelAndView getSelectedProduct(@RequestParam("id")String productName,RedirectAttributes redirect)	 
	  {
		 logger.debug("getSelectedProduct:START");
		 ModelAndView mv=new ModelAndView("redirect:/index");
		 redirect.addFlashAttribute("selectedProduct",productDAO.get(productName));
		 logger.debug("getSelectedProduct:END");
		 return mv;
	 }
	 
	 @RequestMapping("/index")
	 public String reDirectToHome(@ModelAttribute("selectedProduct") final Product selectedProduct,final Model model,HttpSession session)
	 {
		 logger.debug("reDirectToHome= STARTED");
		// session.setAttribute("selectedProduct",selectedProduct);
		 model.addAttribute("selectedProduct",selectedProduct);
		 model.addAttribute("categoryList",this.categoryDAO.list());
		 model.addAttribute("productList",this.productDAO.list());
		 
		 
		 logger.debug("reDirectToHome= END");

		 return "/index";
	 }
	 
	 @RequestMapping(value="/open_category")
	 public ModelAndView getSelectedCategory(@RequestParam("id")String categoryName){
		 
		 ModelAndView mv=new ModelAndView("/index");
		 mv.addObject("categoryName",categoryName);
		 mv.addObject("categoryList",this.categoryDAO.list());
		 mv.addObject("productList",this.productDAO.list());
		 return mv;
	 }
	 
}
