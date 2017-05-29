package com.marek.springapplication.service;

import com.marek.springapplication.dao.ContactDAO;
import com.marek.springapplication.model.Contact;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactServiceImpl implements ContactService{
    @Autowired
    private ContactDAO contactDAO;

    @Override
    @Transactional
    public List<Contact> getAllContacts() {
        return contactDAO.getAllContacts();
    }

    @Override
    public void addContact(Contact newContact) {
        
    }

    @Override
    public Contact getContact(int contactId) {
        return null;
    }

    @Override
    public void deleteContact(int contactId) {
        
    }

    @Override
    public void updateContact(Contact contact) {
        
    }
}