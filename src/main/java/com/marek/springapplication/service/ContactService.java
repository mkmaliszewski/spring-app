package com.marek.springapplication.service;

import com.marek.springapplication.model.Contact;
import java.util.List;

public interface ContactService {
    public List<Contact> getAllContacts();
    
    public void addContact(Contact newContact);
    
    public Contact getContact(int contactId);
    
    public void deleteContact(int contactId);
    
    public void updateContact(Contact contact);
}