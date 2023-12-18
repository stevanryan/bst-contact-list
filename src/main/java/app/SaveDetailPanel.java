package app;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SaveDetailPanel {

    public JPanel makePanel(String title, String content, int yPos) {
        JPanel panel = new JPanel(null);
        // panel putih
        panel.setBounds(0, yPos, 480, 51);
        panel.setBackground(Color.WHITE);

        // title label
        JLabel contentTitle = new JLabel(title);
        contentTitle.setFont(env.pixel16);
        contentTitle.setForeground(Color.decode(env.LIGHT_GRAY));
        contentTitle.setBounds(24, 14, 101, 24);

        // value label
        JTextField contentValue = new JTextField();
        contentValue.setBackground(Color.decode(env.MAIN_COLOR));
        contentValue.setBorder(null);
        contentValue.setFont(env.pixel16);
        contentValue.setForeground(Color.BLACK);
        contentValue.setBounds(171, 10, 300, 30); 

        panel.add(contentTitle);
        panel.add(contentValue);

        return panel;
    }

    public JPanel makePanelMobile(String title, String content, int yPos) {
        JPanel panel = new JPanel(null);
        // panel putih
        panel.setBounds(0, yPos, 480, 51);
        panel.setBackground(Color.WHITE);

        // title label
        JLabel contentTitle = new JLabel(title);
        contentTitle.setFont(env.pixel16);
        contentTitle.setForeground(Color.decode(env.NICE_BLUE));
        contentTitle.setBounds(24, 14, 101, 24);

        // value label
        JTextField contentValue = new JTextField();
        contentValue.setBackground(Color.decode(env.MAIN_COLOR));
        contentValue.setBorder(null);
        contentValue.setFont(env.pixel16);
        contentValue.setForeground(Color.BLACK);
        contentValue.setBounds(171, 10, 300, 30);

        panel.add(contentTitle);
        panel.add(contentValue);

        return panel;
    }
   
   
}
