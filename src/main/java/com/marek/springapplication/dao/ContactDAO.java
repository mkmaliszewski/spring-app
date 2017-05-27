package com.marek.springapplication.dao;

import com.marek.springapplication.model.Contact;
import java.util.List;

public interface ContactDAO {
    public List<Contact> getAllContacts();
    
    public void addContact(Contact newContact);
    
    public Contact getContact(int contactId);
    
    public void deleteContact(int contactId);
    
    public void updateContact(Contact contact);
}