package com.marek.springapplication.controller;

import com.marek.springapplication.model.Contact;
import com.marek.springapplication.service.ContactService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    
    @RequestMapping(value = "/delete/{id}")
    public String deleteContact(@PathVariable("id") int id){
        contactService.deleteContact(id);
        
        return "redirect:/";
    }
    
    @RequestMapping(value = "/edit/{id}")
    public String editContact(@PathVariable("id") int id, Model model){
        model.addAttribute("contact", contactService.getContact(id));
        
        return "newContact";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveContact(@ModelAttribute("contact") Contact contact){
        if (contact.getId() == 0){
            contactService.addContact(contact);
        }
        else {
            contactService.updateContact(contact);
        }
        
        return "redirect:/";
    }
    
    @RequestMapping(value = "/add")
    public String addContact(Model model){
        model.addAttribute("contact", new Contact());
        
        return "newContact";
    }
}
