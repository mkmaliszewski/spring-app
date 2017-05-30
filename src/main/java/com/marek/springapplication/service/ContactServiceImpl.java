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
    @Transactional
    public void addContact(Contact newContact) {
        contactDAO.addContact(newContact);
    }

    @Override
    @Transactional
    public Contact getContact(int contactId) {
        return contactDAO.getContact(contactId);
    }

    @Override
    @Transactional
    public void deleteContact(int contactId) {
        contactDAO.deleteContact(contactId);
    }

    @Override
    @Transactional
    public void updateContact(Contact contact) {
        contactDAO.updateContact(contact);
    }
}