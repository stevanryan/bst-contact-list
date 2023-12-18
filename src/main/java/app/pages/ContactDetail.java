package app.pages;

import app.Main;
import app.classes.Contact;
import app.env;
import app.style.NoScalingIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ContactDetail extends JFrame {

    public static JPanel ContactDetailPanel(Contact contact) {
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0 ,0 , 480  ,720);

        // Icon
        JLabel userLetterName = new JLabel(String.valueOf(contact.getFullName().toUpperCase().charAt(0)), SwingConstants.CENTER);
        userLetterName.setFont(env.pixel36B);
        userLetterName.setForeground(Color.decode(env.MAIN_COLOR));
        userLetterName.setBounds(160, 38, 150, 150);
        panel.add(userLetterName);

        NoScalingIcon backButton = new NoScalingIcon(env.LoadImage("assets/chevron-left-regular-240 (1).png", 48, 48));
        JLabel backLabel = new JLabel(backButton);
        backLabel.setBounds(10, 10, 48, 48);
        panel.add(backLabel);



        NoScalingIcon userProfile = new NoScalingIcon(env.LoadImage("assets/user-profile-ellipse.png", 150, 150));
        JLabel userProfileLabel = new JLabel(userProfile);
        userProfileLabel.setBounds(160, 40, 150, 150);
        panel.add(userProfileLabel);

        // Adding
        JPanel fullNamePanel = makePanel("full name", contact.getFullName());
        JPanel phoneNumberPanel = makePanel("phone number", contact.getPhoneNumber());
        JPanel emailPanel = makePanel("email", contact.getEmail());
        JPanel addressPanel = makePanel("address", contact.getAddress());
        JPanel birthDatePanel = makePanel("birth date", contact.getBirthDate());

        fullNamePanel.setBounds(20, 210, 440, 64);
        phoneNumberPanel.setBounds(20, 290, 440, 64);
        emailPanel.setBounds(20, 370, 440, 64);
        addressPanel.setBounds(20, 450, 440, 64);
        birthDatePanel.setBounds(20, 530, 440, 64);

        panel.add(fullNamePanel);
        panel.add(phoneNumberPanel);
        panel.add(emailPanel);
        panel.add(addressPanel);
        panel.add(birthDatePanel);

        // Event
        env.MouseListener(backLabel, (MouseEvent e) -> {
            ContactListPage main = new ContactListPage(env.tree);
            Main.mainFrame.dispose();
            return null;
        });

        backLabel.addMouseListener(new env.CursorPointerStyle(backLabel));

      return panel ;
    }

    public static JPanel makePanel(String title, String dataValue) {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel contentTitle = new JLabel(title);
        contentTitle.setFont(env.pixel12B);
        contentTitle.setForeground(new Color(31, 31, 31));
        contentTitle.setBounds(14, 6, 360, 28);

        JLabel contentValue = new JLabel(dataValue);
        contentValue.setFont(env.pixel16);
        contentValue.setForeground(Color.decode(env.NICE_BLUE));
        contentValue.setBounds(14, 26, 360, 28);

        panel.add(contentTitle);
        panel.add(contentValue);
        panel.setBackground(Color.decode(env.MAIN_COLOR));
        return panel;
    }

    public void main(String[] args) {
        ContactDetail contactDetail = new ContactDetail();
        contactDetail.setVisible(true);

    }
}
