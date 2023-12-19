package app.pages;

import app.env;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SaveDetailPanel {

    public static JPanel makePanel(String title, int yPos) {
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
        if (title.equals("full name")) {
            contentValue.setName("fullName");
        } else if (title.equals("email")) {
            contentValue.setName("email");
        } else if (title.equals("mobile")) {
            contentValue.setName("mobile");
        } else if (title.equals("address")) {
            contentValue.setName("address");
        } else if (title.equals("birthday")) {
            contentValue.setName("birthday");
        }
        contentValue.setBackground(Color.decode(env.MAIN_COLOR));
        contentValue.setBorder(null);
        contentValue.setFont(env.pixel16);
        contentValue.setForeground(Color.BLACK);
        contentValue.setBounds(171, 10, 300, 30); 

        panel.add(contentTitle);
        panel.add(contentValue);

        return panel;
    }

    public static JPanel makePanelMobile(String title, int yPos) {
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
        contentValue.setName("mobile");
        contentValue.setBackground(Color.decode(env.MAIN_COLOR));
        contentValue.setForeground(Color.decode(env.NICE_BLUE));
        contentValue.setBorder(null);
        contentValue.setFont(env.pixel16);
        contentValue.setBounds(204, 10, 280, 30);

        JLabel enamDua = new JLabel("+62");
        enamDua.setFont(env.pixel16);
        enamDua.setForeground(Color.decode(env.NICE_BLUE));
        enamDua.setBounds(171, 10, 42, 30);


        contentValue.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (Character.isDigit(e.getKeyChar())) {
                } else e.consume();
            }
        });
        panel.add(enamDua);
        panel.add(contentTitle);
        panel.add(contentValue);

        return panel;
    }
   
   
}
