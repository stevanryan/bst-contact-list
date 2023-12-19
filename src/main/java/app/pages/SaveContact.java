package app.pages;

import app.Main;
import app.classes.Contact;
import app.env;

import app.style.NoScalingIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SaveContact extends JFrame {

    public static JPanel SaveContactPanel() {
        JPanel mainPanel = new JPanel(null);
        mainPanel.setBounds(0 ,0 , 480  ,720);

        JPanel panelFullname = SaveDetailPanel.makePanel("full name", 311);
        JPanel panelEmail = SaveDetailPanel.makePanel("email", 363);
        JPanel panelMobile = SaveDetailPanel.makePanelMobile("mobile", 458);
        JPanel panelAddress = SaveDetailPanel.makePanel("address", 510);
        JPanel panelBirthday = SaveDetailPanel.makePanel("birthday", 562);
        
        JTextField fullNameField = (JTextField) env.FindComponents(panelFullname, "fullName");
        JTextField emailField = (JTextField) env.FindComponents(panelEmail, "email");
        JTextField mobileField = (JTextField) env.FindComponents(panelMobile, "mobile");
        JTextField addressField = (JTextField) env.FindComponents(panelAddress, "address");
        JTextField birthdayField = (JTextField) env.FindComponents(panelBirthday, "birthday");

        JLabel userProfileLabel = new JLabel(new NoScalingIcon(env.LoadImage("assets/user-circle-solid-240.png", 150, 150)));
        userProfileLabel.setBounds(154 , 80, 185, 185);
        mainPanel.add(userProfileLabel);

        JLabel nameChar = new JLabel("", SwingConstants.CENTER);
        nameChar.setFont(env.pixel36B);
        nameChar.setBounds(32 , 30, 120, 120);
        nameChar.setForeground(Color.decode(env.MAIN_COLOR));
        userProfileLabel.add(nameChar);
        fullNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
                else if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE){
                    if (fullNameField.getText().equals("")) {
                        userProfileLabel.setIcon(new NoScalingIcon(env.LoadImage("assets/user-circle-solid-240.png", 150, 150)));
                        nameChar.setText("");
                    }
                }else {
                    if (!fullNameField.getText().equals("")) {
                        userProfileLabel.setIcon(new NoScalingIcon(env.LoadImage("assets/user-profile-ellipse.png", 125, 125)));
                        nameChar.setText(String.valueOf(fullNameField.getText().charAt(0)).toUpperCase());
                    }
                };
            }
        });

        //button
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setName("cancelBtn");
        cancelButton.setBounds(0, 30, 101, 24);
        cancelButton.setFont(env.pixel18);
        cancelButton.setForeground(Color.decode(env.NICE_BLUE));
        cancelButton.setContentAreaFilled(false);
        cancelButton.setBorderPainted(false);

        JButton doneButton = new JButton("Done");
        doneButton.setBounds(385, 30, 101, 24);
        doneButton.setFont(env.pixel18);
        doneButton.setForeground(Color.decode(env.NICE_BLUE));
        doneButton.setContentAreaFilled(false);
        doneButton.setBorderPainted(false);

        cancelButton.addMouseListener(new env.CursorPointerStyle(cancelButton));
        doneButton.addMouseListener(new env.CursorPointerStyle(doneButton));

        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fullName = fullNameField.getText();
                String email = emailField.getText();
                String mobile = mobileField.getText();
                String address = addressField.getText();
                String birthday = birthdayField.getText();

                Contact newContact = new Contact(fullName, mobile, email, address, birthday);

                env.tree.insertContact(newContact);

                ContactListPage main = new ContactListPage();
                Main.mainFrame.dispose();
            }
        });


        mainPanel.add(panelFullname);
        mainPanel.add(panelEmail);
        mainPanel.add(panelMobile);
        mainPanel.add(panelAddress);
        mainPanel.add(panelBirthday);
        mainPanel.add(cancelButton);
        mainPanel.add(doneButton);

        mainPanel.add(panelFullname);
        mainPanel.add(panelEmail);
        mainPanel.add(panelMobile);
        mainPanel.add(panelAddress);
        mainPanel.add(panelBirthday);
        return mainPanel;
    }

}
