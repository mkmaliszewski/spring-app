package service;


import dao.ContactDAO;
import java.util.List;
import model.Contact;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService{
    private ContactDAO contactDAO;

    @Override
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
