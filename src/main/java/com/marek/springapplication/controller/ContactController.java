package com.marek.springapplication.controller;

import com.marek.springapplication.model.Contact;
import com.marek.springapplication.service.ContactService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;
    
    @RequestMapping(value = "/")
    public String listContacts(Model model){
        List<Contact> listOfContacts = contactService.getAllContacts();
        model.addAttribute("listOfContacts", listOfContacts);
        
        return "home";
    }
    
    @RequestMapping(value = "/deleteContact/{id}")
    public String deleteContact(@PathVariable("id") int id){
        contactService.deleteContact(id);
        
        return "redirect:/";
    }
}
