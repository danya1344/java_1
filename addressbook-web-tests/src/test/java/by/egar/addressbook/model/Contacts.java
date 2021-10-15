package by.egar.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Contacts extends ForwardingSet<ContactDatas> {

    private Set<ContactDatas> delegate;

    public Contacts(Contacts contacts) {
        this.delegate = new HashSet<ContactDatas>(contacts.delegate);
    }

    public Contacts() {
        this.delegate = new HashSet<ContactDatas>();
    }

    @Override
    protected Set<ContactDatas> delegate() {
        return null;
    }

    public Contacts withAdded(ContactDatas contact) {
        Contacts contacts = new Contacts(this);
        contacts.add(contact);
        return contacts;
    }

    public Contacts without(ContactDatas contact) {
        Contacts contacts = new Contacts(this);
        contacts.remove(contact);
        return contacts;
    }
}
