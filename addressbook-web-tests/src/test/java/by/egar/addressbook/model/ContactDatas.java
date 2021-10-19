package by.egar.addressbook.model;

import by.sqa.addressbook.model.GroupData;
import by.sqa.addressbook.model.Groups;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactDatas {

    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "home")
    @Type(type = "text")
    private String home;

    @Column(name = "mobile")
    @Type(type = "text")
    private String mobile;

    @Column(name = "work")
    @Type(type = "text")
    private String work;

    @Transient
    private String allPhones;

    @Column(name = "email")
    @Type(type = "text")
    private String email;

    @Column(name = "email2")
    @Type(type = "text")
    private String email2;

    @Column(name = "email3")
    @Type(type = "text")
    private String email3;

    @Transient
    private String allEmails;

    @Column(name = "address")
    @Type(type = "text")
    private String address;

    @Column(name = "photo")
    @Type(type = "text")
    private String photo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "address_in_groups",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupData> groups = new HashSet<GroupData>();


    public int getId() {
        return id;
    }

    public ContactDatas withId(int id) {
        this.id = id;
        return this;
    }

    public ContactDatas withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactDatas withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactDatas withHomePhone(String home) {
        this.home = home;
        return this;
    }

    public ContactDatas withMobilePhone(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public ContactDatas withWorkPhone(String work) {
        this.work = work;
        return this;
    }

    public ContactDatas withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactDatas withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactDatas withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactDatas withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactDatas withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactDatas withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactDatas withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    public Groups getGroups() {
        return new Groups(groups);
    }


    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getHomePhone() {
        return home;
    }

    public String getMobilePhone() {
        return mobile;
    }

    public String getWorkPhone() {
        return work;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public String getAddress() {
        return address;
    }

    public File getPhoto() {
        return new File(photo);
    }


    @Override
    public String toString() {
        return "ContactDatas{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactDatas that = (ContactDatas) o;
        return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(group, that.group) && Objects.equals(home, that.home) && Objects.equals(mobile, that.mobile) && Objects.equals(work, that.work) && Objects.equals(allPhones, that.allPhones) && Objects.equals(email, that.email) && Objects.equals(email2, that.email2) && Objects.equals(email3, that.email3) && Objects.equals(allEmails, that.allEmails) && Objects.equals(address, that.address) && Objects.equals(photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, home, mobile, work, email, email2, email3, address, photo);
    }
}