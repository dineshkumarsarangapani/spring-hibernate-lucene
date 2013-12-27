package com.lister.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lister.product.model.Product;
import com.lister.product.service.ProductService;

/**
 * @author
 * sample controller code
 */

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public ModelAndView student() {
       return new ModelAndView("addproduct", "command", new Product());
    }
    
    
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("SpringWeb")Product product, 
    ModelMap model) {
       
       productService.addProduct(product);
       model.addAttribute("name", product.getName());
       model.addAttribute("description", product.getDescription());
       model.addAttribute("id", product.getId());
       model.addAttribute("currency", product.getCurrency());
       model.addAttribute("price", product.getPrice());
       model.addAttribute("uom", product.getUom());
       model.addAttribute("category", product.getCategory());
       model.addAttribute("productList",productService.listProduct());
       
       return "viewproduct";
    }
}
