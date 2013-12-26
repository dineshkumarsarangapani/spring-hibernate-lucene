package com.lister.product.repository;

import com.lister.product.model.Contact;

import java.util.List;

public interface ContactRepository {
    public void addContact(Contact contact);
    public List<Contact> listContact();
    public void removeContact(Integer id);
}
