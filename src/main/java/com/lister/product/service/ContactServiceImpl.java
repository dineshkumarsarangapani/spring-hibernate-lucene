package com.lister.product.service;

import com.lister.product.model.Contact;
import com.lister.product.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 *
 * contains the bussiness logic to be handled related to Contact CRUD
 */
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Override
    public void addContact(Contact contact) {
        if(contact != null)
            contactRepository.addContact(contact);
        else
            throw new NullPointerException("contact value can not be done!");

    }

    @Override
    public List<Contact> listContact() {
        return contactRepository.listContact();
    }

    @Override
    public void removeContact(Integer id) {
        if(id < 0 || id == null)
            throw new IllegalArgumentException("Id value not properly formed!");
        else
            contactRepository.removeContact(id);
    }
}
