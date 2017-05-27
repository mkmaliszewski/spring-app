package dao;

import java.util.List;
import model.Contact;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDAOImpl implements ContactDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Contact> getAllContacts() {
        return sessionFactory.getCurrentSession().createQuery("from contacts")
                .list();
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
