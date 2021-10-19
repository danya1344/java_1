package by.egar.addressbook.appmanager;

import by.egar.addressbook.model.ContactDatas;
import by.egar.addressbook.model.Contacts;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class DbHelpers {

    private final SessionFactory sessionFactory;

    public DbHelpers(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }
    public Contacts contacts() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<ContactDatas> result = session.createQuery("from ContactDatas where deprecated = '0000-00-00' ").list();
        session.getTransaction().commit();
        session.close();
        return new Contacts(result);
    }
}