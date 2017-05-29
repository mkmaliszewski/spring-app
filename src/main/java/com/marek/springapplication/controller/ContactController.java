package com.marek.springapplication.controller;

import com.marek.springapplication.model.Contact;
import com.marek.springapplication.service.ContactService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;
    
    @RequestMapping(value = "/")
    public ModelAndView listContacts(ModelAndView model){
        List<Contact> listOfContacts = contactService.getAllContacts();
        model.addObject("listOfContacts", listOfContacts);
        model.setViewName("/views/home.jsp");
        return model;
    }
}
