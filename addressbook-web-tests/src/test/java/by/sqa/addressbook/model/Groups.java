package by.sqa.addressbook.model;

import by.egar.addressbook.model.Contacts;
import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Groups extends ForwardingSet<GroupData> {

    private Set<GroupData> delegate;

    public Groups(Groups groups) {
        this.delegate = new HashSet<GroupData>(groups.delegate);
    }

    public Groups(Contacts contactCache) {
        this.delegate = new HashSet<GroupData>();
    }

    public Groups(Collection<GroupData> groups) {
        this.delegate = new HashSet<GroupData>(groups);
    }

    @Override
    protected Set<GroupData> delegate() {
        return null;
    }

    public Groups withAdded(GroupData contact) {
        Groups groups = new Groups(this);
        groups.add(contact);
        return groups;
    }

    public Groups without(GroupData group) {
        Groups groups = new Groups(this);
        groups.remove(group);
        return groups;
    }
}
