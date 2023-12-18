package app.pages;

import app.env;

import app.style.NoScalingIcon;

import javax.swing.*;
import java.awt.*;

public class SaveContact extends JFrame {

    public static JPanel SaveContactPanel() {
        JPanel mainPanel = new JPanel(null);
        mainPanel.setBounds(0 ,0 , 480  ,720);

        JPanel panelFullname = SaveDetailPanel.makePanel("Fullname", "alekyan", 311);
        JPanel panelEmail = SaveDetailPanel.makePanel("email", "alekyan@gmail.com", 363);
        JPanel panelMobile = SaveDetailPanel.makePanelMobile("mobile", "08123456789", 458);
        JPanel panelAddress = SaveDetailPanel.makePanel("address", "Jl.Jogja", 510);
        JPanel panelBirthday = SaveDetailPanel.makePanel("birthday", "12 Desember 2023", 562);

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

        NoScalingIcon userProfile = new NoScalingIcon(env.LoadImage("assets/user-profile-ellipse.png", 150, 150));
        JLabel userProfileLabel = new JLabel(userProfile);
        userProfileLabel.setBounds(154 , 80, 185, 185);
        mainPanel.add(userProfileLabel);

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
