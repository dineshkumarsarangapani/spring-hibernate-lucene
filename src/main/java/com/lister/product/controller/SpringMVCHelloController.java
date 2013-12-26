package com.lister.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lister.product.model.Contact;
import com.lister.product.model.Product;
import com.lister.product.service.ContactService;

/**
 * @author
 * sample controller code
 */

@Controller
public class SpringMVCHelloController {

    @Autowired
    ContactService contactService;

    @RequestMapping("/home")
    public String printHelloWorld() {
        Contact contact = new Contact();
        contact.setId(1);
        contact.setFirstname("firstName");
        contact.setLastname("lastName");
        contactService.addContact(contact);
        return "home";
    }
    
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("SpringWeb")Product Product, 
    ModelMap model) {
       model.addAttribute("name", Product.getName());
       model.addAttribute("description", Product.getDescription());
       model.addAttribute("id", Product.getId());
       model.addAttribute("currency", Product.getCurrency());
       model.addAttribute("price", Product.getPrice());
       model.addAttribute("uom", Product.getUom());
       model.addAttribute("category", Product.getCategory());
       
       return "viewproduct";
    }
}
