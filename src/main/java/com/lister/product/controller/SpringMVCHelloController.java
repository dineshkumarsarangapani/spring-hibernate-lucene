package com.lister.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
        /*Contact contact = new Contact();
        contact.setId(1);
        contact.setFirstname("firstName");
        contact.setLastname("lastName");
        contactService.addContact(contact);*/
        return "home";
    }
    
 
}
