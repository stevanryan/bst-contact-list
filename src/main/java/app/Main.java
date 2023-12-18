package app;

import app.classes.Contact;
import app.classes.TreeContact;
import app.pages.ContactListPage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static JFrame mainFrame ;
    public static void main(String[] args) {
        env.tree = new TreeContact();

        java.util.List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Jessica Turner", "+1 (555) 123-4567", "jessica.turner@email.com", "123 Main Street, Cityville, State, 12345", "January 15, 1985"));
        contacts.add(new Contact("Alex Johnson", "+44 20 7123 4567", "alex.johnson@email.co.uk", "456 Oak Avenue, Townsville, County, AB12 CD34", "March 22, 1990"));
        contacts.add(new Contact("Carlos Ramirez", "+34 123 456 789", "carlos.ramirez@email.es", "789 Elm Street, Villagetown, Province, 56789", "November 5, 1982"));
        contacts.add(new Contact("Emily Chen", "+86 10 8765 4321", "emily.chen@email.cn", "101 Pine Lane, Metropolis, Region, 100001", "July 12, 1993"));
        contacts.add(new Contact("David Smith", "+61 2 9876 5432", "david.smith@email.com.au", "234 Maple Road, Suburbia, Territory, 2000", "September 30, 1988"));
        
        for (Contact i : contacts) {
            env.tree.insertContact(i);
        }
        env.tree.inOrder(env.tree.getRoot());
         mainFrame = new ContactListPage(env.tree);
    }
}
