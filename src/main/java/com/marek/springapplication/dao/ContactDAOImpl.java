package com.marek.springapplication.dao;

import com.marek.springapplication.model.Contact;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDAOImpl implements ContactDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Contact> getAllContacts() {
        Session session = sessionFactory.getCurrentSession();
        List<Contact> listOfContacts = session.createQuery("from Contact").list();
        return listOfContacts;
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
        Session session = sessionFactory.getCurrentSession();
        Contact contact = session.load(Contact.class, contactId);
        if (contact != null){
            session.delete(contact);
        }
    }

    @Override
    public void updateContact(Contact contact) {
        
    } 
}