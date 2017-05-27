package dao;

import java.util.List;
import model.Contact;

public interface ContactDAO {
    public List<Contact> getAllContacts();
    
    public void addContact(Contact newContact);
    
    public Contact getContact(int contactId);
    
    public void deleteContact(int contactId);
    
    public void updateContact(Contact contact);
}
