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

        JTextField fullNameField = (JTextField) env.FindComponents(fullNamePanel, "fullName");
        JTextField phoneNumberField = (JTextField) env.FindComponents(phoneNumberPanel, "phoneNumber");
        JTextField emailField = (JTextField) env.FindComponents(emailPanel, "email");
        JTextField addressField = (JTextField) env.FindComponents(addressPanel, "address");
        JTextField birthdateField = (JTextField) env.FindComponents(birthDatePanel, "birthDate");

        JButton updateButton = new JButton("Edit Contact");
        updateButton.setFont(env.pixel12B);
        updateButton.setBackground(Color.decode(env.MAIN_COLOR));
        updateButton.setForeground(Color.decode(env.NICE_BLUE));
        updateButton.setBorder(null);
        updateButton.setBounds(20,650, 215, 32);
        updateButton.setVisible(true);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFont(env.pixel12B);
        cancelButton.setBackground(Color.decode(env.MAIN_COLOR));
        cancelButton.setForeground(Color.decode(env.NICE_RED));
        cancelButton.setBorder(null);
        cancelButton.setBounds(20,650, 215, 32);
        cancelButton.setVisible(false);

        JButton deleteButton = new JButton("Delete Contact");
        deleteButton.setFont(env.pixel12B);
        deleteButton.setBackground(Color.decode(env.MAIN_COLOR));
        deleteButton.setForeground(Color.decode(env.NICE_RED));
        deleteButton.setBorder(null);
        deleteButton.setBounds(244, 650, 215, 32);
        deleteButton.setVisible(true);

        JButton saveButton = new JButton("Save Changes");
        saveButton.setFont(env.pixel12B);
        saveButton.setBackground(Color.decode(env.MAIN_COLOR));
        saveButton.setForeground(Color.decode(env.NICE_GREEN));
        saveButton.setBorder(null);
        saveButton.setBounds(244, 650, 215, 32);
        saveButton.setVisible(false);

        env.ActionListener(updateButton, (ActionEvent e) -> {
            updateButton.setVisible(false);
            deleteButton.setVisible(false);
            saveButton.setVisible(true);
            cancelButton.setVisible(true);

            fullNameField.setEditable(true);
            phoneNumberField.setEditable(true);
            emailField.setEditable(true);
            addressField.setEditable(true);
            birthdateField.setEditable(true);

            fullNameField.setForeground(Color.decode(env.DARK_COLOR));
            phoneNumberField.setForeground(Color.decode(env.DARK_COLOR));
            emailField.setForeground(Color.decode(env.DARK_COLOR));
            addressField.setForeground(Color.decode(env.DARK_COLOR));
            birthdateField.setForeground(Color.decode(env.DARK_COLOR));
            return null;
        });

        env.ActionListener(cancelButton, (ActionEvent e) -> {
            updateButton.setVisible(true);
            deleteButton.setVisible(true);
            saveButton.setVisible(false);
            cancelButton.setVisible(false);

            fullNameField.setEditable(false);
            phoneNumberField.setEditable(false);
            emailField.setEditable(false);
            addressField.setEditable(false);
            birthdateField.setEditable(false);

            fullNameField.setText(contact.getFullName());
            phoneNumberField.setText(contact.getPhoneNumber());
            emailField.setText(contact.getEmail());
            addressField.setText(contact.getAddress());
            birthdateField.setText(contact.getBirthDate());

            fullNameField.setForeground(Color.decode(env. NICE_BLUE));
            phoneNumberField.setForeground(Color.decode(env.  NICE_BLUE));
            emailField.setForeground(Color.decode(env.NICE_BLUE));
            addressField.setForeground(Color.decode(env.  NICE_BLUE));
            birthdateField.setForeground(Color.decode(env.NICE_BLUE));
            return null;
        });

        env.ActionListener(saveButton, (ActionEvent e) -> {

            contact.setFullName(fullNameField.getText());
            contact.setPhoneNumber(phoneNumberField.getText());
            contact.setEmail(emailField.getText());
            contact.setAddress(addressField.getText());
            contact.setBirthDate(birthdateField.getText());

            ContactListPage main = new ContactListPage();
            Main.mainFrame.dispose();

            return null;
        });


        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(saveButton);
        panel.add(cancelButton);

        // Event
        env.MouseListener(backLabel, (MouseEvent e) -> {
            ContactListPage main = new ContactListPage();
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

        JTextField contentValue = new JTextField(dataValue);
        contentValue.setFont(env.pixel16);
        contentValue.setForeground(Color.decode(env.NICE_BLUE));
        contentValue.setBounds(14, 26, 410, 28);
        contentValue.setEditable(false);
        contentValue.setBorder(null);
        contentValue.setBackground(Color.decode(env.MAIN_COLOR));

        if (title.equals("full name")) {
            contentValue.setName("fullName");
        } else if (title.equals("phone number")) {
            contentValue.setName("phoneNumber");
        } else if (title.equals("email")) {
            contentValue.setName("email");
        } else if (title.equals("address")) {
            contentValue.setName("address");
        } else if (title.equals("birth date")) {
            contentValue.setName("birthDate");
        }

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
