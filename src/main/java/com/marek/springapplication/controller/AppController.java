package com.marek.springapplication.controller;

import com.marek.springapplication.model.Contact;
import com.marek.springapplication.model.User;
import com.marek.springapplication.model.UserRole;
import com.marek.springapplication.service.ContactService;
import com.marek.springapplication.service.UserService;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
    @Autowired
    private ContactService contactService;
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/")
    public String redirectToList(){
        return "redirect:/list";
    }
    
    @RequestMapping(value = "/list")
    public String listContacts(Model model){
        List<Contact> listOfContacts = contactService.getAllContacts();
        model.addAttribute("listOfContacts", listOfContacts);

        return "home";
    }
    
    @RequestMapping(value = "/delete/{id}")
    public String deleteContact(@PathVariable("id") int id){
        contactService.deleteContact(id);
        
        return "redirect:/list";
    }
    
    @RequestMapping(value = "/edit/{id}")
    public String editContact(@PathVariable("id") int id, Model model){
        model.addAttribute("contact", contactService.getContact(id));
        
        return "newContact";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addContact(Model model){
        model.addAttribute("contact", new Contact());
        
        return "newContact";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveContact(@Valid @ModelAttribute("contact") Contact contact,
            BindingResult result){
        if (result.hasErrors()){
            return "newContact";
        }
        if (contact.getId() == 0){
            contactService.addContact(contact);
        }
        else {
            contactService.updateContact(contact);
        }
        
        return "redirect:/list";
    }
    
    @RequestMapping(value = "/admin")
    public String adminsPage(Model model){
        model.addAttribute("listOfUsers", userService.getAllUsers());
        
        return "admin";
    }
    
    @ModelAttribute("roles")
    public Set<UserRole> prepareRoles(){
        Set<UserRole> roles = new LinkedHashSet<>();
        UserRole guest = new UserRole();
        guest.setRole("ROLE_GUEST");
        roles.add(guest);
        UserRole user = new UserRole();
        user.setRole("ROLE_USER");
        roles.add(user);
        UserRole admin = new UserRole();
        admin.setRole("ROLE_ADMIN");
        roles.add(admin);
        
        return roles;
    }
    
    @RequestMapping(value = "/admin/registration", method = RequestMethod.GET)
    public String registrationForm(Model model){
        model.addAttribute("user", new User());

        return "newUser";
    }
    
    @RequestMapping(value = "/admin/registration", method = RequestMethod.POST)
    public String registerNewUser(@Valid @ModelAttribute("user") User user,
            BindingResult result, Model model){
        if (result.hasErrors()){
            return "newUser";
        }
        if (!userService.isUsernameUnique(user.getUsername())){
            result.rejectValue("username", "username.error", 
                    "This username already exists!");
            return "newUser";
        }
        user.getUserRoles().forEach((role) -> {
            role.setUsername(user);
        });
        userService.addUser(user);
        
        return "redirect:/admin";
    }
    
    @RequestMapping(value = "/admin/delete/{username}")
    public String deleteUser(@PathVariable("username") String username){
        userService.deleteUser(username);
        
        return "redirect:/admin";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout,
                Model model){
        
        if (error != null) {
            model.addAttribute("error", "Invalid username and/or password!");
	}

	if (logout != null) {
            model.addAttribute("msg", "You've been logged out successfully.");
	}
		
        return "login";
    }
    
    @RequestMapping(value = "/403")
    public String accesssDenied() {
        return "accessDenied";
    }
}
