package by.egar.addressbook.generators;

import by.egar.addressbook.model.ContactDatas;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDatasGeneration {

    @Parameter(names = "-c", description = "Contact count")
    private int count;

    @Parameter(names = "-f", description = "Target file")
    private String file;

    public static void main(String[] args) throws IOException {
        ContactDatasGeneration generation = new ContactDatasGeneration();
        JCommander jCommander = new JCommander(generation);
        try {
            JCommander.parse(args);
        } catch (ParameterException ex) {
            JCommander.usage();
            return;
        }
        generation.run();
    }

    private void run() throws IOException {
        List<ContactDatas> contacts = generateContacts(count);
        save(contacts, new File(file));
    }

    private void save(List<ContactDatas> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (ContactDatas contact : contacts) {
            writer.write(String.format("%s:%s:%s:%s\n", contact.getFirstname(), contact.getLastname(), contact.getAllEmails(),contact.getAllPhones()));
        }
        writer.close();
    }

    public List<ContactDatas> generateContacts(int count) {
        List<ContactDatas> contacts = new ArrayList<ContactDatas>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactDatas().withFirstname(String.format("daniil %s", i))
                    .withLastname(String.format("lastname %s", i))
                    .withAllEmails(String.format("allEmail %s", i))
                    .withAllPhones(String.format("allPhones %s", i)));
        }
        return contacts;
    }
}
