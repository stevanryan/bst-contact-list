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

        contacts.add(new Contact("John Doe", "+62813 8264 2736", "john.doe@example.com", "1234 Elm Street, Suite 5678, South Lake, MO 54321", "1970-01-01"));
        contacts.add(new Contact("Jane Smith", "+62813 7126 6283", "jane.smith@example.com", "5678 Oak Avenue, Apt 123, North City, CA 98765", "1985-03-15"));
        contacts.add(new Contact("William Brown", "+62813 8162 2516", "william.brown@example.co.uk", "789 Maple Crescent, Room 456, West Town, NW1 2AB", "1978-07-22"));
        contacts.add(new Contact("Emily Wilson", "+62813 7524 7814", "emily.wilson@example.es", "101 Pine Lane, Apt 345, East Village, 28001 Madrid", "1992-11-05"));
        contacts.add(new Contact("Michael Lee", "+62813 9621 7246", "michael.lee@example.cn", "234 Birch Street, Floor 12, Downtown, 100001 Beijing", "1980-06-18"));
        contacts.add(new Contact("Samantha Davis", "+62813 1245 5017", "samantha.davis@example.com.au", "345 Cedar Road, Unit 789, Suburbia, NSW 2000", "1995-09-30"));
        contacts.add(new Contact("Christopher Miller", "+62813 8916", "christopher.miller@example.com", "4567 Walnut Avenue, Apt 890, Lakeside, DC 54321", "1973-04-12"));
        contacts.add(new Contact("Olivia Turner", "+62813 6712 961", "olivia.turner@example.com", "6789 Pine Street, Suite 234, Hillside, CA 98765", "1988-08-27"));
        contacts.add(new Contact("Benjamin White", "+62813 7812 7176", "benjamin.white@example.co.uk", "7890 Cedar Crescent, Room 567, South Town, NW1 2CD", "1976-02-03"));
        contacts.add(new Contact("Isabella Garcia", "+62813 9164 1246", "isabella.garcia@example.es", "8901 Oak Lane, Apt 123, North Village, 28001 Madrid", "1990-12-15"));
        contacts.add(new Contact("Ethan Anderson", "+62813 4265 8164", "ethan.anderson@example.cn", "1234 Birch Road, Floor 45, Downtown, 100001 Beijing", "1982-05-20"));
        contacts.add(new Contact("Ava Thomas", "+62813 7125 6194", "ava.thomas@example.com.au", "5678 Maple Street, Unit 789, Suburbia, NSW 2000", "1997-03-08"));
        contacts.add(new Contact("Noah Martinez", "+62813 7212 6591", "noah.martinez@example.com", "6789 Walnut Avenue, Apt 345, Lakeside, DC 54321", "1971-09-14"));
        contacts.add(new Contact("Sophia Johnson", "+62813 8126 9562", "sophia.johnson@example.com", "8901 Pine Road, Suite 567, Hillside, CA 98765", "1986-11-29"));
        contacts.add(new Contact("Liam Brown", "+62813 9164 6146", "liam.brown@example.co.uk", "1234 Cedar Crescent, Room 890, South Town, NW1 2EF", "1979-04-24"));
        contacts.add(new Contact("Mia Taylor", "+62813 5162 7591", "mia.taylor@example.es", "5678 Oak Lane, Apt 123, North Village, 28001 Madrid", "1994-08-07"));

        for (Contact i : contacts) {
            env.tree.insertContact(i);
        }
         mainFrame = new ContactListPage();
    }
}
